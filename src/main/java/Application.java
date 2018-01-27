import recuresiveloop.MaxSumLoop;
import recuresiveloop.PrintLoop;
import recuresiveloop.RecursiveLoop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhengyang on 5/14/2017.
 */
public class Application {

    public static void main(String[] args) {
        ArrayList<List<Integer>> loops = new ArrayList<>();
        loops.add(Arrays.asList(1, 2, 3));
        loops.add(Arrays.asList(11, 12, 13));
        loops.add(Arrays.asList(21, 22, 23));
        loops.add(Arrays.asList(31, 32, 33));
        loops.add(Arrays.asList(41, 42, 43));
        loops.add(Arrays.asList(51, 52, 53));

        System.out.println("Print loops:");
        RecursiveLoop printLoop = new PrintLoop(loops);
        printLoop.loop();

        System.out.println("\nCalculate max sum:");
        RecursiveLoop maxSumLoop = new MaxSumLoop(loops, Integer.MIN_VALUE);
        maxSumLoop.loop();
        System.out.println("Max sum: " + maxSumLoop.getResult());
    }
}
