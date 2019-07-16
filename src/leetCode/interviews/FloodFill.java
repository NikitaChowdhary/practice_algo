package leetCode.interviews;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 */
public class FloodFill {
    int rows, cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        rows = image.length;
        if (rows == 0) return image;
        cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Position> queue = new ArrayDeque<>();

        int oldColor = image[sr][sc];
        queue.add(new Position(sr, sc));
        updateImage(image, queue, visited, newColor, oldColor);
        return image;
    }

    private void updateImage(int[][] image, Queue<Position> queue, boolean[][] visited, int newColor, int oldColor) {
        while(!queue.isEmpty()) {
            Position current = queue.poll();

            visited[current.row][current.col] = true;
            image[current.row][current.col] = newColor;
            for (Position adj: getAdjacent(current)) {
                if (image[adj.row][adj.col] == oldColor && !visited[adj.row][adj.col]) {
                    queue.add(adj);
                }
            }
        }
    }

    private List<Position> getAdjacent(Position current) {
        List<Position> result = new ArrayList<>();
        if (current.row - 1 >= 0)
            result.add(new Position(current.row - 1, current.col));
        if (current.row + 1 < rows)
            result.add(new Position(current.row + 1, current.col));
        if (current.col - 1 >= 0)
            result.add(new Position(current.row, current.col - 1));
        if (current.col + 1 < cols)
            result.add(new Position(current.row, current.col + 1));

        return result;
    }

    class Position {
        int row;
        int col;
        Position(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
}
