package dev.wren.overprocessed;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.wren.overprocessed.index.OverprocessedPartialLang;
import dev.wren.overprocessed.index.OverprocessedRecipeTypes;
import dev.wren.overprocessed.index.OverprocessedTags;
import dev.wren.overprocessed.index.OverprocessingFanProcessingTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

@Mod(COverprocessed.MOD_ID)
public class COverprocessed {
    public static final String NAME = "Create: Overprocessed";
    public static final String MOD_ID = "create_overprocessed";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);


    public COverprocessed() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(modEventBus);

        OverprocessedPartialLang.regTranslations();
        OverprocessedTags.init();
        OverprocessedRecipeTypes.register(modEventBus);
    }

    public static void onRegister(final RegisterEvent event) {
        OverprocessingFanProcessingTypes.init();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }

    public static Component translate(String key) {
        return Component.translatable(MOD_ID + "." + key);
    }
}
