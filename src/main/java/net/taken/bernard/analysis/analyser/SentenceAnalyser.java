package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.analyser.data.EffectData;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jerem on 06/04/2017.
 */
public class SentenceAnalyser extends CompositeAnalyser {

    public SentenceAnalyser() {
        List<AbstractAnalyser> analysers = new ArrayList<>();
        analysers.add(new EffectAnalyser(new EffectData()));
        analysers.add(new TypeAnalyser());
        setAnalysers(analysers);
    }
}
