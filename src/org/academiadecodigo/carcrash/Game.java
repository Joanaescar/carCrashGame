package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /** Container of Cars */
    private Car[] cars;

    /** Animation delay */
    private int delay;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            //Check crashes
            checkCrashes();

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {
        for(Car car : cars){
            car.move();
        }
    }

    private void checkCrashes() {
        for(int i = 0; i < cars.length; i++){
            Car carTested = cars[i];

            for(int j = i + 1; j < cars.length; j++){
                Car otherCar = cars[j];

                if(carTested.collides(otherCar)){
                    carTested.setCrashed(true);
                    otherCar.setCrashed(true);
                }
            }

        }
    }

}
