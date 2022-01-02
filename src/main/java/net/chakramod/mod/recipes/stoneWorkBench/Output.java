package net.chakramod.mod.recipes.stoneWorkBench;

public class Output<X, Y> {
    private final X stack;
    private final Y nbt;

    public Output(X stack, Y nbt) {
        this.stack = stack;
        this.nbt = nbt;
    }

    public X getStack() {
        return stack;
    }

    public Y getNbt() {
        return nbt;
    }


}
