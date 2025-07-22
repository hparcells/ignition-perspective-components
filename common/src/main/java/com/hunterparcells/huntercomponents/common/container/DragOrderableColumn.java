package com.hunterparcells.huntercomponents.common.container;

import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.ComponentIcon;
import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;

public class DragOrderableColumn {
    public static final String COMPONENT_ID = "hc.container.dragcolumn";

    private static final String PROPS_SCHEMA_PATH = "/props/dragcolumn.props.json";

    private static final String COMPONENT_NAME = "Drag Orderable Column";
    private static final String COMPONENT_DESCRIPTION = "Column orderable by drag-and-drop.";
    private static final String COMPONENT_DEFAULT_NAME = "CtnContainer";

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(ComponentUtilities.getSchemaFromFilePath(PROPS_SCHEMA_PATH))
        .setName(COMPONENT_NAME)
        .addPaletteEntry("", COMPONENT_NAME, COMPONENT_DESCRIPTION, null, null)
        .setIcon(ComponentIcon.DRAG_ORDERABLE_COLUMN.getIcon())
        .setDefaultMetaName(COMPONENT_DEFAULT_NAME)
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();
}
