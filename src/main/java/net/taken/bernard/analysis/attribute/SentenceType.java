package net.taken.bernard.analysis.attribute;

import net.taken.bernard.analysis.analyser.AbstractAnalyser;
import net.taken.bernard.analysis.analyser.DeclarativeAnalyser;
import net.taken.bernard.analysis.analyser.ExclamatoryAnalyser;
import net.taken.bernard.analysis.analyser.InterrogativeAnalyser;

import java.util.*;

/**
 * Created by Jeremy on 04/03/2017.
 */
public enum SentenceType {

    DECLARATIVE(new DeclarativeAnalyser(), "."),
    INTERROGATIVE(new InterrogativeAnalyser(), "?"),
    EXCLAMATORY(new ExclamatoryAnalyser(), "!");

    private static Map<String, SentenceType> map = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(sentenceType ->
                sentenceType.identifiers.forEach(identifier -> map.put(identifier, sentenceType)));
    }

    private final List<String> identifiers;
    private final AbstractAnalyser analyser;

    SentenceType(AbstractAnalyser analyser, String... identifiers) {
        this.analyser = analyser;
        this.identifiers = Arrays.asList(identifiers);
    }

    public AbstractAnalyser getAnalyser() {
        return analyser;
    }

    public static SentenceType getType(String identifier) {
        return map.get(identifier);
    }

    public static List<String> getIdentifiers() {
        List<String> res = new ArrayList<>();
        Arrays.stream(values()).forEach(sentenceType -> res.addAll(sentenceType.identifiers));
        return res;
    }

}
