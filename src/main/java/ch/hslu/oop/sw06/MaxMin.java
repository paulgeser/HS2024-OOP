package ch.hslu.oop.sw06;

public class MaxMin {

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public  int min(int a, int b) {
        return a < b ? a : b;
    }

    public int max(int a, int b, int c) {
        return this.max(this.max(a, b), c);
    }
}
