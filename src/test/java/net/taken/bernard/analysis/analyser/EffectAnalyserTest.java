package net.taken.bernard.analysis.analyser;

import net.taken.bernard.analysis.analyser.data.EffectData;
import net.taken.bernard.common.Sentence;
import org.junit.Before;
import org.junit.Test;

import static net.taken.bernard.analysis.attribute.Effect.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Jeremy on 05/03/2017.
 */
public class EffectAnalyserTest {


    private EffectAnalyser analyser;
    private Sentence aSentence, aWord;

    @Before
    public void setUp() throws Exception {
        aSentence = new Sentence("1 2 3");
        aWord = new Sentence("1");

    }

    @Test
    public void identifyNegativeSentence() throws Exception {
        EffectData data = mock(EffectData.class);
        when(data.getWordEffect(anyString())).thenReturn(NEGATIVE, NEGATIVE, POSITIVE);
        analyser = new EffectAnalyser(data);
        assertEquals(NEGATIVE, analyser.getSentenceEffect(aSentence));
    }

    @Test
    public void identifyNegativeWord() throws Exception {
        EffectData data = mock(EffectData.class);
        when(data.getWordEffect(anyString())).thenReturn(NEGATIVE).thenThrow(new IllegalStateException());
        analyser = new EffectAnalyser(data);
        assertEquals(NEGATIVE, analyser.getSentenceEffect(aWord));
    }

    @Test
    public void identifyPositiveSentence() throws Exception {
        EffectData data = mock(EffectData.class);
        when(data.getWordEffect(anyString())).thenReturn(POSITIVE, POSITIVE, POSITIVE);
        analyser = new EffectAnalyser(data);
        assertEquals(POSITIVE, analyser.getSentenceEffect(aSentence));
    }

    @Test
    public void identifyPositiveWord() throws Exception {
        EffectData data = mock(EffectData.class);
        when(data.getWordEffect(anyString())).thenReturn(POSITIVE).thenThrow(new IllegalStateException());
        analyser = new EffectAnalyser(data);
        assertEquals(POSITIVE, analyser.getSentenceEffect(aWord));
    }

    @Test
    public void identifyNeutralSentence() throws Exception {
        EffectData data = mock(EffectData.class);
        when(data.getWordEffect(anyString())).thenReturn(NEUTRAL, POSITIVE, NEGATIVE);
        analyser = new EffectAnalyser(data);
        assertEquals(NEUTRAL, analyser.getSentenceEffect(aSentence));
    }

    @Test
    public void identifyNeutralWord() throws Exception {
        EffectData data = mock(EffectData.class);
        when(data.getWordEffect(anyString())).thenReturn(NEUTRAL).thenThrow(new IllegalStateException());
        analyser = new EffectAnalyser(data);
        assertEquals(NEUTRAL, analyser.getSentenceEffect(aWord));
    }

    @Test
    public void shouldReturnNeutralWhenEmptySentence() throws Exception {
        EffectData data = mock(EffectData.class);
        when(data.getWordEffect(anyString())).thenThrow(new IllegalStateException());
        analyser = new EffectAnalyser(data);
        assertEquals(NEUTRAL, analyser.getSentenceEffect(new Sentence("")));
    }
}