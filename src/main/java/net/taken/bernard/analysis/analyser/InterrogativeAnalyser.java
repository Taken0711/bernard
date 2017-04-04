package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.common.Sentence;

import java.util.ArrayList;
import java.util.List;

import static net.taken.bernard.util.AnalysisUtils.chainAnalysers;

/**
 * Created by jerem on 01/04/2017.
 */
public class InterrogativeAnalyser extends AbstractAnalyser {

    private List<AbstractAnalyser> analysers = new ArrayList<>();

    public InterrogativeAnalyser() {
        analysers.add(new InterrogativeWordAnalyser());
        analysers.add(new AuxiliaryAnalyser());

        chainAnalysers(analysers);
    }

    @Override
    public void hookAnalyze(Sentence sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        analysers.get(0).hookAnalyze(sentence, sentenceAnalysisBuilder);
    }

}
