package GFGeek;

public class SearchInRotated {

    public static void main(String[] args) {
        int[] input = {4,5,6,7,0,1,2};
        int key = 0;
        int[] input1 = {3, 1};

        System.out.println("Current Array");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        int index = searchInRotated(input1, 1, 0, input1.length - 1);

        if (index != -1)
            System.out.println("Key "+ key +" found in index " + index);
        else
            System.out.println("Key not found");


    }

    private static int searchInRotated(int[] input, int key, int start, int end) {

        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (input[mid] == key) return mid;

        else if (input[start] <= input[mid]) { // If first part is sorted
            if (key >= input[start] && key <= input[mid])
                return searchInRotated(input, key, start, mid - 1);
            else return searchInRotated(input, key, mid + 1, end);
        }

        else {
            if (key >= input[mid] && key <= input[end]) // If second part is sorted
                return searchInRotated(input, key, mid + 1, end);
            else return searchInRotated(input, key, start, mid - 1);
        }
    }
}
