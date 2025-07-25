package com.hunterparcells.huntercomponents.common.component.ui;

import com.hunterparcells.huntercomponents.common.Component;

public class Alert extends Component {
    public Alert() {
        super(
                "hc.ui.alert",
                "Alert",
                "An on-page alert."
        );

        this.addEvent("onDismiss");

        this.addPaletteEntry();
    }
}
