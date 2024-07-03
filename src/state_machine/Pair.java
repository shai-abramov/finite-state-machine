package state_machine;

public class Pair<T, S> {
    private final T t;
    private final S s;
    public Pair(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public T getT() { return t; }

    public S getS() { return s; }

    // todo: consider implement
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }

        return this.t == ((Pair)obj).t && this.s == ((Pair)obj).s;
    }

    // todo: consider implement
    @Override
    public int hashCode() {
        return this.t.hashCode() + this.s.hashCode(); // todo: this is very naive and should be chaged
    }

    // todo: consider implement
    @Override
    public String toString() {
        return super.toString();
    }
}
