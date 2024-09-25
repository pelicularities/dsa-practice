package me.graceteng;

public class Fibonacci {
    public static int generateNumber(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return generateNumber(n - 1) + generateNumber(n - 2);
    }
}
