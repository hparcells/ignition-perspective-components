package com.hunterparcells.huntercomponents.common;

import javax.swing.*;

public enum ComponentIcon {
    BUTTON("button"),
    DRAG_REPEATER("dragrepeater"),
    ALERT("alert"),
    DEBOUNCED_TEXT_FIELD("debouncedtextfield"),
    BIG_NUMBER("bignumber"),
    CALENDAR("calendar"),
    SEQUENTIAL_MONTH_PICKER("sequentialmonthpicker");

    private final String file;

    ComponentIcon(String file) {
        this.file = file;
    }

    public Icon getIcon() {
        return  new ImageIcon(getClass().getResource("/icon/" + file + ".png"));
    }
}
