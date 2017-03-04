package net.taken.bernard.common;

import net.taken.bernard.analysis.SentenceAnalysis;
import net.taken.bernard.analysis.SentenceAnalysisFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.event.EventListenerList;

import static net.taken.bernard.common.Mode.ONLINE;
import static net.taken.bernard.common.Mode.SLEEPMODE;

/**
 * Created by Jeremy on 25/02/2017.
 */
public class Model {

    private static final Logger logger = LogManager.getLogger(Model.class);
    private Mode mode;

    private EventListenerList listenerList = new EventListenerList();
    private SpeakEvent speakEvent = null;

    Model() {
        mode = SLEEPMODE;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        logger.info("System in now " + mode.toString());
        speakEvent = new SpeakEvent(this, mode.getMessage());
    }

    public void addSpeakEventListener(SpeakEventListener l) {
        listenerList.add(SpeakEventListener.class, l);
    }

    private void fireSpeakEvent() {
        SpeakEventListener[] listeners = listenerList.getListeners(SpeakEventListener.class);
        if (speakEvent == null)
            throw new IllegalStateException("Speak event is null");
        for(SpeakEventListener listener: listeners) {
            listener.speak(speakEvent);
        }
    }

    void analyseSentence(String sentence) {
        SentenceAnalysis sentenceAnalysis = SentenceAnalysisFactory.getSentenceAnalysis(sentence);
        logger.info("Received answer: " + sentence);
        if (getMode() == SLEEPMODE) {
            if ("Bring yourself back online Bernard".equals(sentence))
                setMode(ONLINE);
            else {
                speakEvent = new SpeakEvent(this, mode.getMessage());
                fireSpeakEvent();
            }
        } else {
            speakEvent = new SpeakEvent(this, "This was a " + sentenceAnalysis.effect + " sentence.");
        }

        fireSpeakEvent();
    }

    private void unknowAnswer() {
        speakEvent = new SpeakEvent(this, "This doesn't mean anything to me.");
        fireSpeakEvent();
    }
}
