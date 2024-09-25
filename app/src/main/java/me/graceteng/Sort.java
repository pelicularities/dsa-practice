package me.graceteng;

public class Sort {

    public static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1;
            if (numbers[j] < numbers[i]) return false;
        }
        return true;
    }

    public static int[] bubbleSort(int[] numbers) {
        // intuition: first, check if list is sorted
        // while list is not sorted, proceed pairwise down the list
        // and swap positions if the larger number comes before the lower number

        boolean continueSorting = true;

        while (continueSorting) {
            continueSorting = false;
            for (int i = 0; i < numbers.length - 2; i++) {
                int j = i + 1;
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    continueSorting = true;
                }
            }
        }

        return numbers;
    }

    public static int[] insertionSort(int[] numbers) {
        // intuition: maintain a "sorted" section and an "unsorted" section
        // index 0 is already "sorted", so we start sorting at index 1
        // i is first unsorted index of current loop
        for (int i = 1; i < numbers.length; i++) {
            int currentValue = numbers[i];
            // we will use j to find the index of the largest number
            // that is smaller than currentValue
            int j = i - 1;
            while (j >= 0 && numbers[j] > currentValue) {
                // move every number to the right
                // to make room for currentValue
                // when we find its spot
                numbers[j + 1] = numbers[j];
                j--;
            }
            // insert currentValue
            numbers[j + 1] = currentValue;
        }

        return numbers;
    }
}
