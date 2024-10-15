package ch.hslu.oop.sw03;

public class Demo {

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
