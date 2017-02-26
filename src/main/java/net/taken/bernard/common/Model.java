package net.taken.bernard.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.event.EventListenerList;

import static net.taken.bernard.common.Mode.*;

/**
 * Created by Jeremy on 25/02/2017.
 */
public class Model {

    private static final Logger logger = LogManager.getLogger(Model.class);
    private Mode mode;

    private EventListenerList listenerList = new EventListenerList();
    private SpeakEvent speakEvent = null;

    public Model() {
        mode = SLEEPMODE;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        logger.info("System in now on " + mode.toString());
        speakEvent = new SpeakEvent(this, mode.getMessage());
        fireSpeakEvent();
    }

    public void addSpeakEventListener(SpeakEventListener l) {
        listenerList.add(SpeakEventListener.class, l);
    }

    public void removeSpeakEventListener(SpeakEventListener l) {
        listenerList.remove(SpeakEventListener.class, l);
    }

    protected void fireSpeakEvent() {
        SpeakEventListener[] listeners = listenerList.getListeners(SpeakEventListener.class);
        if (speakEvent == null)
            throw new IllegalStateException("Speak event is null");
        for(SpeakEventListener listener: listeners) {
            listener.speak(speakEvent);
        }
    }

    public void analyzeAnswer(String ans) {
        logger.info("Received answer: " + ans);
        if (getMode() == SLEEPMODE) {
            if (ans.equals("Bring yourself back online Bernard"))
                setMode(ONLINE);
            else {
                speakEvent = new SpeakEvent(this, mode.getMessage());
                fireSpeakEvent();
            }
        } else {
            unknowAnswer();
        }
    }

    private void unknowAnswer() {
        speakEvent = new SpeakEvent(this, "This doesn't mean anything to me.");
        fireSpeakEvent();
    }
}
