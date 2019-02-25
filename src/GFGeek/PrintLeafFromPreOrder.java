package GFGeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintLeafFromPreOrder {
    // https://practice.geeksforgeeks.org/problems/print-leaf-nodes-from-preorder-traversal-of-bst/0#ExpectOP
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());

        while(cases-- != 0) {
            int nodes = Integer.parseInt(in.readLine());
            String[] ordering = in.readLine().split(" ");

            String[] res = getLeaf(ordering, 0, nodes - 1);
            for (String s: res) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static String[] getLeaf(String[] ordering, int start, int end) {
        if (start > end) return new String[0];
        if (start == end) return new String[]{ordering[start]};

//        if (end - start <= 1) return new String[]{ordering[start], ordering[end]};

        int right = getRightTree(ordering, start, end);
        String[] leftLeaf = getLeaf(ordering, start + 1, right - 1);
        String[] rightLeaf = getLeaf(ordering, right, end);
        String[] res = new String[leftLeaf.length + rightLeaf.length];
        int i = 0;
        for (String str: leftLeaf) {
            res[i] = str;
            i++;
        }
        for (String str: rightLeaf) {
            res[i] = str;
            i++;
        }
        return res;
    }

    private static int getRightTree(String[] ordering, int start, int end) {
        String root = ordering[start];

        int i = start + 1;
        while(i <= end && Integer.parseInt(ordering[i]) < Integer.parseInt(root)) {
            i++;
        }
        return i;
    }
}
