package com.hunterparcells.huntercomponents.common.component.ui;

import com.hunterparcells.huntercomponents.common.Component;
import com.hunterparcells.huntercomponents.common.ComponentIcon;
import com.hunterparcells.huntercomponents.common.HunterComponents;
import com.hunterparcells.huntercomponents.common.util.ComponentUtilities;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.inductiveautomation.perspective.common.api.ComponentEventDescriptor;

import java.util.List;

public class BigNumber extends Component {
    public BigNumber() {
        super(
                "hc.ui.bignumber",
                "Big Number",
                "Emphasized statistic"
        );

        this.addPaletteEntry();
    }
}
