package dev.wren.overprocessed.content.recipes;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import dev.wren.overprocessed.index.OverprocessedRecipeTypes;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class CoolingRecipe extends FanRecipe<CoolingRecipe.CoolingWrapper> {
    public CoolingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(OverprocessedRecipeTypes.COOLING, params);
    }

    public static class CoolingWrapper extends RecipeWrapper {
        public CoolingWrapper() {
            super(new ItemStackHandler(1));
        }
    }
}
