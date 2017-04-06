package net.taken.bernard.util;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.analysis.analyser.*;
import net.taken.bernard.analysis.attribute.Auxiliary;
import net.taken.bernard.common.Sentence;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by user on 04/04/2017.
 */
public class AnalysisUtilsTest {

    @Test
    public void chainAnalysers() throws Exception {
        List<AbstractAnalyser> analysers = new LinkedList<>();
        /*analysers.add(mock(TypeAnalyser.class));
        analysers.add(mock(TypeAnalyser.class));*/
        AbstractAnalyser analyser1 = new AbstractAnalyser() {
            @Override
            public void hookAnalyze(Sentence sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
            }
        };
        AbstractAnalyser analyser2 = new AbstractAnalyser() {
            @Override
            public void hookAnalyze(Sentence sentence, SentenceAnalysis.SentenceAnalysisBuilder sentenceAnalysisBuilder) {
            }
        };
        analysers.add(analyser1);
        analysers.add(analyser2);
        AnalysisUtils.chainAnalysers(analysers);
        assertEquals(analyser2, analyser1.getNext());
        assertTrue(analyser2.getNext() == null);
        Sentence sentence = new Sentence("?");
        SentenceAnalysis.SentenceAnalysisBuilder builder = new SentenceAnalysis.SentenceAnalysisBuilder();
        analysers.get(0).analyze(sentence, builder);
        //verify(analysers.get(0), times(1)).analyze(sentence, builder);
        //verify(analysers.get(1), times(1)).analyze(sentence, builder);
    }

}