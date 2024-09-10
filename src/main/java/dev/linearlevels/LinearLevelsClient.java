package dev.linearlevels;

import dev.linearlevels.config.IdentifierGuiProvider;
import dev.linearlevels.config.LinearLevelsConfigData;
import dev.linearlevels.config.StringSetGuiProvider;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.util.Identifier;

public final class LinearLevelsClient {

  public static void clientInit() {
    StringSetGuiProvider<Identifier> guiProvider = new StringSetGuiProvider<>(Identifier.class, Identifier::of);
    AutoConfig.getGuiRegistry(LinearLevelsConfigData.class).registerPredicateProvider(guiProvider, guiProvider.getPredicate());
    AutoConfig.getGuiRegistry(LinearLevelsConfigData.class).registerTypeProvider(new IdentifierGuiProvider(), Identifier.class);
  }
}
