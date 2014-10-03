package fr.qrcodegenerator.ui.events;

import javax.swing.*;
import java.awt.*;

/**
 * User: Pascal AUREGAN
 * Date: 9/21/14
 * paste from http://ruben42.wordpress.com/2009/03/30/catching-all-runtime-exceptions-in-swing/
 */
public class EventQueueProxy extends EventQueue {

    protected void dispatchEvent(AWTEvent newEvent) {
        try {
            super.dispatchEvent(newEvent);
        } catch (Throwable t) {
            t.printStackTrace();
            String message = t.getMessage();

            if (message == null || message.length() == 0) {
                message = "Fatal: " + t.getClass();
            }

            JOptionPane.showMessageDialog(null, message, message, JOptionPane.ERROR_MESSAGE);
        }
    }
}