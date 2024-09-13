package dev.linearlevels;

import dev.linearlevels.config.ModConfig;
import dev.linearlevels.config.ModConfigData;
import dev.linearlevels.utils.ModConstants;
import me.shedaniel.autoconfig.AutoConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@Mod(ModConstants.MOD_ID)
public final class LinearLevels {

  public static final Logger LOGGER = LoggerFactory.getLogger(ModConstants.MOD_ID);

  public LinearLevels(IEventBus modBus) {
    modBus.addListener(this::commonSetup);
    ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (client, parent) -> AutoConfig.getConfigScreen(ModConfigData.class, parent).get());
  }

  private void commonSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(ModConfig::init);
  }
}
