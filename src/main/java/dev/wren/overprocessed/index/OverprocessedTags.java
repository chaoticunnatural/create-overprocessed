package dev.wren.overprocessed.index;

import com.simibubi.create.Create;
import dev.wren.overprocessed.COverprocessed;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

import javax.annotation.Nullable;

public class OverprocessedTags {

    public enum NameSpace {
        CREATE(Create.ID),
        COMMON("c"),
        MOD(COverprocessed.MOD_ID);

        public final String id;

        NameSpace(String id) {
            this.id = id;
        }

        public ResourceLocation id(String path) {
            return new ResourceLocation(this.id, path);
        }

        public ResourceLocation id(Enum<?> entry, @Nullable String pathOverride) {
            return this.id(pathOverride != null ? pathOverride : Lang.asId(entry.name()));
        }
    }

    public enum BlockTags {
        FAN_PROCESSING_CATALYSTS_COOLING(NameSpace.MOD, "fan_processing_catalysts/cooling"),
        FAN_PROCESSING_CATALYSTS_DRAGON_BREATHING(NameSpace.MOD, "fan_processing_catalysts/dragon_breathing"),
        FAN_PROCESSING_CATALYSTS_FREEZING(NameSpace.MOD, "fan_processing_catalysts/freezing"),
        FAN_PROCESSING_CATALYSTS_SANDING(NameSpace.MOD, "fan_processing_catalysts/sanding"),
        FAN_PROCESSING_CATALYSTS_SEETHING(NameSpace.MOD, "fan_processing_catalysts/seething"),
        FAN_PROCESSING_CATALYSTS_WITHERING(NameSpace.MOD, "fan_processing_catalysts/withering")
        ;

        public final TagKey<Block> tag;

        BlockTags() {
            this(NameSpace.MOD);
        }

        BlockTags(NameSpace namespace) {
            this(namespace, null);
        }

        BlockTags(NameSpace namespace, @Nullable String pathOverride) {
            this.tag = TagKey.create(Registries.BLOCK, namespace.id(this, pathOverride));
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Block block) {
            return block.builtInRegistryHolder().is(tag);
        }

        public boolean matches(ItemStack stack) {
            return stack != null && stack.getItem() instanceof BlockItem blockItem && matches(blockItem.getBlock());
        }

        public boolean matches(BlockState state) {
            return state.is(tag);
        }

        private static void init() {}
    }

    public enum FluidTags {
        FAN_PROCESSING_CATALYSTS_COOLING(NameSpace.MOD, "fan_processing_catalysts/cooling"),
        FAN_PROCESSING_CATALYSTS_DRAGON_BREATHING(NameSpace.MOD, "fan_processing_catalysts/dragon_breathing"),
        FAN_PROCESSING_CATALYSTS_FREEZING(NameSpace.MOD, "fan_processing_catalysts/freezing"),
        FAN_PROCESSING_CATALYSTS_SANDING(NameSpace.MOD, "fan_processing_catalysts/sanding"),
        FAN_PROCESSING_CATALYSTS_SEETHING(NameSpace.MOD, "fan_processing_catalysts/seething"),
        FAN_PROCESSING_CATALYSTS_WITHERING(NameSpace.MOD, "fan_processing_catalysts/withering")
        ;

        public final TagKey<Fluid> tag;

        FluidTags() {
            this(NameSpace.MOD);
        }

        FluidTags(NameSpace namespace) {
            this(namespace, null);
        }

        FluidTags(NameSpace nameSpace, @Nullable String pathOverride) {
            this.tag = TagKey.create(Registries.FLUID, nameSpace.id(this, pathOverride));
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Fluid fluid) {
            return fluid.is(tag);
        }

        public boolean matches(FluidState state) {
            return state.is(tag);
        }

        private static void init() {}
    }

    public static void init() {
        BlockTags.init();
        FluidTags.init();
    }
}
