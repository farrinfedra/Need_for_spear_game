package domain.physicalObjects;

public class Vector {
    private int x;
    private int y;

    public Vector(){
        this(0,0);
    }

    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public Vector setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Vector setY(int y) {
        this.y = y;
        return this;
    }

    public Vector shift(Vector shiftVector){
        Vector newVector = new Vector();

        newVector.setX(shiftVector.getX() + this.x);
        newVector.setY(shiftVector.getY() + this.y);

        return newVector;
    }
}
