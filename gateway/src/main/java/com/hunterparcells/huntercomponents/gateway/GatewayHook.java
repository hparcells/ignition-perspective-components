package com.hunterparcells.huntercomponents.gateway;

import java.util.Optional;

import com.hunterparcells.huntercomponents.common.component.container.DragRepeater;
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


        if (this.componentRegistry != null) {
            log.info("Registering Hunter's Components.");
            this.componentRegistry.registerComponent(Button.DESCRIPTOR);
            this.componentRegistry.registerComponent(DragRepeater.DESCRIPTOR);
        } else {
            log.error("Reference to component registry not found, Hunter's Components will fail to function!");
        }
    }

    @Override
    public void shutdown() {
        log.info("Shutting down RadComponent module and removing registered components.");
        if (this.componentRegistry != null) {
            this.componentRegistry.removeComponent(Button.COMPONENT_ID);
            this.componentRegistry.removeComponent(DragRepeater.COMPONENT_ID);
        } else {
            log.warn("Component registry was null, could not unregister Hunter's Components.");
        }
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
