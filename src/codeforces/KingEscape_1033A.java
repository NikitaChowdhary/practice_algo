package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KingEscape_1033A {

    static Position minPostion;
    static Position maxPosition;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        String[] queenPosition = in.readLine().split(" ");
        String[] kingInitialPosition = in.readLine().split(" ");
        String[] kingFinalPosition = in.readLine().split(" ");
        Position checkPost = new Position(Integer.parseInt(queenPosition[0]), Integer.parseInt(queenPosition[1]));

        Position start = new Position(Integer.parseInt(kingInitialPosition[0]), Integer.parseInt(kingInitialPosition[1]));
        Position end = new Position(Integer.parseInt(kingFinalPosition[0]), Integer.parseInt(kingFinalPosition[1]));

        setPositionsForKingArea(checkPost, start, end);
        if (end.x >= minPostion.x && end.x <= maxPosition.x && end.y >= minPostion.y && end.y <= maxPosition.y)
            System.out.println("YES");
        else System.out.println("NO");

    }

    private static void setPositionsForKingArea(Position checkPost, Position startKing, Position endKing) {
        if (startKing.x < checkPost.x && startKing.y < checkPost.y) { // Left bottom corner
            minPostion = new Position(1, 1);
            maxPosition = checkPost;
        }
        else if (startKing.x > checkPost.x && startKing.y > checkPost.y) { // Right top
            minPostion = checkPost;
            maxPosition = new Position(n, n);
        }
        else if (startKing.x > checkPost.x && startKing.y < checkPost.y) { // Left Top
            minPostion = new Position(checkPost.x, 1);
            maxPosition = new Position(n, checkPost.y);

        }
        else if (startKing.x < checkPost.x && startKing.y > checkPost.y) { // Right bottom
            minPostion = new Position(1, checkPost.y);
            maxPosition = new Position(checkPost.x, n);
        }
    }

    static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
