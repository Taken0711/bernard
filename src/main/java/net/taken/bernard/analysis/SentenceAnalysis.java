package net.taken.bernard.analysis;

/**
 * Created by Jeremy on 04/03/2017.
 */
public class SentenceAnalysis {

    public final Effect effect;

    private SentenceAnalysis(SentenceAnalysisBuilder builder) {
        effect = builder.effect;
    }

    static class SentenceAnalysisBuilder {
        private Effect effect;

        SentenceAnalysisBuilder effect(Effect effect) {
            this.effect = effect;
            return this;
        }

        SentenceAnalysis build() {
            return new SentenceAnalysis(this);
        }

    }

}
