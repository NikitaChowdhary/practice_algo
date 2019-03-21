package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NatsyaReading_1136A {
    // https://codeforces.com/contest/1136/problem/A

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int chapters = Integer.parseInt(in.readLine());
        int[] pageNumber = new int[chapters];
        for (int i = 0; i< chapters; i++) {
            String[] current = in.readLine().split(" ");
            pageNumber[i] = Integer.parseInt(current[1]);
        }
        int currentPage = Integer.parseInt(in.readLine());

        System.out.println(chapters - getChaptersCompleted(currentPage, pageNumber, 0, chapters - 1));
    }

    private static int getChaptersCompleted(int searchPage, int[] pageNumbers, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) /2;
        if (pageNumbers[mid] == searchPage) return mid;
        else if (pageNumbers[mid] > searchPage && ((mid >= 1 && pageNumbers[mid - 1] < searchPage) || mid == 0)) return mid;

        else if (searchPage > pageNumbers[mid]) return getChaptersCompleted(searchPage, pageNumbers, mid + 1, end);

        else return getChaptersCompleted(searchPage, pageNumbers, start, mid - 1);
    }
}
