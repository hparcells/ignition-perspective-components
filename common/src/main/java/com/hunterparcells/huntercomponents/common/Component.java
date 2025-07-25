package com.hunterparcells.huntercomponents.common;

import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;
import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.inductiveautomation.perspective.common.api.ComponentEventDescriptor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Component {
    private final String namespacedId;
    private final String name;
    private final String description;
    private final String defaultName;

    private final String id;

    private final List<ComponentEventDescriptor> events;
    private final List<PaletteEntry> paletteEntries;

    public Component(String namespacedId, String name, String description, String defaultName) {
        this.namespacedId = namespacedId;
        this.name = name;
        this.description = description;
        this.defaultName = defaultName;

        Pattern pattern = Pattern.compile("\\.([A-Za-z]*)$");
        Matcher matcher = pattern.matcher(this.namespacedId);
        if(!matcher.find()) {
            throw new Error();
        }
        this.id = matcher.group(1);

        this.events = new ArrayList<>();
        this.paletteEntries = new ArrayList<>();
    }

    public Component(String namespacedId, String name, String description) {
        this(namespacedId, name, description, name);
    }

    public Component(String namespacedId, String name) {
        this(namespacedId, name, name, name);
    }

    public void addEvent(String event) {
        String path = "events/" + this.id + "/" + event + ".json";
        ComponentEventDescriptor descriptor = ComponentUtilities.getEventDescriptor(path);
        events.add(descriptor);
    }

    public void addPaletteEntry() {
        this.paletteEntries.add(new PaletteEntry("", this.name, this.description, null, null));
    }

    public void addPaletteEntry(PaletteEntry paletteEntry) {
        this.paletteEntries.add(paletteEntry);
    }

    public String getPropsSchemaPath() {
        return "/props/" + this.id + ".props.json";
    }

    public JsonSchema getSchema() {
        return ComponentUtilities.getSchemaFromFilePath(this.getPropsSchemaPath());
    }

    public Icon getIcon() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource("/icon/" + this.id + ".png")));
    }

    public ComponentDescriptor getDescriptor() {
        ComponentDescriptorImpl.ComponentBuilder builder = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
                .setSchema(this.getSchema())
                .setId(this.namespacedId)
                .setName(this.name)
                .setDefaultMetaName(this.defaultName)
                .setIcon(this.getIcon())
                .setEvents(this.events)
                .setModuleId(HunterComponents.MODULE_ID)
                .setPaletteCategory(HunterComponents.COMPONENT_CATEGORY)
                .setResources(HunterComponents.BROWSER_RESOURCES);

        for(PaletteEntry paletteEntry : this.paletteEntries) {
            builder.addPaletteEntry(
                    paletteEntry.variantId(),
                    paletteEntry.label(),
                    paletteEntry.description(),
                    paletteEntry.thumbnail(),
                    paletteEntry.props()
            );
        }

        return builder.build();
    }

    public String getNamespacedId() {
        return this.namespacedId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDefaultName() {
        return this.defaultName;
    }

    public String getId() {
        return this.id;
    }

    public List<ComponentEventDescriptor> getEvents() {
        return this.events;
    }
}
