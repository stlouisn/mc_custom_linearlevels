package dev.linearlevels.mixin;

import dev.linearlevels.config.ModConfig;
import dev.linearlevels.config.ModConfigData;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerMixin {

  @Shadow
  public int experienceLevel;

  @Inject(at = @At("HEAD"), method = "getNextLevelExperience()I", cancellable = true)
  private void linearlevels$getXpNeededForNextLevel(CallbackInfoReturnable<Integer> cir) {
    if (ModConfig.CONFIG.curveMode) {
      cir.setReturnValue(experienceLevel == 0 ? ModConfig.CONFIG.baseXPForOneLevel : ModConfig.CONFIG.baseXPForOneLevel + (experienceLevel * ModConfig.CONFIG.curveModeMultiplier));
    }
    else {
      cir.setReturnValue(ModConfig.CONFIG.baseXPForOneLevel);
    }
    cir.cancel();
  }
}
