package com.hunterparcells.huntercomponents.common.util;

import com.inductiveautomation.perspective.common.api.ComponentEventDescriptor;

public class DynamicEventDescriptor extends ComponentEventDescriptor {
    public DynamicEventDescriptor(String filePath, String eventName) {
        super(eventName, ComponentUtilities.getSchemaFromFilePath(filePath));
    }
}
