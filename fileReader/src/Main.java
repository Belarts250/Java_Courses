import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args){
//        File file = new File("./hello.txt" );

//        try(PrintWriter  writer = new PrintWriter(new FileWriter(file, true))){
//            writer.println("Wake up ...");
//            writer.println(" ok..");
//        }catch(IOException e){
//            e.getMessage();
//        }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter data or type 'exit' to quit : ");
//        String line;
//
//        while(scanner.hasNext()){
//            line = scanner.nextLine();
//            if(line.equalsIgnoreCase("exit"))
//                break;
//            System.out.println("You wrote :" + line);
//        }
//        scanner.close();
//    }
//}

//class Delimiter2{
//    public static void main(String []a){
////        String data = "Honorine turamuha bonbon 5";
//        String data2 = "17/10/2025";
////        Scanner scanner = new Scanner(data);
//        Scanner scanner1 = new Scanner(data2);
////        String token1 = scanner.next();
////        String token2 = scanner.next();
////        String token3 = scanner.next();
////        int token4 = scanner.nextInt();
//
////        scanner1.useDelimiter("/");
////        int part1 = scanner1.nextInt();
////        int part2 = scanner1.nextInt();
////        int part3 = scanner1.nextInt();
////
////        int add = part1 + part2 + part3;
////
////        System.out.println("The sum is: " + add);
//
////        System.out.println("Name: " + token1 + " bonbon: "+ token4);
////        scanner1.close();
//    }
//}

//class NumberFormatting {
//    public static  void main(String[] args){
//        double num = 1920392.2093;
//        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
//        NumberFormat frFormat = NumberFormat.getInstance(Locale.FRANCE);
//
//        System.out.println("French format: " + frFormat.format(num));
//        System.out.println("US format:" + usFormat.format(num));
//
//    }
//}

class Printing{
    public static void main(String[] args){
        System.out.printf("%b%n", 7 < 6);
        System.out.printf("%-10s |%5s%n", "name", "age");
        System.out.printf("--------------------------|%n");
        System.out.printf("%-10s |%5d%n", "Josh", 17);
        System.out.printf("--------------------------|%n");
        System.out.printf("%-10s |%5d%n", "Jane", 12);
        System.out.printf("--------------------------|%n");
        System.out.printf("%-10s |%5d%n", "John", 18);
    }
}