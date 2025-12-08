import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Exercise {
    public static void main(String[] args) throws ParseException {
        System.out.printf("%d %d %d%n", 10,20,30);
        System.out.printf("%.2f | %.4f | %.6f%n", Math.PI, Math.PI, Math.PI);
        System.out.printf("%-10s | %10d%n ", "Belise", 5);
        System.out.printf("%-10s | %10d%n ", "Dankie", 4);

        int salary = 12000000;
        System.out.printf("Salary:%,d%n", salary);
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        NumberFormat franceFormat = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println("The Us Format:" + usFormat.format(salary));
        System.out.println("The France format: " + franceFormat.format(salary));


        double num = 1999.99;
        System.out.printf("Salary:%,d%n", salary);
        NumberFormat usNumFormat = NumberFormat.getInstance(Locale.US);
        NumberFormat franceNumFormat = NumberFormat.getInstance(Locale.FRANCE);
        System.out.println("The Us Format:" + usNumFormat.format(num));
        System.out.println("The France format: " + franceNumFormat.format(num));


        double number = 123.45;
        System.out.printf("%+08.2f%n", number);

        System.out.printf("----------------------------------|%n");
        System.out.printf("%-10s |%5s |%10s%n", "Name", "Qty", "Price");
        System.out.printf("----------------------------------|%n");
        System.out.printf("%-10s |%5d |%,10.2f%n", "Apples", 5, 1200.5);
        System.out.printf("----------------------------------|%n");
        System.out.printf("%-10s |%5d |%,10.2f%n", "Bananas", 12, 300.75);
        System.out.printf("----------------------------------|%n");
        System.out.printf("%-10s |%5d |%,10.2f%n", "Mangoes", 3, 2500.0);
        System.out.printf("----------------------------------|%n");

        Date now = new Date();
        System.out.printf("Default Locale: %tc%n", now);
        System.out.printf(Locale.US, "US Locale: %tc%n", now);
        System.out.printf(Locale.FRANCE, "French Locale: %tc%n", now);
        System.out.printf(Locale.JAPAN, "Japanese Locale: %tc%n", now);

        String frenchNumber = "3,14";


        NumberFormat frenchFormat = NumberFormat.getInstance(Locale.FRANCE);
        Number numbers = frenchFormat.parse(frenchNumber);

        // Format to US locale
        NumberFormat usNumberFormat = NumberFormat.getInstance(Locale.US);
        System.out.printf("French: %s -> US: %s%n", frenchNumber, usNumberFormat.format(numbers));
    }
}
