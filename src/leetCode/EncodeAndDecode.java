package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */
public class EncodeAndDecode {
    Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int encoded = longUrl.hashCode();
        map.put(encoded, longUrl);
        return "http://tinyurl.com/" + encoded;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int number = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return map.getOrDefault(number, "Not found");
    }
}
