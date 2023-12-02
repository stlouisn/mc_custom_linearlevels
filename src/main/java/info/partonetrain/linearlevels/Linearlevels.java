package info.partonetrain.linearlevels;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigManager;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Linearlevels implements ModInitializer {
	public static final String MOD_ID = "linearlevels";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static boolean curveMode = false;

	@Override
	public void onInitialize() {
		AutoConfig.register(LevelConfig.class, JanksonConfigSerializer::new);
	}
}