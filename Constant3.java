package javabasestructure;

/**
 * @author Amos
 * @date 7/21/2020 9:48 PM
 */
public class Constant3 {
    public static final double CM_PER_INCH = 2.54;
    public static void main(String[] args) {
        double paperWidth = 32;
        double paperHeight = 12;
        System.out.println("paperHeight*CM_PER_INCH = " + paperHeight*CM_PER_INCH);
        System.out.println("paperWidth*CM_PER_INCH = " + paperWidth*CM_PER_INCH);
    }
}
