package dev.wren.overprocessed.index;

import com.simibubi.create.api.registry.CreateBuiltInRegistries;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import dev.wren.overprocessed.COverprocessed;
import dev.wren.overprocessed.content.fan_types.*;
import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;
import net.minecraft.core.Registry;

public class OverprocessingFanProcessingTypes {
    public static final CoolingFanType COOLING_TYPE = register("cooling", new CoolingFanType());
    public static final DragonBreathingFanType DRAGON_BREATHING_TYPE = register("dragon_breathing", new DragonBreathingFanType());
    public static final FreezingFanType FREEZING_TYPE = register("freezing", new FreezingFanType());
    public static final SandingFanType SANDING_TYPE = register("sanding", new SandingFanType());
    public static final SeethingFanType SEETHING_TYPE = register("seething", new SeethingFanType());
    public static final WitheringFanType WITHERING_TYPE = register("withering", new WitheringFanType());

    static {
        Object2ReferenceOpenHashMap<String, FanProcessingType> map = new Object2ReferenceOpenHashMap<>();
        map.put("COOLING", COOLING_TYPE);
        map.put("DRAGON_BREATHING", DRAGON_BREATHING_TYPE);
        map.put("FREEZING", FREEZING_TYPE);
        map.put("SANDING", SANDING_TYPE);
        map.put("SEETHING", SEETHING_TYPE);
        map.put("WITHERING", WITHERING_TYPE);
        map.trim();
    }

    private static <T extends FanProcessingType> T register(String name, T type) {
        return Registry.register(CreateBuiltInRegistries.FAN_PROCESSING_TYPE, COverprocessed.asResource(name), type);
    }

    public static void init() {}
}
