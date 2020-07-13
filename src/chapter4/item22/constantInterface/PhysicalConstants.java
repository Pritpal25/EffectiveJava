package chapter4.item22.constantInterface;

public interface PhysicalConstants {
    // Anti-pattern - don't use interfaces to export static constants.
    static final int RANDOM_NUMBER = 123_456_789;
}
