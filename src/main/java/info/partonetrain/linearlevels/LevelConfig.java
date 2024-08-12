package info.partonetrain.linearlevels;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Linearlevels.MOD_ID)
public class LevelConfig implements ConfigData {
    @Comment("Curve Mode calculation is XPToNextLevel = (baseXPForOneLevel + (experienceLevel * curveModeMultiplier)). ")
    public boolean curveMode = false;
    @Comment("The amount of experience to go from level 0 to level 1. If CurveMode is False, this amount is for every level.")
    public int baseXPForOneLevel = 10;
    @Comment("The multiplier used in the Curve Mode calculation.")
    public int curveModeMultiplier = 2;
    @Comment("The level at which the amount of XP required for the next level stops increasing. Set to 0 to disable.")
    public int levelCap = 0;
    @Comment("If levelCap > 0, the amount of experience required for the next level.")
    public int cappedXpForNextLevel = 107;
}
