package com.hunterparcells.huntercomponents.common.component.container;

import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.ComponentIcon;
import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;
import com.inductiveautomation.ignition.common.gson.JsonObject;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;

public class DragRepeater {
    public static final String COMPONENT_ID = "hc.container.dragrepeater";

    private static final String PROPS_SCHEMA_PATH = "/props/dragrepeater.props.json";

    private static final String COMPONENT_NAME = "Drag Repeater";
    private static final String COMPONENT_DESCRIPTION = "Repeater orderable by drag-and-drop.";
    private static final String COMPONENT_DEFAULT_NAME = "CtnContainer";

    private static JsonObject columnProps() {
        JsonObject props = new JsonObject();
        props.addProperty("direction", "column");
        return props;
    }

    private static JsonObject rowProps() {
        JsonObject props = new JsonObject();
        props.addProperty("direction", "row");
        return props;
    }

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(ComponentUtilities.getSchemaFromFilePath(PROPS_SCHEMA_PATH))
        .setName(COMPONENT_NAME)
        .addPaletteEntry(
                "",
                COMPONENT_NAME,
                COMPONENT_DESCRIPTION,
                null,
                columnProps()
        )
        .addPaletteEntry(
                "row",
                COMPONENT_NAME + " (Row)",
                COMPONENT_DESCRIPTION,
                null,
                rowProps()
        )
        .setIcon(ComponentIcon.DRAG_REPEATER.getIcon())
        .setDefaultMetaName(COMPONENT_DEFAULT_NAME)
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();
}
