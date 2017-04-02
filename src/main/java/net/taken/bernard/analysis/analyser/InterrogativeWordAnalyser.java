package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.analysis.attribute.InterrogativeWord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by jerem on 01/04/2017.
 */
public class InterrogativeWordAnalyser extends AbstractAnalyser{

    private static final Logger logger = LogManager.getLogger(InterrogativeWordAnalyser.class);
    
    public InterrogativeWordAnalyser() {

    }

    @Override
    protected void hookAnalyze(String sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        sentenceAnalysisBuilder.interrogativeWord(getInterrogativeWord(sentence));
    }

    InterrogativeWord getInterrogativeWord(String sentence) {
        InterrogativeWord res = InterrogativeWord.getInterrogativeWord(sentence.split(" ")[0]);
        logger.debug("Detected interrogative word: " + res);
        return res;
    }
}
