package org.Algorithm.ClassicalAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ellen on 2017/8/28.
 */
public class LRU2<K, V> {

    private final int MAX_SIZE;
    private final float LOAD_FACTORY = 0.75f;
    private LinkedHashMap<K, V> map = null;

    public LRU2(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        map = new LinkedHashMap<K, V>((int) (MAX_SIZE / LOAD_FACTORY + 1), LOAD_FACTORY, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > MAX_SIZE;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return map.entrySet();
    }

    public synchronized int size() {
        return map.size();
    }

    public synchronized void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append(String.format("s% : s%  ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
