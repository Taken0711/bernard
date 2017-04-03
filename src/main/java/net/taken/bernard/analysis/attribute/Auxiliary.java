package net.taken.bernard.analysis.attribute;

import net.taken.bernard.common.IWordType;
import net.taken.bernard.common.WordType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jerem on 03/04/2017.
 */
public interface Auxiliary extends IWordType {

    @Override
    default WordType getWordType() {
        return WordType.AUXILIARY;
    }

    Tense getTense();

    static Auxiliary getAuxiliary(String syntax) {
        return Present.getAuxiliary(syntax);
    }

    enum Present implements Auxiliary {
        BE("am", "are", "is"),
        HAVE("have", "has");

        private static Map<String, Present> syntaxMap = new HashMap<>();

        static {
            for (Present aux: values()) {
                aux.syntaxList.forEach(syntax -> syntaxMap.put(syntax, aux));
            }
        }

        private List<String> syntaxList;

        Present(String... syntaxes) {
            syntaxList = Arrays.asList(syntaxes);
        }

        @Override
        public Tense getTense() {
            return Tense.PRESENT;
        }

        static Auxiliary getAuxiliary(String syntax) {
            return syntaxMap.get(syntax);
        }
    }

}
