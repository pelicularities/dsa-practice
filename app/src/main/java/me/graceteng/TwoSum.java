package me.graceteng;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    int[] numbers;
    int target;

    public TwoSum(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
    }

    public int[] useNaiveSolution() {
        // this solution runs in O(n^2)
        for (int i = 0; i < this.numbers.length - 1; i++) {
            for (int j = 1; j < this.numbers.length; j++) {
                if (this.numbers[i] + this.numbers[j] == this.target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] useEfficientSolution() {
        // efficient solution
        // intuition: the naive solution requires O(n) time to "find" each index
        // once we have seen a number in the array,
        // can we check for its existence in O(1) time instead?
        // yes, we can, using a hashmap
        // this solution runs in O(n)

        Map<Integer, Integer> valueToIndex = new HashMap<>();

        valueToIndex.put(this.numbers[0], 0);

        for (int j = 1; j < this.numbers.length; j++) {
            // what value are we looking for to complement the number at index j?
            int difference = this.target - this.numbers[j];

            // have we already seen this number in the array?
            if (valueToIndex.containsKey(difference)) {
                // we need to return the smaller index first
                return new int[]{valueToIndex.get(difference), j};
            } else {
                // we hadn't seen numbers[j], but now we have
                // add it to the hashmap
                valueToIndex.put(this.numbers[j], j);
            }

        }

        // no match found
        return new int[]{};
    }

    public int[] getSolution() {
        // get indices of two numbers that add up to target
        // return the lower number first
        // if there is no match, return empty array
        return this.useEfficientSolution();
    }
}
