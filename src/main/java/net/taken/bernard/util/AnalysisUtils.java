package net.taken.bernard.util;

import net.taken.bernard.analysis.analyser.AbstractAnalyser;

import java.util.List;

/**
 * Created by jerem on 01/04/2017.
 */
public class AnalysisUtils {

    private AnalysisUtils() {
    }

    public static void chainAnalysers(List<AbstractAnalyser> analysers) {
        for (int i = 0; i < analysers.size(); i++) {
            AbstractAnalyser next = null;
            if (i < analysers.size() -1)
                next = analysers.get(i + 1);
            analysers.get(i).setNext(next);
        }
    }

}
