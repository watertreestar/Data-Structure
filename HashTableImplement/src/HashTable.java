/**
 * @ClassName HashTable
 * @Author ranger
 * @Date 2018/12/21
 **/

import java.util.TreeMap;

public class HashTable<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static int initCapacity = 7;
    private TreeMap<K, V>[] hashtable;

    private int M;    //  数组大小
    private int size;  // 元素个数

    public HashTable(int M) {
        this.M = M;
        this.size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    private int hash(K key) {
        return ((key.hashCode()) & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        int hash = hash(key);
        TreeMap map = hashtable[hash];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= M * upperTol) {
                resize(2 * M);
            }
        }
    }

    public V remove(K key) {
        int hash = hash(key);
        TreeMap<K, V> map = hashtable[hash];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < M * lowerTol && M / 2 >= initCapacity) {
                resize(M / 2);
            }
        }
        return ret;
    }

    public void set(K key, V value) {
        int hash = hash(key);
        TreeMap<K, V> map = hashtable[hash];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            throw new IllegalArgumentException(key + "doesn't exist");
        }
    }

    public boolean containsKey(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    /**
     * 扩容缩容
     * @param newCapacity
     */
    private void resize(int newCapacity){
        TreeMap<K,V> newHashTable[] = new TreeMap[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = this.M;
        this.M = newCapacity;

        for(int i =0;i<oldM;i++){
            TreeMap<K,V> map = hashtable[i];
            for (K key : map.keySet()){
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashtable = newHashTable;

    }


}
