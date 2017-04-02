package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.common.Sentence;
import org.junit.Before;
import org.junit.Test;

import static net.taken.bernard.analysis.attribute.SentenceType.*;
import static org.junit.Assert.*;

/**
 * Created by jerem on 01/04/2017.
 */
public class SentenceTypeAnalyserTest {

    private TypeAnalyser analyser;
    private String someWords;

    @Before
    public void setUp() throws Exception {
        analyser = new TypeAnalyser();
        someWords = "jirejf aerfi jeairof";
    }

    @Test
    public void changeTypeInSentenceAnalysis() throws Exception {
        SentenceAnalysis.SentenceAnalysisBuilder builder = new SentenceAnalysis.SentenceAnalysisBuilder();
        analyser.hookAnalyze(new Sentence(""), builder);
        assertEquals(DECLARATIVE, builder.build().sentenceType);
    }

    @Test
    public void identifyExclamatorySentence() throws Exception {
        Sentence sentence = new Sentence(someWords + "!");
        assertEquals(EXCLAMATORY, analyser.getSentenceType(sentence));
    }

    @Test
    public void identifyDeclarativeSentence() throws Exception {
        Sentence sentence = new Sentence(someWords + ".");
        assertEquals(DECLARATIVE, analyser.getSentenceType(sentence));
    }

    @Test
    public void identifyInterrogativeSentence() throws Exception {
        Sentence sentence = new Sentence(someWords + "?");
        assertEquals(INTERROGATIVE, analyser.getSentenceType(sentence));
    }

    @Test
    public void shouldReturnDeclarativeWhenNoIdentifier() throws Exception {
        Sentence sentence = new Sentence(someWords);
        assertEquals(DECLARATIVE, analyser.getSentenceType(sentence));
    }

    @Test
    public void shouldTakeCareOnlyLastWhenManyIdentifiers() throws Exception {
        Sentence sentence = new Sentence(someWords + "!?..?!.!?");
        assertEquals(INTERROGATIVE, analyser.getSentenceType(sentence));
    }

    @Test
    public void shouldReturnDeclarativeWhenEmptySentence() throws Exception {
        assertEquals(DECLARATIVE, analyser.getSentenceType(new Sentence("")));
    }
}
