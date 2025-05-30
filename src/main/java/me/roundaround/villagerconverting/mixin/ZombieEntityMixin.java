package me.roundaround.villagerconverting.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import me.roundaround.villagerconverting.VillagerConvertingConfig;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Zombie.class)
public abstract class ZombieEntityMixin{
    @ModifyExpressionValue(
            method="killedEntity", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;getDifficulty()Lnet/minecraft/world/Difficulty;")
    )
    private Difficulty replaceDifficulty(Difficulty original, @Local(argsOnly = true) LivingEntity other){
        if (!VillagerConvertingConfig.modEnabled)
        {
            return original;
        }
        if (VillagerConvertingConfig.requireName && !other.hasCustomName())
        {
            return original;
        }
        return Difficulty.NORMAL;
    }
    @ModifyExpressionValue(
            method="killedEntity",
            at = @At(value = "INVOKE", target="Lnet/minecraft/util/RandomSource;nextBoolean()Z"
            )
    )
    private boolean replaceRandomChance(boolean original, @Local() Villager other){
        if (!VillagerConvertingConfig.modEnabled)
        {
            return original;
        }
        if (VillagerConvertingConfig.requireName && !other.hasCustomName())
        {
            return original;
        }
        return false;
    }
}