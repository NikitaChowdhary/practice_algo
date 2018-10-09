package common;

public class SearchInSorted2D {

    // Assuming array is n*n

    public boolean search(int key, int[][] input) {

        int i = 0;
        int j = input.length - 1;

        while (i < input.length && j >= 0) {
            if (input[i][j] == key) {
                System.out.println("Found the key at position [" + i + "][" + j + "]");
                return true;
            }
            else if (input[i][j] < key) i++;
            else if (input[i][j] > key) j--;
        }
        System.out.println("Key not found");
        return false;
    }

    public static void main(String[] args) {
        int[][] inp = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12, 13}, {14, 15, 16, 17}};
        System.out.println( new SearchInSorted2D().search(16, inp));
    }
}
