package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.analysis.attribute.Auxiliary;
import net.taken.bernard.common.Sentence;
import net.taken.bernard.common.WordType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.taken.bernard.common.WordType.INTERROGATIVE_WORD;

/**
 * Created by jerem on 03/04/2017.
 */
public class AuxiliaryAnalyser extends AbstractAnalyser {

    private static final Logger logger = LogManager.getLogger(AuxiliaryAnalyser.class);

    public AuxiliaryAnalyser() {
        logger.debug("build AuxiliaryAnalyser");
    }

    @Override
    public void hookAnalyze(Sentence sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        // TODO: change the word type in sentence
        sentenceAnalysisBuilder.auxiliary(getAuxiliary(sentence));
    }

    Auxiliary getAuxiliary(Sentence sentence) {
        String interrogativeWord = sentence.getWord(INTERROGATIVE_WORD);
        int auxiliaryIndex = 0;
        if (interrogativeWord != null) {
            auxiliaryIndex = sentence.getWordList().indexOf(interrogativeWord) + 1;
        }
        Auxiliary res = Auxiliary.getAuxiliary(sentence.getWordList().get(auxiliaryIndex));
        logger.debug(String.format("Auxiliary position: %d, detected auxiliary: %s", auxiliaryIndex, res));
        return res;
    }

}
