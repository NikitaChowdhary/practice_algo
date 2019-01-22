package common;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        for (int i = 0; i< array.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_index])
                    min_index = j;
            }
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }

        for (int i = 0; i< array.length; i++)
            System.out.print(array[i] + " ");
    }
}
