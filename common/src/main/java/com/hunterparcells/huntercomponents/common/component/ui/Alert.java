package com.hunterparcells.huntercomponents.common.component.ui;

import com.hunterparcells.huntercomponents.common.ComponentIcon;
import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.inductiveautomation.perspective.common.api.ComponentEventDescriptor;

import java.util.List;

public class Alert {
    public static final String COMPONENT_ID = "hc.ui.alert";

    private static final String PROPS_SCHEMA_PATH = "/props/alert.props.json";

    private static final String COMPONENT_NAME = "Alert";
    private static final String COMPONENT_DESCRIPTION = "An on-page alert.";
    private static final String COMPONENT_DEFAULT_NAME = "Alert";

    static ComponentEventDescriptor onDismissDescriptor = ComponentUtilities.getEventDescriptor(
            "events/alert/onDismiss.json"
    );
    private static final List<ComponentEventDescriptor> events = List.of(onDismissDescriptor);

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(ComponentUtilities.getSchemaFromFilePath(PROPS_SCHEMA_PATH))
        .setName(COMPONENT_NAME)
        .setEvents(events)
        .addPaletteEntry("", COMPONENT_NAME, COMPONENT_DESCRIPTION, null, null)
        .setIcon(ComponentIcon.ALERT.getIcon())
        .setDefaultMetaName(COMPONENT_DEFAULT_NAME)
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();
}
