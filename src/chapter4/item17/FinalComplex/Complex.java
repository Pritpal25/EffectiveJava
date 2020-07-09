package chapter4.item17.FinalComplex;

// Implementing immutability by using final class
// Made the class final - cant be extended
public final class Complex {
    // Fields are private and final - cannot be modified once object is constructed.
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // No mutators provided.
    public double getIm() {
        return im;
    }

    public double getRe() {
        return re;
    }

    // Functional Approach - returns result by applying a function to operand, without modifying it.
    // Vs a procedural/imperative approach - in which methods are applied to operands, causing state change.
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im -c.im);
    }

}
