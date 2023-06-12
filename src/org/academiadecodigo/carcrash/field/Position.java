package org.academiadecodigo.carcrash.field;

public class Position {

    private int col;
    private int row;

    public Position(){
        col = (int) (Math.random() * Field.getWidth());
        row = (int) (Math.random() * Field.getHeight());
    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
