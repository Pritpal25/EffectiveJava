package chapter2.item2.builderPattern;

public class TestCar {
    public static void main(String[] args) {
        Car car = new Car.Builder("Model Y", "Tesla").color("Grey").license(122334).year(2019).build();

        System.out.println(car.getName());

    }
}
