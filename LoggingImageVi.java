package javabasestructure;

import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * @author Amos
 * @date 8/3/2020 12:05 AM
 */
public class LoggingImageVi {
    public static void main(String[] args) {
        if(System.getProperty("java.util.logging.config.class") ==null && System.getProperty("java.util.logging.config.file") ==null){
            try{
               Logger.getLogger("com.horstman.corejava").setLevel(Level.ALL);
               final int LOG_ROTATION_COUNT = 10;
                FileHandler fileHandler = new FileHandler("%h/LoggingImageView.log",0,LOG_ROTATION_COUNT);
                Logger.getLogger("com.horstmann.corejava").addHandler(fileHandler);
            } catch (IOException e) {
                Logger.getLogger("com.horstman.corejava").log(Level.SEVERE,"Can't creat log file");
            }

        }
        EventQueue.invokeLater(()->{
            new WindowHandler();
        });
    }
}


class WindowHandler extends StreamHandler
