package net.taken.bernard.common;

import java.util.EventListener;

/**
 * Created by Jeremy on 25/02/2017.
 */
@FunctionalInterface
public interface SpeakEventListener extends EventListener {

    public void speak(SpeakEvent event);

}
