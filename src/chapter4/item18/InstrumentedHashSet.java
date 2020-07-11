package chapter4.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    //public InstrumentedHashSet() {}

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> hashSet = new InstrumentedHashSet<>();

        // In the superclass, addAll, invoked the add method, which is overridden in this class,
        // hence the count gets doubled, one in addAll and then in each separate invocation of add.
        // AddAll invoking add is an internal detail that a subclass shouldn't rely on.
        hashSet.addAll(Arrays.asList("Kaku", "Deepa", "Gagan"));

        System.out.println(hashSet.getAddCount());
        System.out.println(hashSet.size());

        // Fix 1 : Remove override of addAll and run : Relies on the fact that internally addAll would invoke add.
        // Fix 2 : Override addAll to invoke add method in this class, this would lead to re-implementation and
        // lack of code reuse, thereby defeating the purpose.
    }
}
