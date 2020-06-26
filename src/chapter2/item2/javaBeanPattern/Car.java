package chapter2.item2.javaBeanPattern;

/*
* Java Bean Pattern : Construct an empty object and then set members using setters.
* Advantages :
* a) Avoids the problems with telescoping by improved client code readability.
* b) No need for multiple constructors with optional parameters.
*
* Disadvantages
* a) MANDATES MUTABILITY : class cannot be immutable, though one can "freeze the object after construction", rarely used.
* b) Object could be used in half cooked state, since object construction is split across multiple calls.*/

public class Car {
    // Required - no default values set
    private String name;
    private String make;

    // Optional - can have default values set
    private int year;
    private int license;
    private String color;

    public Car() {
    }

    // Setters to set the values of members on the default contructed object.

    public void setName(String name) {
        this.name = name;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] agrs) {
        // Requires the object be mutable.
        Car car = new Car();
        car.setName("Model Y");
        car.setMake("Tesla");
        car.setYear(2019);
        car.setColor("Grey");

        System.out.println(car.name + " " + car.make + " " + car.year + " " + car.license + " " + car.color);


        Car car1 = new Car();
        car1.setName("Model Y");
        // Object gets used in half cooked state.
        System.out.println(car1.name + " " + car1.make + " " + car1.year + " " + car1.license + " " + car1.color);

        car1.setMake("Tesla");
        car1.setYear(2019);
        car1.setColor("Grey");
    }
}
