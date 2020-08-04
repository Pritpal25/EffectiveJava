package chapter2.item2.builderPattern;

/*Builder Pattern : Use when there are 4 or more optional params with similar data types.

* Advantages
* a) Improved readability/writeability of client code.
* b) Avoids parameter swapping due to explicit parameter naming while setting them up.
* c) Does not MANDATE MUTABILITY - object cab be constructed with all the required parameters at once.
* (although at that point, it isn't much different than a constructor with all the req parameters).
*
* DISADVANTAGES
* a) Object construction requires construction of a builder first - can be performance impacting.
*
*/
public class Car {
    // Required
    private String name;
    private String make;

    // Optional
    private int year;
    private int license;
    private String color;

    public static class Builder {
        private String name;
        private String make;
        private int year;
        private int license;
        private String color;

        /*public Builder() {}
        */

        public Builder(String name, String make) {
            this.name = name;
            this.make = make;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder license(int license) {
            this.license = license;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    private Car(Builder builder) {
        this.make = builder.make;
        this.name = builder.name;
        this.color = builder.color;
        this.license = builder.license;
        this.year = builder.year;
    }

    public static void main(String[] args) {
        Car car = new Builder("Model Y", "Tesla").color("Grey").license(122334).year(2019).build();

        System.out.println(car.name + " " + car.make + " " + car.year + " " + car.license + " " + car.color);

    }
}
