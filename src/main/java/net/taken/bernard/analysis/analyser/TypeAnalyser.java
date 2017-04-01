package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.attribute.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static net.taken.bernard.analysis.SentenceAnalysis.SentenceAnalysisBuilder;
import static net.taken.bernard.analysis.attribute.Type.*;

/**
 * Created by Jeremy on 04/03/2017.
 */
public class TypeAnalyser extends AbstractAnalyser {

    private static final Logger logger = LogManager.getLogger(TypeAnalyser.class);
    
    private static final Type DEFAULT_TYPE = DECLARATIVE;

    private final List<String> identifiers;

    public TypeAnalyser() {
        identifiers = getIdentifiers();
    }

    @Override
    protected void hookAnalyze(String sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        Type res = getSentenceType(sentence);
        sentenceAnalysisBuilder.type(res);
    }

    Type getSentenceType(String sentence) {
        Type res = DEFAULT_TYPE;
        if (sentence.length() >0) {
            String endChar = Character.toString(sentence.charAt(sentence.length() - 1));
            logger.debug("End char" + endChar);
            if (identifiers.contains(endChar))
                res = getType(endChar);
        }
        return res;
    }

}
