package me.graceteng;

public class Sort {
    private final int[] numbers;
    public Sort(int[] numbers) {
        this.numbers = numbers;
    }

    public static boolean isSorted(int[] numbers) {
        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1;
            if (numbers[j] < numbers[i]) return false;
        }
        return true;
    }

    public int[] bubbleSort() {
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
                };
            }
        }

        return numbers;
    }

    public int[] sort() {
        return bubbleSort();
    }
}
