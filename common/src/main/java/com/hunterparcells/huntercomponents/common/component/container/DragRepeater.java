package com.hunterparcells.huntercomponents.common.component.container;

import com.hunterparcells.huntercomponents.common.Component;
import com.hunterparcells.huntercomponents.common.PaletteEntry;
import com.inductiveautomation.ignition.common.gson.JsonObject;

public class DragRepeater extends Component {
    public DragRepeater() {
        super(
                "hc.container.dragrepeater",
                "Drag Repeater",
                "Repeater orderable by drag-and-drop.",
                "CtnContainer"
        );

        this.addEvent("onDragStart");
        this.addEvent("onDrop");

        JsonObject columnProps = new JsonObject();
        columnProps.addProperty("direction", "column");
        this.addPaletteEntry(new PaletteEntry(
                "",
                this.getName(),
                this.getDescription(),
                null,
                columnProps
        ));

        JsonObject rowProps = new JsonObject();
        rowProps.addProperty("direction", "row");
        this.addPaletteEntry(new PaletteEntry(
                "row",
                this.getName() + " (Row)",
                this.getDescription(),
                null,
                rowProps
        ));
    }
}
