package lib;

import java.util.LinkedList;

public class CustomHashMap<K,V> {

   private static class Entry<K,V>{
       K key;
       V value;
       Entry(K key, V value){
           this.key = key;
           this.value = value;
       }
    }

    LinkedList<Entry<K,V>>[] bucket;


}
