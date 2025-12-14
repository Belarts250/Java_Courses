import java.util.Date;
import java.util.Scanner;



class Person {
    private int id;
    private String name;
    private Date dob;

}


class Account extends Person {

        public int accountNumber;
        public int balance = 0;

        Account(int accountNumber){
            this.accountNumber = accountNumber;
        }

     int deposit() {


        Scanner scanner = new Scanner(System.in);
         System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();

        if (amount < 0) {

            System.out.println("You can not deposit negative money!");
        }

        return balance += amount ;
    }


     int withdraw() {

        Scanner scanner = new Scanner(System.in);
         System.out.print("Enter amount to withdraw : ");
        int amount = scanner.nextInt();

        if (amount > balance) {
            System.out.println(" You don't have enough money to with draw");

        }
        return balance -= amount;

    }



}


public class Bank {


    public static void main(String[] args){
        int choice;
        boolean isAv = true;
        Account bk = new Account(987656789);



        while(isAv) {

            System.out.println("Welcome");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> bk.deposit();
                case 2 -> bk.withdraw();
                case 3 -> isAv= false;
                default -> System.out.println("Invalid input");
            }

        }

    }


}
