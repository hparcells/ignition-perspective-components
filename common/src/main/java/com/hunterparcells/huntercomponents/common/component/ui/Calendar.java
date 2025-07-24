package com.hunterparcells.huntercomponents.common.component.ui;

import com.hunterparcells.huntercomponents.common.ComponentIcon;
import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.inductiveautomation.perspective.common.api.ComponentEventDescriptor;

import java.util.List;

public class Calendar {
    public static final String COMPONENT_ID = "hc.ui.calendar";

    private static final String PROPS_SCHEMA_PATH = "/props/calendar.props.json";

    private static final String COMPONENT_NAME = "Calendar";
    private static final String COMPONENT_DESCRIPTION = "Calendar component.";
    private static final String COMPONENT_DEFAULT_NAME = "Calendar";

    static ComponentEventDescriptor eventClickDescriptor = ComponentUtilities.getEventDescriptor(
        "events/calendar/onEventClick.json"
    );
    private static final List<ComponentEventDescriptor> events = List.of(eventClickDescriptor);


    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(ComponentUtilities.getSchemaFromFilePath(PROPS_SCHEMA_PATH))
        .setName(COMPONENT_NAME)
        .setEvents(events)
        .addPaletteEntry("", COMPONENT_NAME, COMPONENT_DESCRIPTION, null, null)
        .setIcon(ComponentIcon.CALENDAR.getIcon())
        .setDefaultMetaName(COMPONENT_DEFAULT_NAME)
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();
}
