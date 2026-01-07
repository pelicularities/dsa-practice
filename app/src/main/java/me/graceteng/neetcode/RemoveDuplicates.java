package me.graceteng.neetcode;

public class RemoveDuplicates {
    static int removeDuplicates(int[] nums) {
        // number that we are currently checking for duplicates
        int currentValue = nums[0];
        // how many indices' offset we need to account for
        // when updating array in places
        int offset = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentValue) {
                // current number is a duplicate
                // advance the offset
                offset++;
            } else {
                // current number is not a duplicate
                // copy the current number into nums[i - offset]
                nums[i - offset] = nums[i];
                // update the current value
                currentValue = nums[i];
            }
        }
        // offset represents the number of duplicates
        return nums.length - offset;
    }
}
