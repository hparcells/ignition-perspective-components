package com.hunterparcells.huntercomponents.common.component.input;

import java.util.List;

import com.hunterparcells.huntercomponents.common.ComponentIcon;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.inductiveautomation.perspective.common.api.ComponentEventDescriptor;
import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;

public class Button  {
    public static final String COMPONENT_ID = "hc.input.button";

    private static final String PROPS_SCHEMA_PATH = "/props/button.props.json";

    private static final String COMPONENT_NAME = "Button";
    private static final String COMPONENT_DESCRIPTION = "An opinionated button component.";
    private static final String COMPONENT_DEFAULT_NAME = "BtnButton";

    static ComponentEventDescriptor actionPerformedDescriptor = ComponentUtilities.getEventDescriptor(
        "events/button/onActionPerformed.json",
        "onActionPerformed",
        "This event is fired when the button is clicked."
    );
    private static final List<ComponentEventDescriptor> events = List.of(actionPerformedDescriptor);

    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
        .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
        .setId(COMPONENT_ID)
        .setModuleId(HunterComponents.MODULE_ID)
        .setSchema(ComponentUtilities.getSchemaFromFilePath(PROPS_SCHEMA_PATH))
        .setName(COMPONENT_NAME)
        .setEvents(events)
        .addPaletteEntry("", COMPONENT_NAME, COMPONENT_DESCRIPTION, null, null)
        .setIcon(ComponentIcon.BUTTON.getIcon())
        .setDefaultMetaName(COMPONENT_DEFAULT_NAME)
        .setResources(HunterComponents.BROWSER_RESOURCES)
        .build();
}
