package com.hunterparcells.huntercomponents.designer;

import com.hunterparcells.huntercomponents.common.component.container.DragRepeater;
import com.hunterparcells.huntercomponents.common.component.ui.Alert;
import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.perspective.designer.DesignerComponentRegistry;
import com.inductiveautomation.perspective.designer.api.ComponentDesignDelegateRegistry;
import com.inductiveautomation.perspective.designer.api.PerspectiveDesignerInterface;
import com.hunterparcells.huntercomponents.common.component.input.Button;

public class DesignerHook extends AbstractDesignerModuleHook {
    private static final LoggerEx logger = LoggerEx.newBuilder().build("HunterComponents");

    private DesignerContext context;
    private DesignerComponentRegistry registry;
    private ComponentDesignDelegateRegistry delegateRegistry;
 
    static {
        BundleUtil.get().addBundle("huntercomponents", DesignerHook.class.getClassLoader(), "huntercomponents");
    }

    public DesignerHook() {
        logger.info("Registering Hunter's Components in Designer!");
    }

    private void init() {
        logger.debug("Initializing registry entrants...");

        PerspectiveDesignerInterface pdi = PerspectiveDesignerInterface.get(context);

        registry = pdi.getDesignerComponentRegistry();
        delegateRegistry = pdi.getComponentDesignDelegateRegistry();

        registry.registerComponent(Button.DESCRIPTOR);
        registry.registerComponent(DragRepeater.DESCRIPTOR);
        registry.registerComponent(Alert.DESCRIPTOR);
    }

    private void removeComponents() {
        registry.removeComponent(Button.COMPONENT_ID);
        registry.removeComponent(DragRepeater.COMPONENT_ID);
        registry.removeComponent(Alert.COMPONENT_ID);
    }
    
    @Override
    public void startup(DesignerContext context, LicenseState activationState) {
        this.context = context;
        init();
    }

    @Override
    public void shutdown() {
        removeComponents();
    }
}
