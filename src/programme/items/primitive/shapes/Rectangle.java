package programme.items.primitive.shapes;

import programme.Point;

import java.awt.*;

public class Rectangle extends Shape {

    private int width, height;

    public Rectangle() {
        super();
        width = 0;
        height = 0;
    }

    public Rectangle(Point position, int width, int height) {
        super(position);
        this.width = width;
        this.height = height;

        setBounding();
    }

    public Rectangle(Point position, int width, int height, boolean isFilled) {
        super(position, isFilled);
        this.width = width;
        this.height = height;

        setBounding();
    }

    @Override
    public void draw(Graphics g) {
        if(isFilled()) {
            g.fillRect(position.getX(), position.getY(), width, height);
        } else {
            g.drawRect(position.getX(), position.getY(), width, height);
        }
    }

    private void setBounding() {
        bBox.moveRight(position.getX()+width);
        bBox.moveBottom(position.getY()+height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
