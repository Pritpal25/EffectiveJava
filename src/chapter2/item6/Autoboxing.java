package chapter2.item6;

public class Autoboxing {
    private static Long slowSum(int reps) {
        Long sum = 0L;

        for(int i = 0; i < reps; i++) {
            for (long l = 0; l < Integer.MAX_VALUE; l++) {
                sum += l;
            }
        }

        return sum;
    }

    private static long fastSum(int reps) {
        long sum = 0L;

        for(int i = 0; i < reps; i++) {
            for (long l = 0; l < Integer.MAX_VALUE; l++) {
                sum += l;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int reps = Integer.parseInt(args[0]);

        long start = System.nanoTime();
        long sum = fastSum(reps);
        long end = System.nanoTime();

        System.out.println((end-start)/(1_000_000. * reps) + " milli secs");

        if(sum == 42) {
            System.out.println();
        }

        start = System.nanoTime();
        sum = slowSum(reps);
        end = System.nanoTime();

        System.out.println((end-start)/(1_000_000. * reps) + " milli secs");

        if(sum == 42) {
            System.out.println();
        }
    }
}

/*
Running this got a 10 times performance enhancement from primitive types.
589.5782035 micro secs
5353.3895035 micro secs
 */