package com.partonetrain.linearlevels;

import net.minecraft.util.Identifier;

import me.shedaniel.autoconfig.AutoConfig;

import com.partonetrain.linearlevels.config.LinearLevelsConfig;
import com.partonetrain.linearlevels.config.IdentifierGuiProvider;
import com.partonetrain.linearlevels.config.StringSetGuiProvider;

public class LinearLevelsCommonClient {

    public static void commonClientInit() {

        StringSetGuiProvider<Identifier> guiProvider = new StringSetGuiProvider<>(Identifier.class, Identifier::of);

        AutoConfig.getGuiRegistry(LinearLevelsConfig.class).registerPredicateProvider(guiProvider, guiProvider.getPredicate());

        AutoConfig.getGuiRegistry(LinearLevelsConfig.class).registerTypeProvider(
                new IdentifierGuiProvider(),
                Identifier.class
        );

    }
}