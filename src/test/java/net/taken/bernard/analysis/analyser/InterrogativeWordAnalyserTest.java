package net.taken.bernard.analysis.analyser;
import net.taken.bernard.analysis.analyser.data.EffectData;
import net.taken.bernard.analysis.attribute.InterrogativeWord;
import net.taken.bernard.common.Sentence;
import org.junit.Before;
import org.junit.Test;

import static net.taken.bernard.analysis.attribute.Effect.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * Created by jerem on 01/04/2017.
 */
public class InterrogativeWordAnalyserTest {

    InterrogativeWordAnalyser analyser;

    @Before
    public void setUp() throws Exception {
        analyser = new InterrogativeWordAnalyser();
    }

    @Test
    public void identifyAllInterrogativeWord() throws Exception {
        for (InterrogativeWord word: InterrogativeWord.values()) {
            Sentence sentence = new Sentence(word.toString() + " fjebnrfui gfeger ?");
            System.out.println(sentence.getSentence());
            assertEquals(word, analyser.getInterrogativeWord(sentence));
        }
    }

    @Test
    public void identifyAllInterrogativeWordWithDifferentCase() throws Exception {
        for (InterrogativeWord word: InterrogativeWord.values()) {
            Sentence sentence = new Sentence(word.toString().toUpperCase() + " fjebnrfui gfeger ?");
            assertEquals(word, analyser.getInterrogativeWord(sentence));
        }
    }
}
