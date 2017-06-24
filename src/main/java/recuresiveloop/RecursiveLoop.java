package recuresiveloop;

import java.util.List;

/**
 * Created by zhengyang on 5/14/2017.
 */
public abstract class RecursiveLoop {
    private List<List<Integer>> loops;
    private int[] vars;
    private int result;

    public RecursiveLoop(List<List<Integer>> loops) {
        this.loops = loops;
        this.vars = new int[loops.size()];
    }

    public RecursiveLoop(List<List<Integer>> loops, int result) {
        this.loops = loops;
        this.vars = new int[loops.size()];
        this.result = result;
    }

    public void loop() {
        loop(0);
    }

    private void loop(int i) {
        if (i == loops.size()) {
            result = handle(vars, result);
        } else {
            loops.get(i).stream().forEach( e -> {
                        vars[i] = e;
                        loop(i + 1);
                    });
        }
    }

    /**
     * Implement loop logic by overriding this method.
     * @param vars variable vector
     * @param result temporary result from last step.
     * @return temporary result for next step.
     */
    public abstract int handle(int[] vars, int result);

    public int getResult() {
        return result;
    }
}
