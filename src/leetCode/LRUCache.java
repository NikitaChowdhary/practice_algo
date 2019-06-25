package leetCode;


import java.util.*;

// https://leetcode.com/problems/lru-cache/
public class LRUCache {

    PriorityQueue<Cache> queue = new PriorityQueue<>(new Comparator<Cache>() {
        @Override
        public int compare(Cache o1, Cache o2) {
            return o1.current.compareTo(o2.current);
        }
    });

    Map<Integer, Cache> cacheMap = new HashMap<>();
    int maxCapacity;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Cache current = cacheMap.get(key);
            queue.remove(current);
            Cache newCache = new Cache(key, current.val);
            queue.add(newCache);
            cacheMap.put(key, newCache);
            return current.val;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            queue.remove(cacheMap.get(key));
        }
        else if (queue.size() == maxCapacity) {
            Cache current = queue.poll();
            cacheMap.remove(current.key);
        }
        Cache newCache = new Cache(key, value);
        cacheMap.put(key, newCache);
        queue.add(newCache);
    }

    class Cache {
        int key;
        int val;
        Date current;

        Cache(int key, int val) {
            this.key = key;
            this.val = val;
            this.current = new Date();
        }

        Cache(int key, int val, Date date) {
            this.key = key;
            this.val = val;
            this.current = date;
        }
    }
}
