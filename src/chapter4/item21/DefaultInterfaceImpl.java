package chapter4.item21;

public class DefaultInterfaceImpl implements DefaultInterface{
    @Override
    public void oldMethod() {
        System.out.println("This is an old method in the interface");
    }

    public static void main(String[] args) {
        DefaultInterfaceImpl impl = new DefaultInterfaceImpl();
        impl.oldMethod();

        // Uncomment the new method added to the interface and then run this.
        // impl.newMethod();
    }
}
