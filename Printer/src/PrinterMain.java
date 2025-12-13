import java.util.ArrayList;

public class PrinterMain {
    public static void main(String[] args){
        Printer<Double> printer = new Printer<>(4.5);
        Printer<String> printer2 = new Printer<>("hi");
        printer.print();
        printer2.print();

        printsAnyType("Dankie", 2);
        printsAnyType(90.4, "ok" );
        int sum = numbersOnly(2,4);
        System.out.println(sum);

        ArrayList<Number> nums = new ArrayList<>();
        nums.add(23);
        nums.add(4.5);
        nums.add(640205401);

        System.out.println(nums);

    }
// for receiving any type
    public static <T, U> void printsAnyType(T first, U second){
        System.out.println("First value: " + first);
        System.out.println("Second value: " + second);
    }

// restrict to get numbers only and the return their sum
    public  static  <M extends Number, P extends  Number> int numbersOnly(M first, P second){
        return first.intValue() + second.intValue();
    }

//
   class PrintTwo<A, B>{
        A a ;
        B b;
        PrintTwo(A a, B b){
            this.a = a;
            this.b = b;
        }
        public void print(){
            System.out.println("Two type value is :"+a);
            System.out.println("Two type value is :"+b);
        }
}



}
