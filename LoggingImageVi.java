package javabasestructure;

import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

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
            final WindowHandler windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("com.horstmann.corejava").addHandler(windowHandler);

            final ImageViewFrame imageViewFrame = new ImageViewFrame();
            imageViewFrame.setTitle("LoggingImageViewer");
            imageViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("com.horstmann.corejava").fine("Showing frame");
            imageViewFrame.setVisible(true);
        });
    }
}


class ImageViewFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final  int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static  Logger logger = Logger.getLogger("com.horstmann.corejava");

    public ImageViewFrame(){
        logger.entering("ImageViewFrame","<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        final JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        final JMenuItem file = new JMenu("File");
        jMenuBar.add(file);


        final JMenuItem open = new JMenuItem("Open");
        file.add(open);

        final JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });
        final JLabel jLabel = new JLabel();
        add(jLabel);
        logger.exiting("ImageViewFrame","<init>");
    }
}


class WindowHandler extends StreamHandler {
    private  JFrame frame;
    public WindowHandler(){
        frame = new JFrame();
        final JTextArea jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        frame.setSize(200,200);
        frame.add(new JSplitPane());
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
            @Override
            public void write(byte[] b, int off, int len){
                jTextArea.append(new String(b,off,len));
            }
        });
    }

    @Override
    public void publish(LogRecord record){
        if(!frame.isVisible()) {
            return;
        }
        super.publish(record);
        flush();
    }
}
