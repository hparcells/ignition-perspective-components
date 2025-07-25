package com.hunterparcells.huntercomponents.common;

import com.inductiveautomation.ignition.common.gson.JsonObject;

import java.awt.image.BufferedImage;

public record PaletteEntry(String variantId,
                           String label,
                           String description,
                           BufferedImage thumbnail,
                           JsonObject props) { }
