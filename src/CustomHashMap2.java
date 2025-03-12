import java.util.LinkedList;
import java.util.Objects;

public class CustomHashMap2<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap2() {
        buckets = (LinkedList<Entry<K,V>>[]) new LinkedList[INITIAL_CAPACITY];
    }

    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (Objects.equals(entry.key, key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;

        if (size > LOAD_FACTOR * buckets.length) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (Objects.equals(entry.key, key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> Objects.equals(entry.key, key));
            size--;
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = (LinkedList<Entry<K, V>>[]) new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap2<String, Integer> map = new CustomHashMap2<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for 'one': " + map.get("one"));
        System.out.println("Value for 'two': " + map.get("two"));
        System.out.println("Contains key 'three'?: " + map.containsKey("three"));

        map.remove("two");
        System.out.println("Contains key 'two' after removal?: " + map.containsKey("two"));

        System.out.println("Size of map: " + map.size());
    }
}
