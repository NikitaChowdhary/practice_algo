package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/solution/
 *
 * Time complexity -> O(n * avg length of string)
 * Space complexity -> O(n * avg length of string)
 *
 */
public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {

        Set<String> distinctEmails = new HashSet<>();
        for (String email: emails) {
            String[] parts = email.split("@");
            String temp = parts[0].replace(".", "");
            int i = temp.indexOf('+');
            if (i != -1)
                temp = temp.substring(0, i);
            distinctEmails.add(temp + parts[1]);
        }
        return distinctEmails.size();
    }
}
