package chapter4.item17.StaticFactoryComplex;

//  Non Final Complex class
public class Complex {
    private final double im;
    private final double re;

    // Make constructor private
    private Complex(double im, double re) {
        this.im = im;
        this.re = re;
    }

    // Provide a public static factory.
    public static Complex valueOf(double im, double re) {
        return new Complex(im, re);
    }
}
