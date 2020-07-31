package javabasestructure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.Instant;
import java.util.Timer;

/**
 * @author Amos
 * @date 7/31/2020 10:51 PM
 */
public class Timett {
    public static void main(String[] args) {
        TimePrinter timePrinter = new TimePrinter();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
}


class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent event){
        System.out.println("Instant.ofEpochMilli(event.getWhen()) = " + Instant.ofEpochMilli(event.getWhen()));

        Toolkit.getDefaultToolkit().beep();
    }
}
