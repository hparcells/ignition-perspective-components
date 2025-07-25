package com.hunterparcells.huntercomponents.common.component.input;

import com.hunterparcells.huntercomponents.common.Component;

public class SequentialMonthPicker extends Component {
    public SequentialMonthPicker() {
        super(
                "hc.input.sequentialmonthpicker",
                "Sequential Month Picker",
                "Month picker with increment and decrement buttons."
        );

        this.addPaletteEntry();
    }
}
