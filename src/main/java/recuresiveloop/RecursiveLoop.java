package recuresiveloop;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhengyang on 5/14/2017.
 */
public abstract class RecursiveLoop<T, R> {
    private List<List<T>> loops;
    private List<T> vars;
    private R result;

    /**
     * Constructor for loop without return value.
     * @param loops
     */
    public RecursiveLoop(List<List<T>> loops) {
        this.loops = loops;
        this.vars = loops.stream()
                .map(var -> var.get(0))
                .collect(Collectors.toList());
    }

    /**
     * Constructor for loop with return value.
     * @param loops
     * @param initialResult
     */
    public RecursiveLoop(List<List<T>> loops, R initialResult) {
        this.loops = loops;
        this.vars = loops.stream()
                .map(var -> var.get(0))
                .collect(Collectors.toList());
        this.result = initialResult;
    }

    public void loop() {
        loop(0);
    }

    // Recursive loop
    private void loop(int i) {
        if (i == loops.size()) {
            result = handle(vars, result);
        } else {
            loops.get(i).stream().forEach( e -> {
                        vars.set(i, e);
                        loop(i + 1);
                    });
        }
    }

    /**
     * Implement loop handler logic by overriding this method.
     * @param vars variable vector
     * @param result temporary result from last step.
     * @return temporary result for next step.
     */
    public abstract R handle(List vars, R result);

    public R getResult() {
        return result;
    }
}
