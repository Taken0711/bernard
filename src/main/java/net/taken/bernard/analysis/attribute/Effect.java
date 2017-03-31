package net.taken.bernard.analysis.attribute;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeremy on 28/02/2017.
 */
public enum Effect {
    POSITIVE("+Effect", +1),
    NEUTRAL("Null", 0),
    NEGATIVE("-Effect", -1);

    private static Map<String, Effect> map = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(effect -> map.put(effect.syntax, effect));
    }

    private final String syntax;
    private final int effectValue;

    Effect(String syntax, int effectValue) {
        this.syntax = syntax;
        this.effectValue = effectValue;
    }

    public static Effect getEffect(String syntax) {
        return map.get(syntax);
    }

    public int getEffectValue() {
        return effectValue;
    }
}
