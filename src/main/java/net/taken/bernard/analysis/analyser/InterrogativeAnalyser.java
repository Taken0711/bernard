package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;

import java.util.ArrayList;
import java.util.List;

import static net.taken.bernard.util.AnalysisUtils.*;

/**
 * Created by jerem on 01/04/2017.
 */
public class InterrogativeAnalyser extends AbstractAnalyser {

    private List<AbstractAnalyser> analysers = new ArrayList<>();

    public InterrogativeAnalyser() {
        analysers.add(new InterrogativeWordAnalyser());

        chainAnalysers(analysers);
    }

    @Override
    protected void hookAnalyze(String sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
        analysers.get(0).hookAnalyze(sentence, sentenceAnalysisBuilder);
    }

}
