package org.academiadecodigo.carcrash.cars;

public class CarFactory {

    public static  Car getNewCar() {
        TypeCars[] carsType = TypeCars.values();
        int length = carsType.length;
        int randomCar = (int) (Math.random() * length);
        TypeCars cars = carsType[randomCar];

        Car typeCar = null;

        switch (cars) {
            case FIAT:
                typeCar = new Fiat();
                break;
            case MUSTANG:
                typeCar = new Mustang();
                break;
            default:
                break;
        }


        return typeCar;
    }
}
