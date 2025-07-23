package com.hunterparcells.huntercomponents.common.component.ui;

import com.hunterparcells.huntercomponents.common.ComponentIcon;
import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.inductiveautomation.perspective.common.api.ComponentEventDescriptor;

import java.util.List;

public class BigNumber {
    public static final String COMPONENT_ID = "hc.ui.bignumber";

    private static final String PROPS_SCHEMA_PATH = "/props/bignumber.props.json";

    private static final String COMPONENT_NAME = "Big Number";
    private static final String COMPONENT_DESCRIPTION = "Emphasized statistic.";
    private static final String COMPONENT_DEFAULT_NAME = "Big Number";

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(ComponentUtilities.getSchemaFromFilePath(PROPS_SCHEMA_PATH))
        .setName(COMPONENT_NAME)
        .addPaletteEntry("", COMPONENT_NAME, COMPONENT_DESCRIPTION, null, null)
        .setIcon(ComponentIcon.BIG_NUMBER.getIcon())
        .setDefaultMetaName(COMPONENT_DEFAULT_NAME)
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();
}
