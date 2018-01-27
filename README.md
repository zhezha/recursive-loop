# recursive-loop

Sometimes multiple layers of loop is necessary but looks awkward, for example:

```
for (int x1 : list1) {
    for (int x2 : list2) {
        ...
        for (int xn : listn) {
            doSomething(x1, x2, ..., xn);
        }
        ...
    }
}
```

With recursive-loop, the above loop can be writen like this:

```
new RecursiveLoop(loops) {
    public int handle(int[] vars, int result) {
        doSomething(vars);
        return 0;
    }
}.loop();
```

or like this if return value is needed:

```
new RecursiveLoop(loops) {
    public int handle(int[] vars, int result) {
        return doSomething(vars, result);
    }
}.loop()
 .getResult();
```

where `loops` is a list consists of `list1, list2, ..., listn`.