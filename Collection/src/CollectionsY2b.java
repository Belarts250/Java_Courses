import java.util.*;

public class CollectionsY2b {
    public static void main(String[] args) {
        List<Integer> c=new ArrayList<>();
        c.add(4);
        c.add(5);
        c.add(7);

        c.add(2);
        c.add(1,10);
        Iterator <Integer> it=c.iterator();
        while(it.hasNext()){
            int num=it.next();
            System.out.println(num);
        }
        c.remove(0);
        Collections.sort(c);
        Iterator <Integer> its=c.iterator();
        System.out.println("Sorted list");
        while(its.hasNext()){
            int num=its.next();
            System.out.println(num);
        }

//        System.out.println(c);
//        for(Object obj:c){
//            int num=(Integer) obj;
//            System.out.println(num);
//        }


        Map<String, Integer> marks = new HashMap<>();
        marks.put("Dankie", 90);
        marks.put("Dan", 70);
        marks.put("Dank", 98);
        marks.put("Kie", 85);
        marks.put("Kier", 19);
        System.out.println(marks);

    }
}