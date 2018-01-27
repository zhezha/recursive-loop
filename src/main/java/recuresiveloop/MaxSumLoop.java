package recuresiveloop;

import java.util.List;

/**
 * Created by zhengyang on 1/27/2018.
 */
public class MaxSumLoop extends RecursiveLoop<Integer, Integer> {

    public MaxSumLoop(List<List<Integer>> loops, Integer initialResult) {
        super(loops, initialResult);
    }

    @Override
    public Integer handle(List vars, Integer result) {
        return calculateMaxSum(vars, result);
    }

    private Integer calculateMaxSum(List<Integer> vars, Integer result) {
        int currentSum = vars.stream().mapToInt(var -> var.intValue()).sum();
        return (result < currentSum) ? currentSum : result;
    }
}
