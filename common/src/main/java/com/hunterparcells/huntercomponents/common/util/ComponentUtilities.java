package com.hunterparcells.huntercomponents.common.util;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComponentUtilities {
    public static JsonSchema getSchemaFromFilePath(String resourcePath) {
        if (!resourcePath.startsWith("/")) {
            resourcePath = "/" + resourcePath;
        }
        return JsonSchema.parse(
                Objects.requireNonNull(ComponentUtilities.class.getResourceAsStream(resourcePath))
        );
    }

    private static String extractEventName(String filePath) {
        Pattern pattern =  Pattern.compile("/([A-Za-z]*).json");
        Matcher matcher = pattern.matcher(filePath);
        if(!matcher.find()) {
            return null;
        }
        return matcher.group(1);
    }

    public static DynamicEventDescriptor getEventDescriptor(String filePath) {
        String eventName = extractEventName(filePath);
        return new DynamicEventDescriptor(filePath, eventName);
    }
}
