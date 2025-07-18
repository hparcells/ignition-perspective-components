package com.hunterparcells.huntercomponents.common.component.display;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.hunterparcells.huntercomponents.common.HunterComponents;

public class Button  {
    public static String COMPONENT_ID = "hc.display.button";

    public static JsonSchema SCHEMA =
        JsonSchema.parse(HunterComponents.class.getResourceAsStream("/button.props.json"));

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(SCHEMA) //  this could alternatively be created purely in Java if desired
        .setName("Button")
        .addPaletteEntry("", "Button", "An opinionated button.", null, null)
        .setDefaultMetaName("BtnNAME")
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();
}
