package info.partonetrain.linearlevels.mixin;

import info.partonetrain.linearlevels.LevelConfig;
import info.partonetrain.linearlevels.Linearlevels;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {

	@Shadow
	public int experienceLevel;

	@Inject(at = @At("HEAD"),
			method = "Lnet/minecraft/world/entity/player/Player;getXpNeededForNextLevel()I",
			cancellable = true)
	private void linearlevels_getXpNeededForNextLevel(CallbackInfoReturnable<Integer> cir) {
		LevelConfig cfg = AutoConfig.getConfigHolder(LevelConfig.class).getConfig();
		if(cfg.curveMode)
		{
			cir.setReturnValue(experienceLevel == 0 ? cfg.baseXPForOneLevel : cfg.baseXPForOneLevel + (experienceLevel * cfg.curveModeMultiplier));
		}
		else
		{
			cir.setReturnValue(cfg.baseXPForOneLevel);
		}

		cir.cancel();
	}
}