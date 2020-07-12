package chapter4.item19;

// This class is BROKEN.
// Super class constructor is invoking the the overridable method, which tries to access the state of subclass
// that potentially hasnt been initialized yet.
public class Super {
    public Super() {
        overrideMe();
    }
    public void overrideMe() {}
}
