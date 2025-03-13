import javax.annotation.processing.SupportedSourceVersion;
import java.util.Objects;

public class CustomLinkedList {

public Node head;
public Node tail;

    public static  class Node{
        public  String value;
        public Node next;

        public Node(String value){
            this.value = value;
        }
    }

    public CustomLinkedList(){

    }

    public void put(String value){
        Node currentNode = new Node(value);

        if(head== null){
            this.head = currentNode;
            this.tail = currentNode;
            return;
        }
        this.tail.next = currentNode;
        this.tail = currentNode;
        return;
    }

    public Node search(Node node, String value){
        if(node == null){
            return null;
        }
        if(Objects.equals(node.value,value)){
            return node;
        }
        if(node.next == null){
            return null;
        }

       return this.search(node.next, value);


    }

    public Node get(String value){

        return search(this.head,value);

    }
    public static void main(String[] args){

        CustomLinkedList link1 = new CustomLinkedList();
        System.out.println(link1.head != null ? link1.head.toString() : null);
        System.out.println(link1.tail != null ? link1.tail.toString() : null);

        link1.put("kumar");
        System.out.println(link1.head != null ? link1.head.toString() : null);
        System.out.println(link1.tail != null ? link1.tail.toString() : null);

        link1.put("kurukuru");
        System.out.println(link1.head != null ? link1.head.toString() : null);
        System.out.println(link1.tail != null ? link1.tail.toString() : null);

        link1.put("shanthi");
        System.out.println(link1.head != null ? link1.head.toString() : null);
        System.out.println(link1.tail != null ? link1.tail.toString() : null);

        Node node = link1.get("kurukuru");
        System.out.println(node.value);

    }
}
