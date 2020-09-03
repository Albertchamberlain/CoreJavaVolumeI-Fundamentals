package javabasestructure;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import javax.swing.*;

/**
 * @author Amos
 * @date 8/1/2020 9:17 AM
 */
public class InnnerClassTT {
    public static void main(String[] args) {

        TalkingClock talkingClock = new TalkingClock(100, true);
        talkingClock.start();
        JOptionPane.showMessageDialog(null,"Quit programe?");
        System.exit(0);
    }
}

class TalkingClock{
    private int interval;
    private  boolean beep;


    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        TimerPrinter timerPrinter = new TimerPrinter();
    }

    public class TimerPrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            System.out.println("Instant.ofEpochMilli(event.getWhen()) = " + Instant.ofEpochMilli(event.getWhen()));
            if(beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
}
}
