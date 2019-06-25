package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_Optimized {

    // Head is LRU and tail is MRU. We add to MRU and remvoe from LRU

    Map<Integer, CacheValue> keyValueMap = new HashMap<>();
    CacheValue lru = null;
    CacheValue mru = null;
    int maxCapacity;


    public LRUCache_Optimized(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        int result = -1;
        if (keyValueMap.containsKey(key)) {
            CacheValue current = keyValueMap.get(key);
            deleteNode(current);
            makeNodeMRU(current);
            result = current.val;
        }
        return result;

    }

    private void makeNodeMRU(CacheValue current) {

        current.next = null;
        current.previous = mru;
        if (mru != null)
            mru.next = current;
        mru = current;

        if (lru == null)
            lru = mru;

    }

    private void deleteNode(CacheValue current) {
        CacheValue next = current.next;
        CacheValue previous = current.previous;

        if (previous != null)
            previous.next = next;
        else {
            lru = next;
        }

        if (next != null)
            next.previous = previous;
        else {
            mru = previous;
        }

    }

    public void put(int key, int value) {
        if (keyValueMap.containsKey(key)) {
            deleteNode(keyValueMap.get(key));
            keyValueMap.get(key).val = value;
            makeNodeMRU(keyValueMap.get(key));
        } else {
            // Max capacity reached
            if (keyValueMap.size() == maxCapacity) {
                keyValueMap.remove(lru.key);
                deleteNode(lru);
            }

            CacheValue current = new CacheValue(key, value);
            keyValueMap.put(key, current);
            makeNodeMRU(current);
        }
    }

    class CacheValue {
        int key;
        int val;
        CacheValue next;
        CacheValue previous;
        CacheValue(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.previous = null;
        }
    }
}
