package recuresiveloop;

import java.util.List;

/**
 * Created by zhengyang on 1/27/2018.
 */
public class PrintLoop extends RecursiveLoop<Integer, Object> {

    public PrintLoop(List<List<Integer>> loops) {
        super(loops);
    }

    @Override
    public Object handle(List vars, Object result) {
        print(vars);
        return 0;
    }

    private void print(List vars) {
        vars.stream().forEach( e -> System.out.print(e + ", "));
        System.out.println();
    }
}
