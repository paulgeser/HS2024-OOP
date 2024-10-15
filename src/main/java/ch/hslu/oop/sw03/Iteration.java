package ch.hslu.oop.sw03;

public class Iteration {


    public void countWithFor() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public void countWithWhile() {
        int i = 0;
        while (i <= 10) {
            System.out.println(i);
            i += 1;
        }
    }

    public void countWithDoWhile() {
        int i = -1;
        do {
            i += 1;
            System.out.println(i);
        } while (i < 10);
    }


    public void countFloat() {
        int count = 1;
        for (float i = 0.9f; i <= 10; i += 0.000025f) {
            System.out.println(count);
            count++;
        }
    }

    public void countFloat4000() {
        float i = 0.9f;
        for (int count = 1; count <= 4000; count++) {
            i += 0.000025f;
        }
        System.out.println(i);
    }

    public void printBox(final int width, final int height) {
        if (width < 1 || height < 1) {
            System.out.println("Invalid dimensions");
            return; // Early exit if invalid dimensions
        }
        for (int internalHeight = 1; internalHeight <= height; internalHeight++) {
            for (int internalWidth = 1; internalWidth <= width; internalWidth++) {
                if (internalHeight == 1 || internalHeight == height || internalWidth == 1 || internalWidth == width) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printBoxShort(final int width, final int height) {
        if (width <= 0 || height <= 0) return; // Early exit if parameters impossible
        String border = "#".repeat(width);
        System.out.println(border);
        for (int i = 1; i < height - 1; i++)
            System.out.println("#" + " ".repeat(width - 2) + "#");
        if (height > 1) System.out.println(border);
    }

    public void printBoxUltraShort(final int w, final int h) {
        if (w <= 0 || h <= 0) return;
        System.out.println("#".repeat(w));
        for (int i = 1; i < h - 1; i++) System.out.println("#" + " ".repeat(w - 2) + "#");
        if (h > 1) System.out.println("#".repeat(w));
    }
}
