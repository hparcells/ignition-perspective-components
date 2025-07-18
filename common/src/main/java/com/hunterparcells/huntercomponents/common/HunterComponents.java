package com.hunterparcells.huntercomponents.common;

import java.util.Set;

import com.inductiveautomation.perspective.common.api.BrowserResource;

public class HunterComponents {
    public static final String MODULE_ID = "com.hunterparcells.huntercomponents";
    public static final String URL_ALIAS = "huntercomponents";
    public static final String COMPONENT_CATEGORY = "Hunter's Components";
    public static final Set<BrowserResource> BROWSER_RESOURCES =
        Set.of(
            new BrowserResource(
                "hunter-components-js",
                String.format("/res/%s/HunterComponents.js", URL_ALIAS),
                BrowserResource.ResourceType.JS
            ),
            new BrowserResource("hunter-components-css",
                String.format("/res/%s/HunterComponents.css", URL_ALIAS),
                BrowserResource.ResourceType.CSS
            )
        );
}
