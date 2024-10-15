package ch.hslu.oop.sw02;

public class DatentypDemo {

    public void execute() {
        this.intTest();
        this.floatTest();
        this.testCalculate();
    }

    private void intTest() {
        System.out.println("intTest");
        int testNumber = 2147483647;
        testNumber += 1;
        System.out.println(testNumber);

        int testNumber2 = 2147483647 + 1;
        System.out.println(testNumber2);
    }

    private void floatTest() {
        System.out.println("floatTest");
        float testNumber = 3.4028235e38f;
        testNumber += 1.0f;
        System.out.println(testNumber);

        float testNumber2 = 3.4028235e38f;
        testNumber2 += 3.4028235e38f;
        System.out.println(testNumber2);
    }

    private void testCalculate() {
        System.out.println("testCalculate");
        System.out.println("Test only with integers");
        System.out.println(2 + 5 / 2);

        System.out.println("Test only with floats");
        System.out.println(2f + 5f / 2f);

        System.out.println("Test only with double");
        System.out.println(2.0 + 5.0 / 2.0);
    }
}
