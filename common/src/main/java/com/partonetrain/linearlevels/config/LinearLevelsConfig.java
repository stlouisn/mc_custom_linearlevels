package com.partonetrain.linearlevels.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@SuppressWarnings("CanBeFinal")
@Config(name = "linearlevels")
public class LinearLevelsConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean curveMode = true;

    @ConfigEntry.Gui.Tooltip
    public int baseXPForOneLevel = 60;

    @ConfigEntry.Gui.Tooltip
    public int curveModeMultiplier = 2;

}