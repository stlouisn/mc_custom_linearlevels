package com.partonetrain.linearlevels;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;

import com.partonetrain.linearlevels.config.LinearLevelsConfig;

public final class LinearLevelsCommon {

    public static final String MOD_ID = "linearlevels";

    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogUtils.getLogger();

    public static volatile DynamicRegistryManager serverRegistryManager = null;
    public static volatile DynamicRegistryManager clientRegistryManager = null;

    public static Identifier id(String id) {
        return Identifier.of(MOD_ID, id);
    }

    public final static LinearLevelsConfig CONFIG;

    static {
        Jankson jankson = new Jankson.Builder()
                .registerSerializer(Identifier.class, ((identifier, marshaller) -> marshaller.serialize(identifier.toString())))
                .registerDeserializer(String.class, Identifier.class, (object, marshaller) -> Identifier.of(object)).build();

        ConfigHolder<LinearLevelsConfig> configHolder = AutoConfig.register(LinearLevelsConfig.class, (config, configClass) -> new JanksonConfigSerializer<>(config, configClass, jankson));
        CONFIG = configHolder.getConfig();
    }

    public static void commonInit() {
    }

}