package dev.wren.overprocessed.content.fan_types;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import dev.wren.overprocessed.content.recipes.CoolingRecipe;
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

public class CoolingFanType implements FanProcessingType {
    private static final CoolingRecipe.CoolingWrapper WRAPPER = new CoolingRecipe.CoolingWrapper();

    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        var fluidState = level.getFluidState(pos);
        if (OverprocessedTags.FluidTags.FAN_PROCESSING_CATALYSTS_COOLING.matches(fluidState)) return true;
        var blockState = level.getBlockState(pos);
        return OverprocessedTags.BlockTags.FAN_PROCESSING_CATALYSTS_COOLING.matches(blockState);
    }

    @Override
    public int getPriority() {
        return 1000;
    }

    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        WRAPPER.setItem(0, stack);
        Optional<CoolingRecipe> recipe = OverprocessedRecipeTypes.COOLING.find(WRAPPER, level);
        return recipe.isPresent();
    }

    @Override
    public @Nullable List<ItemStack> process(ItemStack stack, Level level) {
        WRAPPER.setItem(0, stack);
        Optional<CoolingRecipe> recipe = OverprocessedRecipeTypes.COOLING.find(WRAPPER, level);
        return recipe.map(coolingRecipe ->
                RecipeApplier.applyRecipeOn(level, stack, coolingRecipe, true))
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
