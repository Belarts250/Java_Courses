//class Boy extends Thread{
//    public void run(){
//        for(int i=0; i<20; i++){
//            System.out.println("Boy");
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
//class Boy implements Runnable{
//    public void run(){
//        for(int i=0; i<20; i++){
//            System.out.println("Boy");
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
//
//
//class Girl extends Thread{
//    public void run(){
//        for(int i=0; i<20; i++){
//            System.out.println("Girl");
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}

class Counter{
    int count;
    public synchronized increment(){
        count++;
    }
}

//import org.w3c.dom.css.Counter;

public class MultiplierMain {
    public static void main(String[] args){
//        Multiplier mult = (x,y)->x*y;
//        int k= mult.multiply(4,5);
//        System.out.println(k);

//        Girl g = new Girl();
//        Boy b = new Boy();
//        g.start();
//        b.start();

//        Runnable b = new Boy();
//        Thread t1 =  new Thread(b);
//        t1.start();


  Counter counter = new Counter();
  Runnable counter1 = ()->{

  };


        Runnable Girl = () -> {

            for (int i = 0; i < 20; i++) {
                System.out.println("Girl");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };

        Runnable Boy = () -> {

            for (int i = 0; i < 20; i++) {
                System.out.println("Boy");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };

        Runnable b = new Thread();
        Thread t1 =  new Thread(Boy);
        t1.start();

        Runnable g = new Thread();
        Thread t2 =  new Thread(Girl);
        t2.start();
    }
}
