package dev.linearlevels.mixin;

import dev.linearlevels.config.ConfigHandler;
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
    if (ConfigHandler.curveMode.get()) {
      cir.setReturnValue(experienceLevel == 0 ? ConfigHandler.baseXPForOneLevel.get() : ConfigHandler.baseXPForOneLevel.get() + (experienceLevel * ConfigHandler.curveModeMultiplier.get()));
    }
    else {
      cir.setReturnValue(ConfigHandler.baseXPForOneLevel.get());
    }
    cir.cancel();
  }
}
