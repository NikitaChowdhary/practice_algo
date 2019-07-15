package leetCode;

import java.util.*;

// https://leetcode.com/problems/time-based-key-value-store/
public class TimeMap {

    Map<String, List<Pair>> keyValue;

    public TimeMap() {
        this.keyValue = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> current = keyValue.getOrDefault(key, new ArrayList<>());
        current.add(new Pair(value, timestamp));
        keyValue.put(key, current);
    }

    public String get(String key, int timestamp) {
        if (this.keyValue.containsKey(key)) {
            List<Pair> list = keyValue.get(key);
            Pair current = searchValueBeforeTimestamp(list, timestamp, 0, list.size() - 1);
            return current.value;
        } else return "";
    }

    private Pair searchValueBeforeTimestamp(List<Pair> pairs, int timestamp, int start, int end) {
        Pair result = new Pair("", timestamp);
        while (start <= end) {
            int mid = (end - start)/ 2 + start;
            Pair midPair = pairs.get(mid);
            if (midPair.timestamp == timestamp) {
                return midPair;
            }
            else if (timestamp > midPair.timestamp) {
                result = midPair;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    class Pair {
        String value;
        int timestamp;
        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
