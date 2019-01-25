package common;

public class InsertionSort {

    // Time complexity O(n2)
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        for (int i = 1; i< array.length ; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j]>=key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j +  1] = key;
        }

        for (int i = 0; i< array.length; i++)
            System.out.print(array[i] + " ");
    }
}
