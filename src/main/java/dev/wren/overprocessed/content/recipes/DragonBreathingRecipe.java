package dev.wren.overprocessed.content.recipes;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import dev.wren.overprocessed.index.OverprocessedRecipeTypes;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class DragonBreathingRecipe extends FanRecipe<DragonBreathingRecipe.DragonBreathingWrapper> {
    public DragonBreathingRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(OverprocessedRecipeTypes.DRAGON_BREATHING, params);
    }

    public static class DragonBreathingWrapper extends RecipeWrapper {
        public DragonBreathingWrapper() {
            super(new ItemStackHandler(1));
        }
    }
}
