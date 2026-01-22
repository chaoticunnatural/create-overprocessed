package dev.wren.overprocessed.content.recipes;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import dev.wren.overprocessed.index.OverprocessedRecipeTypes;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class SandingRecipe extends FanRecipe<SandingRecipe.SandingWrapper> {
    public SandingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(OverprocessedRecipeTypes.SANDING, params);
    }

    public static class SandingWrapper extends RecipeWrapper {
        public SandingWrapper() {
            super(new ItemStackHandler(1));
        }
    }
}
