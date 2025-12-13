import java.io.*;
import java.util.Scanner;
import java.util.concurrent.*;

// ==========================
//  ABSTRACTION
// ==========================
abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public abstract String displayInfo();
}


// ==========================
//  INHERITANCE
// ==========================
class Visitor extends Person {
    private int visitor_id;
    private String purpose;

    public Visitor(int id, String name, int visitor_id, String purpose) {
        super(id, name);
        this.visitor_id = visitor_id;
        this.purpose = purpose;
    }

    @Override
    public String displayInfo() {
        return "======== WELCOME TO OUR VISITOR MANAGEMENT SYSTEM ========\n"
                + "Person ID: " + getId() + "\n"
                + "Name: " + getName() + "\n"
                + "Visitor ID: " + visitor_id + "\n"
                + "Purpose: " + purpose + "\n\n";
    }
}


// ==========================
//  GENERICS (Reusable Storage)
// ==========================
class Repository<T> {

    private final String filePath;

    public Repository(String filePath) {
        this.filePath = filePath;
    }

    // Save data to file
    public void save(T item) throws IOException {
        FileWriter fw = new FileWriter(filePath, true);
        fw.write(item.toString() + "\n");
        fw.close();
    }
}


// ==========================
//  MULTITHREADING TASK
// ==========================
class TicketWriterTask implements Runnable {

    private final Visitor visitor;
    private final String filePath;

    public TicketWriterTask(Visitor visitor, String filePath) {
        this.visitor = visitor;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(visitor.displayInfo());
            writer.close();
            System.out.println("Ticket saved successfully in " + filePath);
        } catch (IOException e) {
            System.out.println("Thread Error writing ticket: " + e.getMessage());
        }
    }
}


// ==========================
//  MAIN PROGRAM
// ==========================
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String ticketFile = "tickets.txt";

        // Executor Framework (thread pool of 3 threads)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        boolean running = true;

        while (running) {
            System.out.print("Do you want to book a ticket? (y/n): ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();

            if (choice == 'y' || choice == 'Y') {

                try {
                    System.out.print("Enter Person ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Visitor ID: ");
                    int visitorID = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Purpose: ");
                    String purpose = scanner.nextLine();

                    Visitor visitor = new Visitor(id, name, visitorID, purpose);

                    // MULTITHREADING: Save ticket using thread pool
                    executor.submit(new TicketWriterTask(visitor, ticketFile));

                    // ERROR HANDLING: Reading
                    System.out.println("\n------ SAVED TICKETS ------");
                    try (BufferedReader reader = new BufferedReader(new FileReader(ticketFile))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }

                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid number entered. Please enter digits only!");
                } catch (IOException ioe) {
                    System.out.println("File error: " + ioe.getMessage());
                } catch (Exception e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }

            } else if (choice == 'n' || choice == 'N') {
                running = false;
                System.out.println("Thank you for using our system! Goodbye 👋");
            } else {
                System.out.println("Invalid choice! Enter 'y' or 'n'.");
            }
        }

        executor.shutdown();  // Stop thread pool safely
    }
}
