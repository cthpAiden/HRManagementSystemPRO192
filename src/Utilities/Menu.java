package Utilities;
public class Menu {
    public static void print(String options) {
        String[] opts = options.split("\\|");
        for (String opt : opts) {
            System.out.println(opt);
        }
        System.out.print("Choose: ");
    }
}