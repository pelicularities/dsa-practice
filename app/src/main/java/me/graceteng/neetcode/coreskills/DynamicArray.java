package me.graceteng.neetcode.coreskills;

public class DynamicArray {
    private int[] array;
    private int nextIndex = 0;
    public DynamicArray(int capacity) {
        this.array = new int[capacity];
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        // check if resizing is needed
        if (nextIndex >= array.length) {
            resize();
        }
        array[nextIndex] = n;
        nextIndex++;
    }

    public int popback() {
        nextIndex--;
        int value = array[nextIndex];
        // zero it out, since we can't make this value null
        array[nextIndex] = 0;
        return value;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        // System.arraycopy(array, 0, newArray, 0, array.length);
        // In the spirit of this exercise, I'm doing a manual copy
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getSize() {
        return nextIndex;
    }

    public int getCapacity() {
        return array.length;
    }
}
