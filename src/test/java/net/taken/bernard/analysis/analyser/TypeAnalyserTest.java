package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import org.junit.Before;
import org.junit.Test;

import static net.taken.bernard.analysis.attribute.Type.*;
import static org.junit.Assert.*;

/**
 * Created by jerem on 01/04/2017.
 */
public class TypeAnalyserTest {

    private TypeAnalyser analyser;

    @Before
    public void setUp() throws Exception {
        analyser = new TypeAnalyser();
    }

    @Test
    public void changeTypeInSentenceAnalysis() throws Exception {
        SentenceAnalysis.SentenceAnalysisBuilder builder = new SentenceAnalysis.SentenceAnalysisBuilder();
        analyser.hookAnalyze("", builder);
        assertEquals(DECLARATIVE, builder.build().type);
    }

    @Test
    public void identifyExclamatorySentence() throws Exception {
        assertEquals(EXCLAMATORY, analyser.getSentenceType("jirejf aerfi jeairof !"));
    }

    @Test
    public void identifyDeclarativeSentence() throws Exception {
        assertEquals(DECLARATIVE, analyser.getSentenceType("jirejf aerfi jeairof."));
    }

    @Test
    public void identifyInterrogativeSentence() throws Exception {
        assertEquals(INTERROGATIVE, analyser.getSentenceType("jirejf aerfi jeairof ?"));
    }

    @Test
    public void shouldReturnDeclarativeWhenNoIdentifier() throws Exception {
        assertEquals(DECLARATIVE, analyser.getSentenceType("jirejf aerfi jeairof"));
    }

    @Test
    public void shouldTakeCareOnlyLastWhenManyIdentifiers() throws Exception {
        assertEquals(INTERROGATIVE, analyser.getSentenceType("jirejf aerfi jeairof ..!??.!?"));
    }

    @Test
    public void shouldReturnDeclarativeWhenEmptySentence() throws Exception {
        assertEquals(DECLARATIVE, analyser.getSentenceType(""));
    }
}
