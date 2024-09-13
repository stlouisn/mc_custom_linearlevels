package dev.linearlevels;

import dev.linearlevels.config.ConfigHandler;
import dev.linearlevels.utils.ModConstants;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Mod(ModConstants.MOD_ID)
public final class LinearLevels {

  public static final Logger LOGGER = LoggerFactory.getLogger(ModConstants.MOD_ID);

  public LinearLevels(ModContainer container) {
    container.registerConfig(Type.COMMON, ConfigHandler.configSpec);
  }
}