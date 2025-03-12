package lib;

public class OrderPair<K,V> implements Pair<K,V>{

    private K key;
    private V value;
    public OrderPair(K key, V value){
        this.key = key;
        this.value = value;
    }



    public K getKey() {
        return this.key;
    }


    public V getValue() {
        return this.value;
    }
}
