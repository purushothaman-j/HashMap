import lib.CustomHashMap;
import lib.OrderPair;
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, World!");

      //  CustomHashMap<String> thisHashMap = new CustomHashMap<>("kumar", "fun");
       // CustomHashMap<Integer> thisHashMap2 = new CustomHashMap<>("kumar", 3);
     //   System.out.println(thisHashMap.getValue()+" "+thisHashMap2.getValue());

        OrderPair<String,Integer> Pair1 = new OrderPair<>("kumar",4);
        OrderPair<Integer, String> Pair2 = new OrderPair<>(4, "kumar");
System.out.println(Pair1.getValue());
System.out.println((Pair1.getKey()));
System.out.println(Pair2.getValue());
    }

}