package net.taken.bernard.analysis.attribute;

import java.util.*;

/**
 * Created by Jeremy on 04/03/2017.
 */
public enum Type {

    DECLARATIVE("."),
    INTERROGATIVE("?"), 
    EXCLAMATORY("!");

    private static Map<String, Type> map = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(type ->
                type.identifiers.forEach(identifier -> map.put(identifier, type)));
    }

    private final List<String> identifiers;

    Type(String... identifiers) {
        this.identifiers = Arrays.asList(identifiers);
    }

    public static Type getType(String identifier) {
        return map.get(identifier);
    }

    public static List<String> getIdentifiers() {
        List<String> res = new ArrayList<>();
        Arrays.stream(values()).forEach(type -> res.addAll(type.identifiers));
        return res;
    }

}
