package chapter2.item6;

import java.util.regex.Pattern;

public class RomanNumerals {
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // Precompiled cached(static) variable for reuse.
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        int numReps = Integer.parseInt(args[1]);
        boolean b = false;
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                b ^= isRomanNumeralSlow("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
        }

        // Since this is the only real usage of b, the compiler will make sure to keep updating b in statement 27
        // Otherwise, an over eager compiler could just not update the value, since its never getting used elsewhere.
        if (!b)
            System.out.println();
    }
}