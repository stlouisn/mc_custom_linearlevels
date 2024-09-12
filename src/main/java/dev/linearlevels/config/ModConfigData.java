package dev.linearlevels.config;

import dev.linearlevels.Constants;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;

@Config(name = Constants.MOD_ID)
public class ModConfigData implements ConfigData {

    @Tooltip
    public boolean curveMode = true;

    @Tooltip
    public int baseXPForOneLevel = 50;

    @Tooltip
    public int curveModeMultiplier = 1;

}
