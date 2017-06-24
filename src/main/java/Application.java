import recuresiveloop.RecursiveLoop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhengyang on 5/14/2017.
 */
public class Application {

    public static void main(String[] args) {
        List<List<Integer>> loops = new ArrayList<>();
        loops.add(Arrays.asList(1, 2, 3));
        loops.add(Arrays.asList(11, 12, 13));
        loops.add(Arrays.asList(21, 22, 23));
        loops.add(Arrays.asList(31, 32, 33));
        loops.add(Arrays.asList(41, 42, 43));
        loops.add(Arrays.asList(51, 52, 53));

        System.out.println("Print loops:");
        RecursiveLoop printLoop = new RecursiveLoop(loops) {
            @Override
            public int handle(int[] vars, int result) {
                print(vars);
                return 0;
            }
        };
        printLoop.loop();

        System.out.println("\nCalculate max sum:");
        RecursiveLoop maxSum = new RecursiveLoop(loops, Integer.MIN_VALUE) {
            @Override
            public int handle(int[] vars, int result) {
                return calculateMaxSum(vars, result);
            }
        };
        maxSum.loop();
        System.out.println("Max sum: " + maxSum.getResult());
    }

    static void print(int[] vars) {
        Arrays.stream(vars).forEach( e -> System.out.print(e + ", "));
        System.out.println();
    }

    static int calculateMaxSum(int[] vars, int result) {
        int currentSum = Arrays.stream(vars).sum();
        return (result < currentSum) ? currentSum : result;
    }
}
