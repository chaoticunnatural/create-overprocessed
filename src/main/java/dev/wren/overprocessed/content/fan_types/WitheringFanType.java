package dev.wren.overprocessed.content.fan_types;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import dev.wren.overprocessed.content.recipes.WitheringRecipe;
import dev.wren.overprocessed.index.OverprocessedRecipeTypes;
import dev.wren.overprocessed.index.OverprocessedTags;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class WitheringFanType implements FanProcessingType {

    private static final WitheringRecipe.WitheringWrapper WRAPPER = new WitheringRecipe.WitheringWrapper();

    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        var fluidState = level.getFluidState(pos);
        if (OverprocessedTags.FluidTags.FAN_PROCESSING_CATALYSTS_WITHERING.matches(fluidState)) return true;
        var blockState = level.getBlockState(pos);
        return OverprocessedTags.BlockTags.FAN_PROCESSING_CATALYSTS_WITHERING.matches(blockState);
    }

    @Override
    public int getPriority() {
        return 1500;
    }

    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        WRAPPER.setItem(0, stack);
        Optional<WitheringRecipe> recipe = OverprocessedRecipeTypes.WITHERING.find(WRAPPER, level);
        return recipe.isPresent();
    }

    @Override
    public @Nullable List<ItemStack> process(ItemStack stack, Level level) {
        WRAPPER.setItem(0, stack);
        Optional<WitheringRecipe> recipe = OverprocessedRecipeTypes.WITHERING.find(WRAPPER, level);
        return recipe.map(witheringRecipe ->
                RecipeApplier.applyRecipeOn(level, stack, witheringRecipe, true))
                .orElse(null);
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        // TODO
    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        // TODO

    }

    @Override
    public void affectEntity(Entity entity, Level level) {
        // TODO
    }
}
