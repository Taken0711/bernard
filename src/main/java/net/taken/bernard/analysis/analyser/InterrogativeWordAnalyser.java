package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.analysis.attribute.InterrogativeWord;
import net.taken.bernard.common.Sentence;
import net.taken.bernard.common.WordType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

import static net.taken.bernard.common.WordType.*;

/**
 * Created by jerem on 01/04/2017.
 */
public class InterrogativeWordAnalyser extends AbstractAnalyser{

    private static final Logger logger = LogManager.getLogger(InterrogativeWordAnalyser.class);
    private InterrogativeWord interrogativeWord;
    private String interrogativeWordString;
    
    public InterrogativeWordAnalyser() {
    }

    @Override
    protected void hookAnalyze(Sentence sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        sentenceAnalysisBuilder.interrogativeWord(getInterrogativeWord(sentence));
        sentence.joinWords(interrogativeWordString.split(" "));
        sentence.setWordType(interrogativeWordString, INTERROGATIVE_WORD);
    }

    InterrogativeWord getInterrogativeWord(Sentence sentence) {
        compute(sentence);
        return interrogativeWord;
    }

    private void compute(Sentence sentence) {
        StringBuilder wordBuilder = new StringBuilder();
        for (String word: sentence.getWordList()) {
            String toAdd = "";
            if (!wordBuilder.toString().isEmpty())
                toAdd = " ";
            toAdd += word;
            if (InterrogativeWord.getInterrogativeWord(wordBuilder.toString() + toAdd) == null)
                break;
            wordBuilder.append(toAdd);
        }
        interrogativeWordString = wordBuilder.toString();
        interrogativeWord = InterrogativeWord.getInterrogativeWord(interrogativeWordString);
        logger.debug("Detected interrogative word: " + interrogativeWord);
    }
}
