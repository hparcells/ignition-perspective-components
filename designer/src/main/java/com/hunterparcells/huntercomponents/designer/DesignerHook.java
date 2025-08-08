package com.hunterparcells.huntercomponents.designer;

import com.hunterparcells.huntercomponents.common.component.container.DragRepeater;
import com.hunterparcells.huntercomponents.common.component.input.DebouncedTextField;
import com.hunterparcells.huntercomponents.common.component.input.SequentialMonthPicker;
import com.hunterparcells.huntercomponents.common.component.ui.Alert;
import com.hunterparcells.huntercomponents.common.component.ui.BigNumber;
import com.hunterparcells.huntercomponents.common.component.ui.Calendar;
import com.hunterparcells.huntercomponents.common.expressionfunction.Pluralize;
import com.hunterparcells.huntercomponents.common.expressionfunction.PluralizeOrSingularize;
import com.hunterparcells.huntercomponents.common.expressionfunction.Singularize;
import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.expressions.ExpressionFunctionManager;
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

        registry.registerComponent(new Button().getDescriptor());
        registry.registerComponent(new DragRepeater().getDescriptor());
        registry.registerComponent(new Alert().getDescriptor());
        registry.registerComponent(new DebouncedTextField().getDescriptor());
        registry.registerComponent(new BigNumber().getDescriptor());
        registry.registerComponent(new Calendar().getDescriptor());
        registry.registerComponent(new SequentialMonthPicker().getDescriptor());
    }

    private void removeComponents() {
        registry.removeComponent(new Button().getNamespacedId());
        registry.removeComponent(new DragRepeater().getNamespacedId());
        registry.removeComponent(new Alert().getNamespacedId());
        registry.removeComponent(new DebouncedTextField().getNamespacedId());
        registry.removeComponent(new BigNumber().getNamespacedId());
        registry.removeComponent(new Calendar().getNamespacedId());
        registry.removeComponent(new SequentialMonthPicker().getNamespacedId());
    }

    @Override
    public void configureFunctionFactory(ExpressionFunctionManager factory) {
        factory.getCategories().add("Hunter");

        factory.addFunction("pluralize", "Hunter", new Pluralize());
        factory.addFunction("singularize", "Hunter", new Singularize());
        factory.addFunction("pluralizeOrSingularize", "Hunter", new PluralizeOrSingularize());
        super.configureFunctionFactory(factory);
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
