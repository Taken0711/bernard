package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.analyser.data.EffectData;
import net.taken.bernard.analysis.attribute.Effect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.taken.bernard.analysis.SentenceAnalysis.SentenceAnalysisBuilder;
import static net.taken.bernard.analysis.attribute.Effect.*;

/**
 * Created by Jeremy on 26/02/2017.
 */
public class EffectAnalyser extends AbstractAnalyser {

    private static final Logger logger = LogManager.getLogger(EffectAnalyser.class);

    private EffectData effectData;

    public EffectAnalyser(EffectData effectData) {
        this.effectData = effectData;
    }

    @Override
    protected void hookAnalyze(String sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        sentenceAnalysisBuilder.effect(getSentenceEffect(sentence));
    }

    Effect getSentenceEffect(String sentence) {
        int res = 0;
        for (String word : sentence.split(" ")) {
            if (word.isEmpty())
                continue;
            int changeValue = effectData.getWordEffect(word).getEffectValue();
            logger.info(String.format("Analysed word: %s, value found: %s", word, changeValue));
            res += changeValue;
        }
        return res == 0 ? NEUTRAL : (res > 0 ? POSITIVE : NEGATIVE);
    }
}
