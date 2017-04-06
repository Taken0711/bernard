package net.taken.bernard.analysis;

import net.taken.bernard.analysis.analyser.AbstractAnalyser;
import net.taken.bernard.analysis.analyser.EffectAnalyser;
import net.taken.bernard.analysis.analyser.SentenceAnalyser;
import net.taken.bernard.analysis.analyser.TypeAnalyser;
import net.taken.bernard.analysis.analyser.data.EffectData;
import net.taken.bernard.common.Sentence;

import java.util.ArrayList;
import java.util.List;

import static net.taken.bernard.analysis.SentenceAnalysis.SentenceAnalysisBuilder;
import static net.taken.bernard.util.AnalysisUtils.chainAnalysers;

/**
 * Created by Jeremy on 04/03/2017.
 */
public class SentenceAnalysisFactory {

    private static AbstractAnalyser analyser = new SentenceAnalyser();

    private SentenceAnalysisFactory() {
    }

    public static SentenceAnalysis getSentenceAnalysis(String sentenceString) {
        Sentence sentence = new Sentence(sentenceString);
        SentenceAnalysisBuilder builder =  analyser.analyze(sentence, new SentenceAnalysisBuilder());
        return builder.build();
    }

}
