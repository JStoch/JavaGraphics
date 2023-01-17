package programme.items.primitive.shapes;

import programme.Point;
import programme.items.primitive.Primitive;

public abstract class Shape extends Primitive {

    protected boolean isFilled;

    public Shape() {
        super();
        isFilled = false;
    }

    public Shape(Point position) {
        super(position);
        isFilled = false;
    }

    public Shape(Point position, boolean isFilled) {
        super(position);
        this.isFilled = isFilled;
    }

    //TODO
    public void changeColor() {

    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}
