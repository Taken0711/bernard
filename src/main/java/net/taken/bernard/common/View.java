package net.taken.bernard.common;

/**
 * Created by Jeremy on 25/02/2017.
 */
public abstract class View implements SpeakEventListener {

    protected final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public abstract void display();

}
