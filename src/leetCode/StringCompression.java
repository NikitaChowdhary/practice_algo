package leetcode;

// https://leetcode.com/problems/string-compression/submissions/
class StringCompression {
    int unique = 0;
    public int compress(char[] chars) {
        int lastUpdated = 0;
        for (int i = 0; i< chars.length; ) {
            int count = 0;
            while ( (i + count) < chars.length && chars[i + count] == chars[i])
                count++;
            unique++;
            chars[lastUpdated] = chars[i];
            lastUpdated++;
            if (count > 1) {
                String str = Integer.toString(count);
                unique += str.length();
                for (int j =0 ; j< str.length(); j++) {
                    chars[lastUpdated] = str.charAt(j);
                    lastUpdated++;
                }
            }

            i = i + count;
        }
        return unique;
    }

    public static void main(String[] args) {
        System.out.println("Starting something");
        char[] inp = new char[] {'a', 'a', 'b', 'c'};
        System.out.println(new StringCompression().compress(inp));
        System.out.println(inp);
    }
}