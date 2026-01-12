package me.graceteng.neetcode;

public class RemoveElement {
    static int removeElement(int[] nums, int element) {
        if (nums.length == 0) {
            return 0;
        }

        int startPointer = 0;
        int endPointer = nums.length - 1;

        // counting from the end of the array,
        // find the index of the first number,
        // that is not "element"
        while (endPointer > 0 && nums[endPointer] == element) {
            endPointer--;
        }

        while (startPointer < endPointer) {
            int currentValue = nums[startPointer];
            if (currentValue == element) {
                // current element needs to be removed
                // swap it out with a suitable number
                // from the end of the array
                nums[startPointer] = nums[endPointer];
                nums[endPointer] = element;
                endPointer--;
            }
            // update start and end pointers
            startPointer++;
            while (nums[endPointer] == element) {
                endPointer--;
            }
        }

        return (nums[startPointer] == element)
                ? startPointer
                : startPointer + 1;
    }
}
