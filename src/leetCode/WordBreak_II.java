    package leetCode;

    // https://leetcode.com/problems/word-break-ii/

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.List;

    public class WordBreak_II {

        public static List<String> wordBreak(String s, List<String> wordDict) {

            return new ArrayList<>();
        }


            /**
             *
             * TLE
             *
             *
            public static List<String> wordBreak(String s, List<String> wordDict) {
                List<List<String>> dp = new ArrayList<>();
                // Empty string matches the word dictionary
                for (int i = 0; i< s.length() + 1; i++)
                    dp.add(i, new ArrayList<>());

                List<String> temp = new ArrayList<>();
                temp.add("");
                dp.set(0, temp);
                for (int i = 0; i < s.length(); i++) {

                    // Continue only when some string is matched
                    if (dp.get(i).size() == 0) continue;

                    for (String word: wordDict) {
                        int end = i + word.length();
                        if (s.length() >= end && s.substring(i, end).equals(word)) {
                            List<String> result = new ArrayList<>();
                            if (!dp.get(end).isEmpty())
                                result = dp.get(end);

                            for (int k = 0; k < dp.get(i).size(); k++) {
                                String finalWord = dp.get(i).get(k) + " " + word;
                                result.add(finalWord.trim());
                            }
                            dp.set(end, result);
                        }

                    }
                }

                return dp.get(s.length());

            }
             **/

        public static void main(String[] args) {
            String ip1 = "pineapplepenapple";
            List<String> dict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

            System.out.println(wordBreak(ip1, dict));
        }
    }
