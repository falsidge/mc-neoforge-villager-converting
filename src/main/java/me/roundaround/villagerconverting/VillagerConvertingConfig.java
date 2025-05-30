package me.roundaround.villagerconverting;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = VillagerConvertingMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class VillagerConvertingConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue MOD_ENABLED = BUILDER
            .comment(
                    " Simple toggle for the mod! When set to false, the",
                    " villagers will fall back to vanilla behavior/probability",
                    " for zombie-conversion."
            )
            .define("modEnabled", true);
    private static final ModConfigSpec.BooleanValue REQUIRE_NAME = BUILDER
            .comment(
                    " When set to true, only villagers that have a custom",
                    " name set (i.e. with a nametag) will be guaranteed to",
                    " convert! Non-named villagers will fall back to vanilla",
                    " behavior."
            )
            .define("requireName", false);


    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean modEnabled;
    public static boolean requireName;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        modEnabled = MOD_ENABLED.get();
        requireName = REQUIRE_NAME.get();
    }
}
