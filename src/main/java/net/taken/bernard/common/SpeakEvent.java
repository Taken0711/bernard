package net.taken.bernard.common;

import java.util.EventObject;

/**
 * Created by Jeremy on 25/02/2017.
 */
public class SpeakEvent extends EventObject {

    private final String says;

    public SpeakEvent(Object source, String says) {
        super(source);
        this.says = says;
    }

    public String getSays() {
        return says;
    }
}
