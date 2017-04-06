package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.common.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static net.taken.bernard.util.AnalysisUtils.chainAnalysers;

/**
 * Created by jerem on 01/04/2017.
 */
public class InterrogativeAnalyser extends CompositeAnalyser {

    public InterrogativeAnalyser() {
        List<AbstractAnalyser> analysers = new ArrayList<>();
        analysers.add(new InterrogativeWordAnalyser());
        analysers.add(new AuxiliaryAnalyser());
        setAnalysers(analysers);
    }

}
