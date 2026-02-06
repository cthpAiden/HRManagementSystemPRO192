package Utilities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataInput {
    private static final Scanner sc = new Scanner(System.in);

    public static int getInteger(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println(">> Sai dinh dang so! Nhap lai.");
            }
        }
    }

    public static double getDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println(">> Wrong format! Please input again.");
            }
        }
    }

    public static String getString(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    public static LocalDate getDate(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String s = sc.nextLine().trim();
                return LocalDate.parse(s, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e) {
                System.out.println(">> Wrong date format (dd/MM/yyyy)! Please input again.");
            }
        }
    }
}