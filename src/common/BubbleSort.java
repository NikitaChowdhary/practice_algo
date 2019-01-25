package common;

public class BubbleSort {

    // Time complexity O(n2)
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        for (int i = 0; i< array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i< array.length; i++)
            System.out.print(array[i] + " ");
    }
}
