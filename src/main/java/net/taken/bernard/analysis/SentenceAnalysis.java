package net.taken.bernard.analysis;

import net.taken.bernard.analysis.attribute.Auxiliary;
import net.taken.bernard.analysis.attribute.Effect;
import net.taken.bernard.analysis.attribute.InterrogativeWord;
import net.taken.bernard.analysis.attribute.SentenceType;

/**
 * Created by Jeremy on 04/03/2017.
 */
public class SentenceAnalysis {

    public final Effect effect;
    public final SentenceType sentenceType;
    public final InterrogativeWord interrogativeWord;
    private final Auxiliary auxiliary;

    private SentenceAnalysis(SentenceAnalysisBuilder builder) {
        effect = builder.effect;
        sentenceType = builder.sentenceType;
        interrogativeWord = builder.interrogativeWord;
        auxiliary = builder.auxiliary;
    }

    public static class SentenceAnalysisBuilder {
        private Effect effect;
        private SentenceType sentenceType;
        private InterrogativeWord interrogativeWord;
        private Auxiliary auxiliary;

        public SentenceAnalysisBuilder effect(Effect effect) {
            this.effect = effect;
            return this;
        }

        public SentenceAnalysisBuilder sentenceType(SentenceType sentenceType) {
            this.sentenceType = sentenceType;
            return this;
        }

        public SentenceAnalysisBuilder interrogativeWord(InterrogativeWord interrogativeWord) {
            this.interrogativeWord = interrogativeWord;
            return this;
        }

        public SentenceAnalysisBuilder auxiliary(Auxiliary auxiliary) {
            this.auxiliary = auxiliary;
            return this;
        }

        public SentenceAnalysis build() {
            return new SentenceAnalysis(this);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SentenceAnalysis{");
        sb.append("effect=").append(effect);
        sb.append(", sentenceType=").append(sentenceType);
        sb.append(", interrogativeWord=").append(interrogativeWord);
        sb.append('}');
        return sb.toString();
    }
}
