package javabasestructure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author Amos
 * @date 8/1/2020 9:44 AM
 */
public class AnonymousTT {
    public static void main(String[] args) {
        TalkingClockk talkingClock = new TalkingClockk();
        talkingClock.start(1000,true);
        JOptionPane.showMessageDialog(null,"Quit programe?");
        System.exit(0);
    }
}

class TalkingClockk
{
    public void start(int interval,boolean beep){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Instant.ofEpochMilli(event.getWhen()) = " + Instant.ofEpochMilli(event.getWhen()));
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        new Timer(interval,actionListener);
    }
}
