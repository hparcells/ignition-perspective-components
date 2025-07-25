package com.hunterparcells.huntercomponents.common.component.input;

import com.hunterparcells.huntercomponents.common.Component;

public class DebouncedTextField extends Component {
    public DebouncedTextField() {
        super(
                "hc.input.debouncedtextfield",
                "Debounced Text Field",
                "A text field with a debounced value.",
                "TxInput"
        );

        this.addPaletteEntry();
    }
}
