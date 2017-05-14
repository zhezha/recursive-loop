package recuresiveloop;

import java.util.List;

/**
 * Created by zhengyang on 5/14/2017.
 */
public class RecursiveLoop {
    private List<List<Integer>> loops;
    private int[] vars;
    private LoopHandler handler;

    public RecursiveLoop(List<List<Integer>> loops, LoopHandler handler) {
        this.loops = loops;
        this.vars = new int[loops.size()];
        this.handler = handler;
    }

    public void loop() {
        loop(0);
    }

    private void loop(int i) {
        if (i == loops.size()) {
            handler.handle(vars);
        } else {
            loops.get(i).stream().forEach( e -> {
                        vars[i] = e;
                        loop(i + 1);
                    });
        }
    }
}
