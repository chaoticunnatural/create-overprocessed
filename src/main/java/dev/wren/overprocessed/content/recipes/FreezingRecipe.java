package dev.wren.overprocessed.content.recipes;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import dev.wren.overprocessed.index.OverprocessedRecipeTypes;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class FreezingRecipe extends FanRecipe<FreezingRecipe.FreezingWrapper> {
    public FreezingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(OverprocessedRecipeTypes.FREEZING, params);
    }

    public static class FreezingWrapper extends RecipeWrapper {
        public FreezingWrapper() {
            super(new ItemStackHandler(1));
        }
    }
}
