import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/11 9:39 下午
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(divide(-1, -1));
//        long i = 2147483648L;
//        System.out.println((int) i);
    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int res = 0;
        int sign = (a > 0) && (b > 0) || (a < 0) && (b < 0) ? 1 : -1;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }

        while (a <= b) {
            a = a - b;
            res++;
        }

        return sign == 1 ? res : -res;
    }
}
