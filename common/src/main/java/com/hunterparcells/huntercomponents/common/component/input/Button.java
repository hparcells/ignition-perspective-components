package com.hunterparcells.huntercomponents.common.component.input;

import com.hunterparcells.huntercomponents.common.Component;

public class Button extends Component {
    public Button() {
        super(
                "hc.input.button",
                "Button",
                "An opinionated button component.",
                "BtnButton"
        );

        this.addEvent("onActionPerformed");

        this.addPaletteEntry();
    }
}
