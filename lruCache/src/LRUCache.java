package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class LRUCache<K, V> {
    class DoubleList<K, V> {
        K key;
        V value;
        DoubleList<K, V> next;
        DoubleList<K, V> prev;

        DoubleList(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    Map<K, DoubleList<K, V>> map;
    DoubleList<K, V> head;
    DoubleList<K, V> last;
    int size;

    LRUCache(int size) {
        this.map = new HashMap<K, DoubleList<K, V>>();
        this.size = size;
        this.head = null;
        this.last = null;
    }

    void set(K key, V value) {
        DoubleList<K, V> exist = map.get(key);

        if (exist != null) {
            exist.value = value;
            touch(key);
        }
        else {
            exist = new DoubleList<K, V>(key, value);
            map.put(key, exist);

            DoubleList<K, V> o = head;

            head = exist;
            head.next = o;
            head.prev = null;
            if (o != null) {
                head.next.prev = head;
            }

            if (last == null) {
                last = head;
            }

            DoubleList<K, V> l = last;

            if (l != null && map.size() > size) {
                last = l.prev;
                last.next = null;
                map.remove(l.key);
            }
        }
    }

    V get(K key) {
        DoubleList<K, V> c = map.get(key);
        if (c != null) {
            touch(key);
            return c.value;
        }

        return null;
    }

    private void touch(K key) {
        DoubleList<K, V> c = map.get(key);
        DoubleList<K, V> o = head;

        if (map.size() > 1 && c != null && o != null) {
            if (c == last) {
                last = c.prev;
            }

            if (c.prev != null) {
                c.prev.next = c.next;
            }
            if (c.next != null) {
                c.next.prev = c.prev;
            }

            head = c;
            c.next = o;
            c.prev = null;
            o.prev = c;
        }
    }
}

