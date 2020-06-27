package chapter2.item3.singletonEnumMethod;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// In this method, there is no need to add readResolve method for serialization support.
// Works out of the box.

public class TvEnumDemo {
    public enum Tv {
        INSTANCE("MyTv");

        String label;

        Tv(String label) {
            this.label = label;
        }
    }

    // This is a client code and would be outside of this class.
    public static void main(String[] args) {
        Tv tv1 = Tv.INSTANCE;
        Tv tv2 = Tv.INSTANCE;

        // Check to show that there is a single instance.
        System.out.println(tv1.hashCode() + " " + tv1.label);
        System.out.println(tv2.hashCode() + " " + tv1.label);

        Tv tv3 = null;
        Tv tv4 = null;

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/Users/pbanga/Documents/enumMethod.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tv1);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved");

            FileInputStream fileIn1 = new FileInputStream("/Users/pbanga/Documents/enumMethod.ser");
            FileInputStream fileIn2 = new FileInputStream("/Users/pbanga/Documents/enumMethod.ser");
            ObjectInputStream in1 = new ObjectInputStream(fileIn1);
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            tv3 = (Tv) in1.readObject();
            tv4 = (Tv) in2.readObject();
            System.out.println(tv3.hashCode() + " " + tv3.label);
            tv3.label = "YourTv";
            System.out.println(tv4.hashCode() + " " + tv4.label);
            in1.close();
            in2.close();
            fileIn1.close();
            fileIn2.close();
        } catch(Exception i) {
            i.printStackTrace();
        }        
    }
}
