package net.taken.bernard.analysis.analyser;

import net.taken.bernard.common.Sentence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.taken.bernard.analysis.SentenceAnalysis.SentenceAnalysisBuilder;

/**
 * Created by Jeremy on 04/03/2017.
 */
public abstract class AbstractAnalyser {

    private static final Logger logger = LogManager.getLogger(AbstractAnalyser.class);

    protected AbstractAnalyser next;

    public AbstractAnalyser getNext() {
        return next;
    }

    public void setNext(AbstractAnalyser next) {
        this.next = next;
    }

    public final SentenceAnalysisBuilder analyze(Sentence sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        hookAnalyze(sentence, sentenceAnalysisBuilder);
        logger.debug("Next is: " + next);
        if (next == null)
            return sentenceAnalysisBuilder;
        return next.analyze(sentence, sentenceAnalysisBuilder);
    }

    public abstract void hookAnalyze(Sentence sentence, SentenceAnalysisBuilder sentenceAnalysisBuilder);

}
