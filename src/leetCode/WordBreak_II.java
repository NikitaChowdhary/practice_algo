    package leetCode;

    /**
     *
     * https://leetcode.com/problems/word-break-ii/
     *
     *
     * */

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    public class WordBreak_II {

        public static ArrayList<String> wordBreak(String s, List<String> wordDict) {
            ArrayList<String> [] dp = new ArrayList[s.length() + 1];
            // Empty string matches the word dictionary


            dp[0] = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {

                // Continue only when some string is matched
                if (dp[i] == null) continue;

                for (int j = i + 1; j <=s.length(); j++) {
                    String temp = s.substring(i, j);
                    if (wordDict.contains(temp)) {
                        if (dp[j] == null)
                            dp[j] = new ArrayList<>();
                        dp[j].add(temp);
                    }
                }
            }
            if (dp[s.length()] == null) return new ArrayList<>();
            else {
                ArrayList<String> result = new ArrayList<>();
                dfs(dp, result, "", s.length());
                return result;
            }

        }

        private static void dfs(ArrayList<String>[] dp, ArrayList<String> result, String current, int length) {
            if (length == 0) {
                result.add(current.trim());
                return;
            } else {
                for (String s: dp[length]) {
                    String temp = s+ " " + current;
                    dfs(dp, result, temp, length - s.length());
                }
            }
        }

        public static void main(String[] args) {
            String ip1 = "pineapplepenapple";
            List<String> dict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

            ArrayList<String> dp = wordBreak(ip1, dict);

            System.out.println(dp);
        }
    }
