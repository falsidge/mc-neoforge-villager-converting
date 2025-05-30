package me.roundaround.villagerconverting;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(VillagerConvertingMod.MODID)
public class VillagerConvertingMod
{
    public static final String MODID = "villagerconverting";
    private static final Logger LOGGER = LogUtils.getLogger();

    public VillagerConvertingMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.COMMON, VillagerConvertingConfig.SPEC);
    }
}
