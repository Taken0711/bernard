package net.taken.bernard.analysis;

import net.taken.bernard.analysis.analyser.AbstractAnalyser;
import net.taken.bernard.analysis.analyser.EffectAnalyser;
import net.taken.bernard.analysis.analyser.TypeAnalyser;
import net.taken.bernard.analysis.analyser.data.EffectData;
import net.taken.bernard.util.AnalysisUtils;

import java.util.ArrayList;
import java.util.List;

import static net.taken.bernard.analysis.SentenceAnalysis.SentenceAnalysisBuilder;
import static net.taken.bernard.util.AnalysisUtils.*;

/**
 * Created by Jeremy on 04/03/2017.
 */
public class SentenceAnalysisFactory {

    private static List<AbstractAnalyser> analysers = new ArrayList<>();

    static {
        initializeAnalyzers();
    }

    private SentenceAnalysisFactory() {
    }

    public static SentenceAnalysis getSentenceAnalysis(String sentence) {
        SentenceAnalysisBuilder builder =  analysers.get(0).analyze(sentence, new SentenceAnalysisBuilder());
        return builder.build();
    }

    private static void initializeAnalyzers() {
        analysers.add(new EffectAnalyser(new EffectData()));
        analysers.add(new TypeAnalyser());

        chainAnalysers(analysers);
    }

}
