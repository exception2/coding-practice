package designpattern;

abstract class Vehicle {
    public abstract void printVehicle();
}

class TwoWheelerVehicle extends Vehicle {

    @Override
    public void printVehicle() {
        System.out.println("Two vehicle instance created!");
    }
}

class ThreeWheelerVehicle extends Vehicle {

    @Override
    public void printVehicle() {
        System.out.println("Three vehicle instance created!");
    }
}

interface VehicleFactory {
    Vehicle createVehicle();
}

class TwoWheelerVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new TwoWheelerVehicle();
    }
}

class ThreeWheelerVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new ThreeWheelerVehicle();
    }
}

class Client {
    private Vehicle vehicle;

    public Client(VehicleFactory vehicleFactory) {
        vehicle = vehicleFactory.createVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
public class FactoryDesignPattern {
    public static void main(String[] args) {
        TwoWheelerVehicleFactory twoWheelerVehicleFactory = new TwoWheelerVehicleFactory();
        Client twoWheelerClient = new Client(twoWheelerVehicleFactory);
        twoWheelerClient.getVehicle().printVehicle();

        ThreeWheelerVehicleFactory threeWheelerVehicleFactory = new ThreeWheelerVehicleFactory();
        Client threeWheelerClient = new Client(threeWheelerVehicleFactory);
        threeWheelerClient.getVehicle().printVehicle();
    }
}
