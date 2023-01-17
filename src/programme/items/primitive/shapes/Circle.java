package programme.items.primitive.shapes;

import programme.Point;

import java.awt.*;

public class Circle extends Shape{

    private int radius;

    public Circle() {
        super();
        radius = 0;
    }

    public Circle(Point position, int radius) {
        super(position);
        this.radius = radius;
        setBounding();
    }

    public Circle(Point position, int radius, boolean isFilled) {
        super(position, isFilled);
        this.radius = radius;
        setBounding();
    }
    @Override
    public void draw(Graphics g) {
        if(isFilled()) {
            g.fillOval(position.getX(), position.getY(), 2*radius, 2*radius);
        } else {
            g.drawOval(position.getX(), position.getY(), 2*radius, 2*radius);
            //g.drawRect(bBox.left(), bBox.top(), bBox.right() - bBox.left(), bBox.bottom() - bBox.top());
        }
    }

    private void setBounding() {
        bBox.moveBottom(position.getY()+2*radius);
        bBox.moveRight(position.getX()+2*radius);
    }

    public int getRadius() {
        return radius;
    }
}
