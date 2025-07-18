package com.hunterparcells.huntercomponents.common.component.display;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.hunterparcells.huntercomponents.common.HunterComponents;

/**
 * Meta information about the TagCounter component.  See {@link Image} for docs on each field.
 */
public class TagCounter {
    public static String COMPONENT_ID = "rad.display.tagcounter";

    public static JsonSchema SCHEMA =
        JsonSchema.parse(HunterComponents.class.getResourceAsStream("/tagcounter.props.json"));

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(SCHEMA) //  this could alternatively be created purely in Java if desired
        .setName("Tag Counter")
        .addPaletteEntry("", "Tag Counter", "A component that displays the number of tags associated with a gateway.", null, null)
        .setDefaultMetaName("tagCounter")
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();

}
