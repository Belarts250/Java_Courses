import java.util.LinkedList;
import java.util.Queue;

public class ProdCons {
    int capacity;
    Queue<Integer> storage = new LinkedList<>();
    public ProdCons(int capacity){
        this.capacity = capacity;
    }
    public synchronized void produce(int value) throws InterruptedException{
        if(storage.size() == capacity){
            wait();
        }
        storage.add(value);
        System.out.println("Produced " + value);
        notify();
    }

    public synchronized int consume() throws InterruptedException{
        if(storage.isEmpty()){
            wait();
        }

        int value = storage.poll();
        System.out.println("Consumed value " + value);
        notify();
        return value;
    }
}
