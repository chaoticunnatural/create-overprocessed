package dev.wren.overprocessed.content.recipes;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import dev.wren.overprocessed.index.OverprocessedRecipeTypes;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class SeethingRecipe extends FanRecipe<SeethingRecipe.SeethingWrapper> {
    public SeethingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(OverprocessedRecipeTypes.SEETHING, params);
    }

    public static class SeethingWrapper extends RecipeWrapper {
        public SeethingWrapper() {
            super(new ItemStackHandler(1));
        }
    }
}
