package javabasestructure;


import java.util.Scanner;

/**
 * @author Amos
 * @date 7/26/2020 9:24 PM
 */
public class EnumTT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size");
        String inputString = scanner.next().toUpperCase();
        Size size = Enum.valueOf(Size.class,inputString);
        System.out.println("size = " + size);
        System.out.println("size.get = " + size.getAbbreviation());
        if(size == Size.EXTRA_LARGE){
            System.out.println("Fine ");
        }
    }
}



enum Size{
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){return abbreviation;}
    private String abbreviation;
}
