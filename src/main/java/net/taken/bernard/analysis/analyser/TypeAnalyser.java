package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.attribute.SentenceType;
import net.taken.bernard.common.Sentence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static net.taken.bernard.analysis.SentenceAnalysis.SentenceAnalysisBuilder;
import static net.taken.bernard.analysis.attribute.SentenceType.*;

/**
 * Created by Jeremy on 04/03/2017.
 */
public class TypeAnalyser extends AbstractAnalyser {

    private static final Logger logger = LogManager.getLogger(TypeAnalyser.class);
    
    private static final SentenceType DEFAULT_SENTENCE_TYPE = DECLARATIVE;

    private final List<String> identifiers;

    public TypeAnalyser() {
        identifiers = getIdentifiers();
    }

    @Override
    protected void hookAnalyze(Sentence sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        SentenceType res = getSentenceType(sentence);
        sentenceAnalysisBuilder.sentenceType(res);
        next = res.getAnalyser();
    }

    SentenceType getSentenceType(Sentence sentence) {
        SentenceType res = DEFAULT_SENTENCE_TYPE;
        String sentenceString = sentence.getSentenceString();
        if (sentenceString.length() > 0) {
            String endChar = Character.toString(sentenceString.charAt(sentenceString.length() - 1));
            logger.debug("End char: " + endChar);
            if (identifiers.contains(endChar))
                res = getType(endChar);
        }
        logger.debug("Detected sentenceType: " + res);
        return res;
    }

}
