import java.util.LinkedList;
import java.util.Queue;

 class Consumerclass {

    int capacity;
    Queue<Integer> storage = new LinkedList<>();
    public Consumerclass (int capacity){
        this.capacity = capacity;
    }
    public  synchronized  void produce(int value) throws InterruptedException{
        if (storage.size()==capacity){
            wait();
        }
        storage.add(value);
        System.out.println("Produced"+ value);
        notify();
    }
    public synchronized int consume() throws InterruptedException{
        if(storage.isEmpty()){
            wait();
        }
        int value = storage.poll();
        System.out.println("Consume" + value);
        notify();
        return value;
    }
}

public class Consumer {
    public static void main(String[] args){
        Consumerclass pc = new Consumerclass(10);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                try{
                    pc.produce(i);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }) ;


        Thread t2 = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                try{
                    pc.consume();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }) ;

        t1.start();
        t2.start();
    }
}