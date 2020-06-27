package chapter2.item3.singletonFactoryMethod;

import java.io.*;

public class Tv implements Serializable {
    int i = 1;

    // Private field - no public access
    private static final Tv INSTANCE = new Tv();

    // Private constructor
    private Tv () {};

    // Public static method to get access to Tv INSTANCE.
    public static Tv getInstance() {
        return INSTANCE;
    }
    
    // This will ensure that even after serialization and deserialization, No new instance is created.
    // Comment this and run the main to see the difference.
    public Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        // This is a client code and would be outside of this class, so the below line wont work.
        // Since the constructor is private.
        // Tv tv = new Tv();

        Tv tv1 = Tv.getInstance();
        Tv tv2 = Tv.getInstance();

        // Check to show that there is a single instance.
        System.out.println(tv1.hashCode());
        System.out.println(tv2.hashCode());

        Tv tv3 = null;
        Tv tv4 = null;

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/Users/pbanga/Documents/factoryMethod.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tv1);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved");

            FileInputStream fileIn1 = new FileInputStream("/Users/pbanga/Documents/factoryMethod.ser");
            FileInputStream fileIn2 = new FileInputStream("/Users/pbanga/Documents/factoryMethod.ser");
            ObjectInputStream in1 = new ObjectInputStream(fileIn1);
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            tv3 = (Tv) in1.readObject();
            tv4 = (Tv) in2.readObject();
            System.out.println(tv3.hashCode() + " "+ tv3.i);
            tv3.i = 10;
            System.out.println(tv4.hashCode() + " "+ tv4.i);
            in1.close();
            in2.close();
            fileIn1.close();
            fileIn2.close();
        } catch(Exception i) {
            i.printStackTrace();
        }

    }
}
