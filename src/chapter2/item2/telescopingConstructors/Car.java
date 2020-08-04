package chapter2.item2.telescopingConstructors;

/*Disadvantages
* a) Requires multiple constructors, one with each optional parameter.
* b) On the client side code, issues can happen if the same type parameters get swapped.
* No compile time issues, but issues at run time.*/

public class Car {
    // Required
    private final String name;
    private final String make;

    // Optional
    private int year;
    private int license;
    private String color;

    public Car(String name, String make) {
        this.name = name;
        this.make = make;
    }

    public Car(String name, String make, int year) {
        this.name = name;
        this.make = make;
        this.year = year;
    }

    public Car(String name, String make, int year, int license) {
        this.name = name;
        this.make = make;
        this.year = year;
        this.license = license;
    }

    public Car(String name, String make, int year, int license, String color) {
        this.name = name;
        this.make = make;
        this.year = year;
        this.license = license;
        this.color = color;
    }

    public static void main(String[] agrs) {

        Car car = new Car("Model Y", "Tesla", 2019, 0, "Grey");

        System.out.println(car.name + " " + car.make + " " + car.year + " " + car.license + " " + car.color);

        // Builds fine, but incorrectly replaces make with the name of the car.
        car = new Car("Tesla", "Model Y", 2019, 0, "Grey");

        System.out.println(car.name + " " + car.make + " " + car.year + " " + car.license + " " + car.color);
    }
}
