package dev.linearlevels.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "linearlevels")
public class LinearLevelsConfigData implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean curveMode = true;

    @ConfigEntry.Gui.Tooltip
    public int baseXPForOneLevel = 50;

    @ConfigEntry.Gui.Tooltip
    public int curveModeMultiplier = 1;

}