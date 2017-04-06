package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.common.Sentence;

import java.util.ArrayList;
import java.util.List;

import static net.taken.bernard.util.AnalysisUtils.chainAnalysers;

/**
 * Created by jerem on 06/04/2017.
 */
public class CompositeAnalyser extends AbstractAnalyser {
    private List<AbstractAnalyser> analysers;

    @Override
    public void hookAnalyze(Sentence sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        analysers.get(0).analyze(sentence, sentenceAnalysisBuilder);
    }

    protected final void setAnalysers(List<AbstractAnalyser> analysers) {
        this.analysers = analysers;
        chainAnalysers(analysers);
    }
}
