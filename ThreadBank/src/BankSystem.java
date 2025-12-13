import java.util.concurrent.atomic.AtomicInteger;

public class BankSystem {

    // ----- GLOBAL SETTINGS -----
    static final int TOTAL_TRANSACTIONS = 50;     // Stop after this many transactions
    static final int MAX_BALANCE = 500;           // Max account limit

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger(0); // counts successful transactions
        BankAccount account = new BankAccount(MAX_BALANCE, counter, TOTAL_TRANSACTIONS);

        Thread[] threads = new Thread[6];

        // Create 3 Depositors
        for (int i = 0; i < 3; i++) {
            threads[i] = new Depositor(account, "Depositor-" + i);
        }

        // Create 3 Withdrawers
        for (int i = 3; i < 6; i++) {
            threads[i] = new Withdrawer(account, "Withdrawer-" + (i - 3));
        }

        // Start all threads
        for (Thread t : threads) t.start();

        // Wait until enough transactions are completed
        while (counter.get() < TOTAL_TRANSACTIONS) {
            Thread.sleep(100);
        }

        // Interrupt all threads to stop them
        for (Thread t : threads) t.interrupt();

        // Join threads cleanly
        for (Thread t : threads) t.join();

        System.out.println("\n==========================");
        System.out.println("All Transactions Completed");
        System.out.println("==========================");
    }
}

class BankAccount {

    private int balance = 0;
    private final int MAX_BALANCE;
    private final AtomicInteger transactionCounter;
    private final int LIMIT;

    public BankAccount(int maxBalance, AtomicInteger counter, int limit) {
        this.MAX_BALANCE = maxBalance;
        this.transactionCounter = counter;
        this.LIMIT = limit;
    }

    // ------------------- DEPOSIT METHOD -------------------
    public synchronized void deposit(int amount) {
        while (balance + amount > MAX_BALANCE &&
                transactionCounter.get() < LIMIT) {

            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }

        if (transactionCounter.get() >= LIMIT) return;

        balance += amount;

        System.out.println(Thread.currentThread().getName() +
                " deposited: " + amount +
                " | New Balance = " + balance);

        transactionCounter.incrementAndGet();
        notifyAll();
    }

    // ------------------- WITHDRAW METHOD -------------------
    public synchronized void withdraw(int amount) {
        while (balance < amount &&
                transactionCounter.get() < LIMIT) {

            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }

        if (transactionCounter.get() >= LIMIT) return;

        balance -= amount;

        System.out.println(Thread.currentThread().getName() +
                " withdrew: " + amount +
                " | New Balance = " + balance);

        transactionCounter.incrementAndGet();
        notifyAll();
    }
}

// ------------------- DEPOSITOR THREAD -------------------
class Depositor extends Thread {
    private final BankAccount account;

    public Depositor(BankAccount acc, String name) {
        super(name);
        this.account = acc;
    }

    public void run() {
        while (!isInterrupted()) {
            int amount = 10 + (int)(Math.random() * 91); // random 10–100
            account.deposit(amount);

            try { Thread.sleep(50); } catch (InterruptedException e) { break; }
        }
    }
}

// ------------------- WITHDRAWER THREAD -------------------
class Withdrawer extends Thread {
    private final BankAccount account;

    public Withdrawer(BankAccount acc, String name) {
        super(name);
        this.account = acc;
    }

    public void run() {
        while (!isInterrupted()) {
            int amount = 10 + (int)(Math.random() * 71); // random 10–80
            account.withdraw(amount);

            try { Thread.sleep(50); } catch (InterruptedException e) { break; }
        }
    }
}
