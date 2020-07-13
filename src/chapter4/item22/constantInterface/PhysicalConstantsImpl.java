package chapter4.item22.constantInterface;

// Anti-pattern - don't use interfaces to export static constants.
// Requires implementing an interface to export the constant here.
public class PhysicalConstantsImpl implements PhysicalConstants {
    public static void main(String[] args) {
        System.out.println(RANDOM_NUMBER);
    }
}
