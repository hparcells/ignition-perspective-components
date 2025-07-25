package com.hunterparcells.huntercomponents.common.component.input;

import com.hunterparcells.huntercomponents.common.ComponentIcon;
import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;

public class SequentialMonthPicker {
    public static final String COMPONENT_ID = "hc.input.sequentialmonthpicker";

    private static final String PROPS_SCHEMA_PATH = "/props/sequentialmonthpicker.props.json";

    private static final String COMPONENT_NAME = "Sequential Month Picker";
    private static final String COMPONENT_DESCRIPTION = "Month picker with increment and decrement buttons.";
    private static final String COMPONENT_DEFAULT_NAME = "MonthPicker";

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(ComponentUtilities.getSchemaFromFilePath(PROPS_SCHEMA_PATH))
        .setName(COMPONENT_NAME)
        .addPaletteEntry("", COMPONENT_NAME, COMPONENT_DESCRIPTION, null, null)
        .setIcon(ComponentIcon.SEQUENTIAL_MONTH_PICKER.getIcon())
        .setDefaultMetaName(COMPONENT_DEFAULT_NAME)
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();
}
