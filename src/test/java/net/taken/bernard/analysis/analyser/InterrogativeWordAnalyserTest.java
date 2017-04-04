package net.taken.bernard.analysis.analyser;
import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.analysis.attribute.InterrogativeWord;
import net.taken.bernard.common.Sentence;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static net.taken.bernard.analysis.attribute.InterrogativeWord.*;
import static net.taken.bernard.common.WordType.INTERROGATIVE_WORD;
import static org.junit.Assert.*;
/**
 * Created by jerem on 01/04/2017.
 */
public class InterrogativeWordAnalyserTest {

    private static InterrogativeWordAnalyser analyser;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        analyser = new InterrogativeWordAnalyser();
    }

    @Test
    public void identifyAllInterrogativeWord() throws Exception {
        for (InterrogativeWord word: InterrogativeWord.values()) {
            Sentence sentence = new Sentence(word.toString() + " fjebnrfui gfeger ?");
            System.out.println(sentence.getSentenceString());
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

    @Test
    public void shouldSetInterrogativeWordWhenSingleInterrogativeWord() throws Exception {
        Sentence sentence = new Sentence("How often fjebnrfui gfeger ?");
        SentenceAnalysis.SentenceAnalysisBuilder builder = new SentenceAnalysis.SentenceAnalysisBuilder();
        analyser.hookAnalyze(sentence, builder);
        assertEquals(HOW_OFTEN, analyser.getInterrogativeWord(sentence));
        assertTrue(sentence.getWordList().contains("How often"));
        assertEquals(INTERROGATIVE_WORD, sentence.getWordType("How often").get());
        assertEquals(HOW_OFTEN, builder.build().interrogativeWord);
    }
}
