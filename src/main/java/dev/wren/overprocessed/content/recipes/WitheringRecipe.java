package dev.wren.overprocessed.content.recipes;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import dev.wren.overprocessed.index.OverprocessedRecipeTypes;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class WitheringRecipe extends FanRecipe<WitheringRecipe.WitheringWrapper> {
    public WitheringRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(OverprocessedRecipeTypes.WITHERING, params);
    }

    public static class WitheringWrapper extends RecipeWrapper {
        public WitheringWrapper() {
            super(new ItemStackHandler(1));
        }
    }
}
