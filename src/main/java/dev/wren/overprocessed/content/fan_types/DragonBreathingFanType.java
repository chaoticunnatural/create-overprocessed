package dev.wren.overprocessed.content.fan_types;

import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import dev.wren.overprocessed.content.recipes.DragonBreathingRecipe;
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

public class DragonBreathingFanType implements FanProcessingType {

    private static final DragonBreathingRecipe.DragonBreathingWrapper WRAPPER = new DragonBreathingRecipe.DragonBreathingWrapper();

    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        var fluidState = level.getFluidState(pos);
        if (OverprocessedTags.FluidTags.FAN_PROCESSING_CATALYSTS_DRAGON_BREATHING.matches(fluidState)) return true;
        var blockState = level.getBlockState(pos);
        return OverprocessedTags.BlockTags.FAN_PROCESSING_CATALYSTS_DRAGON_BREATHING.matches(blockState);
    }

    @Override
    public int getPriority() {
        return 1100;
    }

    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        WRAPPER.setItem(0, stack);
        Optional<DragonBreathingRecipe> recipe = OverprocessedRecipeTypes.DRAGON_BREATHING.find(WRAPPER, level);
        return recipe.isPresent();
    }

    @Override
    public @Nullable List<ItemStack> process(ItemStack stack, Level level) {
        WRAPPER.setItem(0, stack);
        Optional<DragonBreathingRecipe> recipe = OverprocessedRecipeTypes.DRAGON_BREATHING.find(WRAPPER, level);
        return recipe.map(dragonBreathingRecipe ->
                RecipeApplier.applyRecipeOn(level, stack, dragonBreathingRecipe, true))
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
