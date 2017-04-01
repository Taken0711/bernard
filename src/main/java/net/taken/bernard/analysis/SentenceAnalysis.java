package net.taken.bernard.analysis;

import net.taken.bernard.analysis.attribute.Effect;
import net.taken.bernard.analysis.attribute.InterrogativeWord;
import net.taken.bernard.analysis.attribute.Type;

/**
 * Created by Jeremy on 04/03/2017.
 */
public class SentenceAnalysis {

    public final Effect effect;
    public final Type type;
    public final InterrogativeWord interrogativeWord;

    private SentenceAnalysis(SentenceAnalysisBuilder builder) {
        effect = builder.effect;
        type = builder.type;
        interrogativeWord = builder.interrogativeWord;
    }

    public static class SentenceAnalysisBuilder {
        private Effect effect;
        private Type type;
        private InterrogativeWord interrogativeWord;

        public SentenceAnalysisBuilder effect(Effect effect) {
            this.effect = effect;
            return this;
        }

        public SentenceAnalysisBuilder type(Type type) {
            this.type = type;
            return this;
        }

        public SentenceAnalysisBuilder interrogativeWord(InterrogativeWord interrogativeWord) {
            this.interrogativeWord = interrogativeWord;
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
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
