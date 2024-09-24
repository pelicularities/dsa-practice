package me.graceteng;

import lombok.Getter;

public class BinarySearch {

    private final int[] sortedArray;
    private final int target;
    @Getter
    private int iterations;

    public BinarySearch(int[] sortedArray, int target) {
        this.sortedArray = sortedArray;
        this.target = target;
    }

    public int findSolution() throws Exception {
        this.iterations = 0;

        // given a sorted array, find the index of a target number
        // if target number not in array, throw exception

        // intuition: start with a min and a max index
        int min = 0;
        int max = this.sortedArray.length - 1;

        while (min <= max) {
            // count iterations
            this.iterations++;

            // find the middle index in between min and max
            // does Java automatically do integer division?
            int middle = (min + max) / 2;

            // is the value there the target? if so, return it
            if (this.sortedArray[middle] == this.target) {
                return middle;
            }

            if (this.sortedArray[middle] > this.target) {
                // if middle value is higher than the target, the target index must be lower
                // so we lower the upper boundary to the middle index - 1
                max = middle - 1;
            } else {
                // if middle value is lower than the target, the target index must be higher
                // so we raise the lower bounary to the middle index + 1
                min = middle + 1;
            }
        }

        throw new Exception("Target value not found");
    }

}
