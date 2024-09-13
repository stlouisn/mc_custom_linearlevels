package dev.linearlevels.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.ConfigValue;

public final class ConfigHandler {

  public static final ModConfigSpec configSpec;

  public static ConfigValue<Boolean> curveMode;
  public static ConfigValue<Integer> baseXPForOneLevel, curveModeMultiplier;

  static {

    ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

    curveMode = builder
        .define("curveMode", true);

    baseXPForOneLevel = builder
        .define("baseXPForOneLevel", 50);

    curveModeMultiplier = builder
        .define("curveModeMultiplier", 1);

    configSpec = builder.build();

  }
}