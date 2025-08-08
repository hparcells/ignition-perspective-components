package com.hunterparcells.huntercomponents.gateway;

import java.util.Optional;

import com.hunterparcells.huntercomponents.common.component.container.DragRepeater;
import com.hunterparcells.huntercomponents.common.component.input.DebouncedTextField;
import com.hunterparcells.huntercomponents.common.component.input.SequentialMonthPicker;
import com.hunterparcells.huntercomponents.common.component.ui.Alert;
import com.hunterparcells.huntercomponents.common.component.ui.BigNumber;
import com.hunterparcells.huntercomponents.common.component.ui.Calendar;
import com.hunterparcells.huntercomponents.common.expressionfunction.Pluralize;
import com.hunterparcells.huntercomponents.common.expressionfunction.PluralizeOrSingularize;
import com.hunterparcells.huntercomponents.common.expressionfunction.Singularize;
import com.inductiveautomation.ignition.common.expressions.ExpressionFunctionManager;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.gateway.dataroutes.RouteGroup;
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import com.inductiveautomation.perspective.common.api.ComponentRegistry;
import com.inductiveautomation.perspective.gateway.api.PerspectiveContext;
import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.component.input.Button;
import com.hunterparcells.huntercomponents.gateway.endpoint.DataEndpoints;

public class GatewayHook extends AbstractGatewayModuleHook {
    private static final LoggerEx log = LoggerEx.newBuilder().build("rad.gateway.GatewayHook");

    private GatewayContext gatewayContext;
    private PerspectiveContext perspectiveContext;
    private ComponentRegistry componentRegistry;

    @Override
    public void setup(GatewayContext context) {
        this.gatewayContext = context;
        log.info("Setting up HunterComponents module.");
    }

    @Override
    public void startup(LicenseState activationState) {
        log.info("Starting up GatewayHook!");

        this.perspectiveContext = PerspectiveContext.get(this.gatewayContext);
        this.componentRegistry = this.perspectiveContext.getComponentRegistry();


        if(this.componentRegistry != null) {
            log.info("Registering Hunter's Components.");
            this.componentRegistry.registerComponent(new Button().getDescriptor());
            this.componentRegistry.registerComponent(new DragRepeater().getDescriptor());
            this.componentRegistry.registerComponent(new Alert().getDescriptor());
            this.componentRegistry.registerComponent(new DebouncedTextField().getDescriptor());
            this.componentRegistry.registerComponent(new BigNumber().getDescriptor());
            this.componentRegistry.registerComponent(new Calendar().getDescriptor());
            this.componentRegistry.registerComponent(new SequentialMonthPicker().getDescriptor());
        }else {
            log.error("Reference to component registry not found, Hunter's Components will fail to function!");
        }
    }

    @Override
    public void shutdown() {
        log.info("Shutting down RadComponent module and removing registered components.");
        if(this.componentRegistry != null) {
            this.componentRegistry.removeComponent(new Button().getNamespacedId());
            this.componentRegistry.removeComponent(new DragRepeater().getNamespacedId());
            this.componentRegistry.removeComponent(new Alert().getNamespacedId());
            this.componentRegistry.removeComponent(new DebouncedTextField().getNamespacedId());
            this.componentRegistry.removeComponent(new BigNumber().getNamespacedId());
            this.componentRegistry.removeComponent(new Calendar().getNamespacedId());
            this.componentRegistry.removeComponent(new SequentialMonthPicker().getNamespacedId());
        }else {
            log.warn("Component registry was null, could not unregister Hunter's Components.");
        }
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
    public Optional<String> getMountedResourceFolder() {
        return Optional.of("mounted");
    }

    @Override
    public void mountRouteHandlers(RouteGroup routeGroup) {
        DataEndpoints.mountRoutes(routeGroup);
    }

    @Override
    public Optional<String> getMountPathAlias() {
        return Optional.of(HunterComponents.URL_ALIAS);
    }

    @Override
    public boolean isFreeModule() {
        return true;
    }
}
