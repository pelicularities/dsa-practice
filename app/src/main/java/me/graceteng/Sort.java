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

    private static int[] merge(int[] leftHalf, int[] rightHalf) {
        // find size of arrays
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // merge sorted halves
        int[] sortedNumbers = new int[leftSize + rightSize];
        int sortedIndex = 0;
        int leftHalfIndex = 0;
        int rightHalfIndex = 0;

        while (leftHalfIndex < leftSize && rightHalfIndex < rightSize) {
            if (leftHalf[leftHalfIndex] < rightHalf[rightHalfIndex]) {
                // left half's smallest value is smaller than right half's
                sortedNumbers[sortedIndex] = leftHalf[leftHalfIndex];
                leftHalfIndex++;
            } else {
                // right half's smallest value is smaller or equal to left half's
                sortedNumbers[sortedIndex] = rightHalf[rightHalfIndex];
                rightHalfIndex++;
            }

            sortedIndex++;
        }

        // there may still be remaining numbers in either leftHalf or rightHalf
        // the next two while loops should be mutually exclusive
        while (leftHalfIndex < leftSize) {
            sortedNumbers[sortedIndex] = leftHalf[leftHalfIndex];
            sortedIndex++;
            leftHalfIndex++;
        }

        while (rightHalfIndex < rightSize) {
            sortedNumbers[sortedIndex] = rightHalf[rightHalfIndex];
            sortedIndex++;
            rightHalfIndex++;
        }

        return sortedNumbers;
    }

    public static int[] mergeSort(int[] numbers) {
        // intuition: divide and conquer recursively
        // base case: there is only 1 element, so we are sorted
        if (numbers.length < 2) {
            return numbers;
        }

        // common case: there are 2 or more elements
        // divide the input array into 2 equal(ish) parts
        int midpoint = numbers.length / 2;
        int[] leftHalf = new int[midpoint];
        int[] rightHalf = new int[numbers.length - midpoint];

        // populate smaller arrays
        System.arraycopy(numbers, 0, leftHalf, 0, midpoint);
        System.arraycopy(numbers, midpoint, rightHalf, 0, numbers.length - midpoint);

        // recurse: sort halves
        int[] sortedLeftHalf = mergeSort(leftHalf);
        int[] sortedRightHalf = mergeSort(rightHalf);

        // conquer: merge sorted halves
        return merge(sortedLeftHalf, sortedRightHalf);
    }
}
