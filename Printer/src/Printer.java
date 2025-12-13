public class Printer <T>{
    T valueToPrint ;
    public Printer(T valueToPrint){
        this.valueToPrint = valueToPrint;
    }

    public void print(){
        System.out.println("value :" + valueToPrint);
    }
}
