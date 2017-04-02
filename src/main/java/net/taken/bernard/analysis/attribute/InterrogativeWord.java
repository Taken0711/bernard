package net.taken.bernard.analysis.attribute;

import net.taken.bernard.common.WordType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jerem on 01/04/2017.
 */
public enum InterrogativeWord implements WordType{

    WHAT,
    WHERE,
    WHEN,
    WHO,
    HOW,
    /*HOW_OFTEN,
    HOW_MUCH,
    HOW_MANY,
    HOW_LONG,*/
    WHY,
    WHICH,
    WHOSE;

    private static Map<String, InterrogativeWord> map = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(iw -> map.put(iw.toString(), iw));
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", " ");
    }

    public static InterrogativeWord getInterrogativeWord(String syntax) {
        return map.get(syntax.toLowerCase());
    }
}
