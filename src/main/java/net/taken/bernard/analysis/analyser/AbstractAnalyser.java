package net.taken.bernard.analysis.analyser;

import static net.taken.bernard.analysis.SentenceAnalysis.SentenceAnalysisBuilder;

/**
 * Created by Jeremy on 04/03/2017.
 */
public abstract class AbstractAnalyser {

    protected AbstractAnalyser next;

    public void setNext(AbstractAnalyser next) {
        this.next = next;
    }

    public final SentenceAnalysisBuilder analyze(String sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        hookAnalyze(sentence, sentenceAnalysisBuilder);
        if (next == null)
            return sentenceAnalysisBuilder;
        return next.analyze(sentence, sentenceAnalysisBuilder);
    }

    protected abstract void hookAnalyze(String sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder);

}
