package net.taken.bernard.analysis;

import static net.taken.bernard.analysis.SentenceAnalysis.*;

/**
 * Created by Jeremy on 04/03/2017.
 */
public abstract class AbstractAnalyzer {

    private AbstractAnalyzer next;

    public void setNext(AbstractAnalyzer next) {
        this.next = next;
    }

    public final SentenceAnalysisBuilder analyze(String sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        hookAnalyze(sentence, sentenceAnalysisBuilder);
        if (next == null)
            return sentenceAnalysisBuilder;
        return next.analyze(sentence, sentenceAnalysisBuilder);
    }

    abstract void hookAnalyze(String sentence, SentenceAnalysisBuilder sentenceAnalysis);

}
