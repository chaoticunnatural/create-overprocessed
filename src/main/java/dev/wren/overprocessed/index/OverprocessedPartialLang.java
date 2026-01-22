package dev.wren.overprocessed.index;

import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.wren.overprocessed.COverprocessed;

public class OverprocessedPartialLang {

    static CreateRegistrate REGISTRATE = COverprocessed.registrate();

    public static void regTranslations() {
        REGISTRATE.addRawLang(fanRecipe("cooling"), "Bulk Cooling");
        REGISTRATE.addRawLang(fanRecipe("dragon_breathing"), "Bulk Dragon Breathing");
        REGISTRATE.addRawLang(fanRecipe("freezing"), "Bulk Freezing");
        REGISTRATE.addRawLang(fanRecipe("sanding"), "Bulk Sanding");
        REGISTRATE.addRawLang(fanRecipe("seething"), "Bulk Seething");
        REGISTRATE.addRawLang(fanRecipe("withering"), "Bulk Withering");
    }

    public static String fanRecipe(String type) {
        return "create.recipe.fan_" + type;
    }
}
