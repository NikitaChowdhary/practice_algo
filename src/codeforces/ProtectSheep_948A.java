package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProtectSheep_948A {

    // LGTM but fails on 8th test case when submitting

    private static int col;
    private static int rows;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] dimension = in.readLine().split(" ");
        rows = Integer.parseInt(dimension[0]);
        col = Integer.parseInt(dimension[1]);

        char[][] graph = new char[rows][col];
        for (int i = 0; i < rows; i++) {
            String row = in.readLine();
            for (int j = 0; j < col; j++) {
                graph[i][j] = row.charAt(j);
            }
        }


        boolean result = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 'W') {
                    // Replace all adjacent with D, if any adjacent has S return "no"
                    result = checkAndReplace(graph, i - 1, j) &&
                            checkAndReplace(graph, i + 1, j) &&
                            checkAndReplace(graph, i, j - 1) &&
                            checkAndReplace(graph, i, j + 1);
                    if (!result) break;
                }
            }
        }

        if (result) {
            System.out.println("Yes");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(graph[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("No");
        }

    }

    private static boolean checkAndReplace(char[][] graph, int i, int j) {
        if (i >= 0 && i < rows
                &&
                j >= 0 && j < col) {
            if (graph[i][j] == 'S') {
                return false;
            }
            else if(graph[i][j] == '.')
                graph[i][j] = 'D';
        }
        return true;
    }
}
