package org.Algorithm.ClassicalAlgorithm;

import java.util.HashMap;

/**
 * Created by Ellen on 2017/8/28.
 */
public class LRU3<K, V> {

    public entry first;
    public entry last;
    private final int MAX_SIZE;
    private final float LOAD_FACTORY;
    private HashMap<K, entry<K, V>> map;

    public LRU3(int initSize) {
        this.MAX_SIZE = initSize;
        this.LOAD_FACTORY = 0.75f;
        this.map = new HashMap<>();
        this.first = null;
        this.last = null;
    }

    public void put(K key, V value) {
        entry<K, V> entry = getEntry(key);
        if (entry == null) {
            if (map.size() > MAX_SIZE) {
                map.remove(last.key);
                removeLast();
            }
            entry = new entry();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        map.put(key, entry);
    }

    public void clear() {
        first = null;
        last = null;
        map.clear();
    }

    public V get(K key) {
        entry<K, V> entry = map.get(key);
        if (entry == null) {
            return null;
        }
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key) {
        entry<K, V> entry = map.get(key);
        if (entry == null) {
            return;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry == first) {
            first = entry.next;
        }
        if (entry == last) {
            last = entry.pre;
        }
        map.remove(key);
    }

    public int size() {
        return map.size();
    }

    private void moveToFirst(entry entry) {
        if (first == entry) {
            return;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry == last) {
            last = last.pre;
        }
        if (first == null || last == null) {
            first = entry;
            last = entry;
            return;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        first.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    public entry<K, V> getEntry(K key) {
        return map.get(key);
    }

    class entry<K, V> {
        entry pre;
        entry next;
        K key;
        V value;
    }


}
