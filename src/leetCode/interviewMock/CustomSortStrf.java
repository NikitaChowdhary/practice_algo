package leetCode.interviewMock;

import java.util.*;

/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 *
 * S was sorted in some custom order previously. We want to permute the characters of
 * T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 *
 * Return any permutation of T (as a string) that satisfies this property.
 */
public class CustomSortStrf {

    public String customSortString(String S, String T) {

        Map<Character, Integer> pos = new HashMap<>();
        int i = 0;
        for (char c: S.toCharArray())
            pos.put(c, i++);

        List<Sorted> sortedList = new ArrayList<>();
        for (char c: T.toCharArray()) {
            sortedList.add(new Sorted(pos.getOrDefault(c, Integer.MAX_VALUE), c));
        }

        Comparator<Sorted> comp = new Comparator<Sorted>() {
            @Override
            public int compare(Sorted o1, Sorted o2) {
                if (o1.pos < o2.pos)
                    return -1;
                else if (o1.pos == o2.pos)
                    return 0;
                else return 1;
            }
        };
        Collections.sort(sortedList, comp);
        StringBuilder str = new StringBuilder();

        for (Sorted res: sortedList) {
            str.append(res.c);
        }
        return str.toString();
    }

    class Sorted {
        int pos;
        char c;
        Sorted(int pos, char c) {
            this.pos = pos;
            this.c = c;
        }
    }
}
