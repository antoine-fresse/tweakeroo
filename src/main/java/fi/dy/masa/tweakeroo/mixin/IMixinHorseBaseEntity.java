package fi.dy.masa.tweakeroo.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.inventory.SimpleInventory;

@Mixin(AbstractHorseEntity.class)
public interface IMixinHorseBaseEntity
{
    @Accessor("items")
    SimpleInventory getHorseInventory();
}
