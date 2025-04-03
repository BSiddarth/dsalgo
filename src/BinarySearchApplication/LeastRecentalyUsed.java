package BinarySearchApplication;


import java.util.HashMap;
import java.util.LinkedHashSet;

public class LeastRecentalyUsed<K,V>{
    int capacity;
   final  HashMap<K,V> map;
   final LinkedHashSet<K> keys;

    public LeastRecentalyUsed(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.keys = new LinkedHashSet<>();
    }







    public static void main(String[] args) {
    LeastRecentalyUsed<Integer,String> leastRecentalyUsed = new LeastRecentalyUsed<Integer,String> (2);

      leastRecentalyUsed.put(2,"A");

      leastRecentalyUsed.put(3,"B");

    String value=  leastRecentalyUsed.get(3);

      leastRecentalyUsed.put(4,"C");

       leastRecentalyUsed.put(4,"D");


    }
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
          }
        keys.add(key);
        keys.remove(key);
        map.get(key);
        return map.get(key);
    }
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            keys.remove(key);
            keys.add(key);
        }
        else {
            if (map.size() == capacity) {
                K lastKey = keys.getFirst();
                map.remove(lastKey);
                keys.remove(lastKey);
            }
        }
        map.put(key, value);
        keys.add(key);
    }


}
