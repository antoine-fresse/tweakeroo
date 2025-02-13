package fi.dy.masa.tweakeroo.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import fi.dy.masa.malilib.util.GameUtils;
import fi.dy.masa.tweakeroo.config.Configs;
import fi.dy.masa.tweakeroo.config.FeatureToggle;

@Mixin(PlayerCapabilities.class)
public abstract class MixinPlayerCapabilities
{
    @Inject(method = "getFlySpeed", at = @At("HEAD"), cancellable = true)
    private void overrideFlySpeed(CallbackInfoReturnable<Float> cir)
    {
        EntityPlayer player = GameUtils.getClientPlayer();

        if (FeatureToggle.TWEAK_FLY_SPEED.getBooleanValue() &&
            player != null && player.capabilities.allowFlying)
        {
            cir.setReturnValue(Configs.Internal.ACTIVE_FLY_SPEED_OVERRIDE_VALUE.getFloatValue());
        }
    }
}
