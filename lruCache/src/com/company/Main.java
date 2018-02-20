package com.company;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<String, String>(3);

        for (int i=1; i<=5; ++i) {
            System.out.println("- insert " + i);
            cache.set(Integer.toString(i), Integer.toString(i));
            System.out.println("   head: " + cache.head.key);
            System.out.println("   last: " + cache.last.key);
        }

        System.out.println("- get 2 " + cache.get("2"));
        System.out.println("   head: " + cache.head.key);
        System.out.println("   last: " + cache.last.key);
        System.out.println("- get 4 " + cache.get("4"));
        System.out.println("   head: " + cache.head.key);
        System.out.println("   last: " + cache.last.key);
        System.out.println("- get 3 " + cache.get("3"));
        System.out.println("   head: " + cache.head.key);
        System.out.println("   last: " + cache.last.key);
        System.out.println("- get 3 " + cache.get("3"));
        System.out.println("   head: " + cache.head.key);
        System.out.println("   last: " + cache.last.key);
        System.out.println("- insert 6");
        cache.set("6", "6");
        System.out.println("   head: " + cache.head.key);
        System.out.println("   last: " + cache.last.key);
        System.out.println("expexted size = " + cache.size + "  real size = " + cache.map.size());
    }
}
