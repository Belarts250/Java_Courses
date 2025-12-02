import java.util.Date;
import java.util.Scanner;


class Person{
    private int id ;
    private String name;
    private Date dob;

}
class Account extends Person {

    public int accountNumber;
    static int balance = 0;


    static int deposit(int balance) {
        int amount = 0;
        System.out.println("Enter amount to deposit");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextInt();

        if (amount < 0) {

            System.out.println("You can not deposit negative money!");
        }

        return amount;
    }


    static int withdraw(int balance) {
        int amount;
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextInt();


        if (amount > balance) {
            System.out.println(" You don't have enough money to with draw");

        }
        return amount;

    }

    public class BankingApp {

        public static void main(String[] args) {
            int choice;
            System.out.println("Welcome");
            System.out.println("1.Enter amount to deposit");
            System.out.println("2.Enter amount to withdraw");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> balance = +deposit(balance);
                case 2 -> balance = +withdraw(balance);

                default -> System.out.println("Invalid input");
            }

        }
    }
}