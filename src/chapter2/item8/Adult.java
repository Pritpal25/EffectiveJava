package chapter2.item8;

public class Adult {
    public static void main(String[] args) {
        // Try with resources guarantees that the invocation of close method on an autocloseable object.
        try (Room room = new Room(7)){
            System.out.println("Goodbye");
        }
    }
}
