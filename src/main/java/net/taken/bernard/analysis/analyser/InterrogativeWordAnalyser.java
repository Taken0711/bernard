package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.analysis.attribute.InterrogativeWord;
import net.taken.bernard.common.Sentence;
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
    protected void hookAnalyze(Sentence sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        sentenceAnalysisBuilder.interrogativeWord(getInterrogativeWord(sentence));
    }

    InterrogativeWord getInterrogativeWord(Sentence sentence) {
        StringBuilder interrogativeWord = new StringBuilder();
        for (String word: sentence.getWordList()) {
            String toAdd = "";
            if (!interrogativeWord.toString().isEmpty())
                toAdd = " ";
            toAdd += word;
            if (InterrogativeWord.getInterrogativeWord(interrogativeWord.toString() + toAdd) == null)
                break;
            interrogativeWord.append(toAdd);
        }
        InterrogativeWord res = InterrogativeWord.getInterrogativeWord(interrogativeWord.toString());
        logger.debug("Detected interrogative word: " + res);
        return res;
    }
}
