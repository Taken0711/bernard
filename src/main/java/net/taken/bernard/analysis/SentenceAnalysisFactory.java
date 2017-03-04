package net.taken.bernard.analysis;

import java.util.ArrayList;
import java.util.List;
import static net.taken.bernard.analysis.SentenceAnalysis.*;
/**
 * Created by Jeremy on 04/03/2017.
 */
public class SentenceAnalysisFactory {

    private static List<AbstractAnalyzer> analyzers = new ArrayList<>();

    static {
        initializeAnalyzers();
    }

    private SentenceAnalysisFactory() {
    }

    public static SentenceAnalysis getSentenceAnalysis(String sentence) {
        SentenceAnalysisBuilder builder =  analyzers.get(0).analyze(sentence, new SentenceAnalysisBuilder());
        return builder.build();
    }

    private static void initializeAnalyzers() {
        analyzers.add(new EffectAnalyzer());

        for (int i = 0; i < analyzers.size(); i++) {
            AbstractAnalyzer next = null;
            if (i < analyzers.size() -1)
                next = analyzers.get(i + 1);
            analyzers.get(i).setNext(next);
        }
    }

}
