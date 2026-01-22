package dev.wren.overprocessed.index;

import com.mojang.serialization.Codec;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import dev.wren.overprocessed.COverprocessed;
import dev.wren.overprocessed.content.recipes.*;
import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Supplier;

public enum OverprocessedRecipeTypes implements IRecipeTypeInfo, StringRepresentable {
    COOLING(CoolingRecipe::new),
    DRAGON_BREATHING(DragonBreathingRecipe::new),
    FREEZING(FreezingRecipe::new),
    SANDING(SandingRecipe::new),
    SEETHING(SeethingRecipe::new),
    WITHERING(WitheringRecipe::new)
    ;

    public final ResourceLocation id;
    private final RegistryObject<RecipeSerializer<?>> serializerObject;
    private final Supplier<RecipeType<?>> type;

    public static final Codec<OverprocessedRecipeTypes> CODEC = StringRepresentable.fromEnum(OverprocessedRecipeTypes::values);

    OverprocessedRecipeTypes(Supplier<RecipeSerializer<?>> serializerSupplier) {
        String name = Lang.asId(name());
        id = COverprocessed.asResource(name);
        serializerObject = Registers.SERIALIZER_REGISTER.register(name, serializerSupplier);
        @Nullable RegistryObject<RecipeType<?>> typeObject = Registers.TYPE_REGISTER.register(name, () -> RecipeType.simple(id));
        type = typeObject;
    }

    OverprocessedRecipeTypes(ProcessingRecipeBuilder.ProcessingRecipeFactory<?> processingFactory) {
        this(() -> new ProcessingRecipeSerializer<>(processingFactory));
    }


    public static void register(IEventBus modEventBus) {
        ShapedRecipe.setCraftingSize(9, 9);
        OverprocessedRecipeTypes.Registers.SERIALIZER_REGISTER.register(modEventBus);
        OverprocessedRecipeTypes.Registers.TYPE_REGISTER.register(modEventBus);
    }

    public <C extends Container, T extends Recipe<C>> Optional<T> find(C inv, Level world) {
        return world.getRecipeManager()
                .getRecipeFor(getType(), inv, world);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializerObject.get();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends RecipeType<?>> T getType() {
        return (T) type.get();
    }

    @Override
    public @NotNull String getSerializedName() {
        return id.toString();
    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, COverprocessed.MOD_ID);
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER = DeferredRegister.create(Registries.RECIPE_TYPE, COverprocessed.MOD_ID);
    }
}
