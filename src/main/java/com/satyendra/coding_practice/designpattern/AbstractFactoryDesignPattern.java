package designpattern;

interface Car {
    void showCar();
}

interface CarSpecification {
    void showCarSpecification();
}

class Sedan implements Car {

    @Override
    public void showCar() {
        System.out.println("This is Sedan car");
    }
}

class Hatchback implements Car {

    @Override
    public void showCar() {
        System.out.println("This is Hatchback car");
    }
}

class NorthernAmericaCarSpecification implements CarSpecification {

    @Override
    public void showCarSpecification() {
        System.out.println("This is northern america car specification");
    }
}

class EuropeanCarSpecification implements CarSpecification {

    @Override
    public void showCarSpecification() {
        System.out.println("This is european car specification");
    }
}

class AsianCarSpecification implements CarSpecification {

    @Override
    public void showCarSpecification() {
        System.out.println("This is Asian car specification");
    }
}


interface CarFactory {
    Car createCar();
    CarSpecification createCarSpecification();
}

class NorthernAmericaCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Sedan();
    }

    @Override
    public CarSpecification createCarSpecification() {
        return new NorthernAmericaCarSpecification();
    }
}

class EuropeanCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Hatchback();
    }

    @Override
    public CarSpecification createCarSpecification() {
        return new EuropeanCarSpecification();
    }
}

class AsianCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Sedan();
    }

    @Override
    public CarSpecification createCarSpecification() {
        return new AsianCarSpecification();
    }
}

public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        CarFactory northernCarFactory = new NorthernAmericaCarFactory();
        northernCarFactory.createCar().showCar();
        northernCarFactory.createCarSpecification().showCarSpecification();

        CarFactory EuropeanCarFactory = new EuropeanCarFactory();
        EuropeanCarFactory.createCar().showCar();
        EuropeanCarFactory.createCarSpecification().showCarSpecification();

        CarFactory asianCarFactory = new AsianCarFactory();
        asianCarFactory.createCar().showCar();
        asianCarFactory.createCarSpecification().showCarSpecification();
    }
}
