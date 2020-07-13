package chapter4.item22.constantClass;


import static chapter4.item22.constantClass.PhysicalConstant.RANDOM_NUMBER;

public class PhysicalConstantUsage {
    public static void main(String[] args) {
        // Use static imports to avoid qualifying the constant name with class name
        System.out.println(RANDOM_NUMBER);

        // Alternate usage - without static import
        System.out.println(PhysicalConstant.RANDOM_NUMBER);
    }
}
