package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

abstract  public class Car {

    /** The position of the car on the grid */
    private Position pos;
    private String description;

    private boolean crashed;

    private int speed;

    public Car(String description, int speed){
        pos = new Position();
        this.description = description;
        this.speed = speed;
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }

    public void move(){
        boolean validPosition = false;

        if(isCrashed()){
           return;
        }

        while(!validPosition){
            int possibleCol = 0;
            int possibleRow = 0;

            int randomMoveCol = (int) (Math.random() * 2);
            switch (randomMoveCol){
                case 0:
                    possibleCol = getPos().getCol() - 1 - speed;
                    break;
                case 1:
                    possibleCol = getPos().getCol() + 1 + speed;
                    break;
            }

            int randomMoveRow = (int) (Math.random() * 2);
            switch (randomMoveRow){
                case 0:
                    possibleRow = getPos().getRow() - 1 - speed;
                    break;
                case 1:
                    possibleRow = getPos().getRow() + 1 + speed;
                    break;
            }


            if((possibleCol < 0 || possibleCol >= Field.getWidth())
                    || (possibleRow < 0 || possibleRow >= Field.getHeight())
            ){
                validPosition = false;
            } else {
                validPosition = true;
                getPos().setRow(possibleRow);
                getPos().setCol(possibleCol);
            }

        }

    }

    public boolean collides(Car car){
        if(this.getPos().getCol() == car.getPos().getCol() && this.getPos().getRow() == car.getPos().getRow()){
            return true;
        }
        return false;
    }



    @Override
    public String toString(){
        if(!this.isCrashed()){
            return description;
        } else {
            return "C";
        }
    }


}
