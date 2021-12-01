package domain.physicalobjects;

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

    public Vector add(Vector shiftVector){
        Vector newVector = new Vector();

        newVector.setX(shiftVector.getX() + this.x);
        newVector.setY(shiftVector.getY() + this.y);

        return newVector;
    }

    public Vector subtract(Vector shiftVector){
        Vector newVector = new Vector();

        newVector.setX(-shiftVector.getX() + this.x);
        newVector.setY(-shiftVector.getY() + this.y);

        return newVector;
    }

    public int distance(Vector v){
        return (int) Math.sqrt(
                Math.pow(this.x-v.getX(),2) +
                Math.pow(this.y-v.getY(),2)
        );
    }

    public Vector scale(int c){
        return new Vector(this.x *c , this.y*c);
    }

    public int cross(Vector v){
        return this.x*v.getY()-this.y*v.getX();
    }

    public Vector rotate(double rad){
        double sin = Math.sin(rad);
        double cos = Math.cos(rad);

        return new Vector((int) (this.x * cos  - this.y * sin),
                (int) (this.x * sin + this.y * cos));

    }

    public String toString(){
        return "<<Vector: (" + x + ", " + y +")>>";
    }
}
