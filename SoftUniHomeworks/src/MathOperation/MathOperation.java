package MathOperation;

public class MathOperation {

    public int add(int a, int b) {
        return sum(a, b);
    }

    public int add(int a, int b, int c) {
        return sum(a,b ,c);
    }

    public int add(int a, int b, int c, int d) {
        return sum(a,b ,c, d);
    }

    private int sum(int... nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
