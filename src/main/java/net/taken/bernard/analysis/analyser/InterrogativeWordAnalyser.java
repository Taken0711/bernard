package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.analysis.attribute.InterrogativeWord;
import net.taken.bernard.common.Sentence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.taken.bernard.common.WordType.INTERROGATIVE_WORD;

/**
 * Created by jerem on 01/04/2017.
 */
public class InterrogativeWordAnalyser extends AbstractAnalyser{

    private static final Logger logger = LogManager.getLogger(InterrogativeWordAnalyser.class);
    private InterrogativeWord interrogativeWord;
    private String interrogativeWordString;
    
    @Override
    public void hookAnalyze(Sentence sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        InterrogativeWord interrogativeWord = getInterrogativeWord(sentence);
        sentenceAnalysisBuilder.interrogativeWord(interrogativeWord);
        if (interrogativeWord == null)
            return;
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
