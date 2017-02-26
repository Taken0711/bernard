package net.taken.bernard.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Jeremy on 25/02/2017.
 */
public abstract class View implements SpeakEventListener {

    private static final Logger logger = LogManager.getLogger(View.class);
    protected final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public abstract void display();

    public abstract void speak(SpeakEvent event);
}
