package leetCode;

/**
 * https://leetcode.com/problems/shortest-word-distance/solution/
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {

        int pos1 = -1, pos2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i< words.length; i++) {
            if (words[i].equals(word1))
                pos1 = i;
            if (words[i].equals(word2))
                pos2 = i;
            if (pos1 != -1 && pos2 != -1) {
                min = Math.min(min, Math.abs(pos1 - pos2));
            }
        }
        return min;

    }
}
