package dev.linearlevels.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;

public final class ConfigHandler {

  public static final ModConfigSpec configSpec;

  public static ConfigValue<Integer> baseXPForOneLevel;
  public static ConfigValue<Boolean> curveMode;
  public static ConfigValue<Integer> curveModeMultiplier;

  static {

    ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

    baseXPForOneLevel = builder
        .comment("The base amount of experience required for each level.\nDefault: 40")
        .define("baseXPForOneLevel", 40);

    curveMode = builder
        .comment("Use curved mode to increase experience required per level.\nFormula: baseXPForOneLevel + (playerLevel * curveModeMultiplier)\nDefault: true")
        .define("curveMode", true);

    curveModeMultiplier = builder
        .comment("The multiplier used in the Curve Mode calculation.\nDefault: 1")
        .define("curveModeMultiplier", 1);

    configSpec = builder.build();

  }
}