package programme.items.primitive.shapes;

import programme.Point;

import java.awt.*;

public class Triangle extends Shape {

    private Point p1, p2, p3;

    public Triangle() {
        super();
        p1 = new Point(0, 0);
        p2 = new Point(0, 0);
        p3 = new Point(0, 0);
    }

    public Triangle(Point p1, Point p2, Point p3) {
        super();
        if(areNotCollinear(p1, p2, p3)) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;

            setPositionAndBounding();
        } else {
            this.p1 = new Point(0, 0);
            this.p2 = new Point(0, 0);
            this.p3 = new Point(0, 0);
        }
    }

    public Triangle(Point p1, Point p2, Point p3, boolean isFilled) {
        super();
        if(areNotCollinear(p1, p2, p3)) {
            this.isFilled = isFilled;
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;

            setPositionAndBounding();
        } else {
            this.p1 = new Point(0, 0);
            this.p2 = new Point(0, 0);
            this.p3 = new Point(0, 0);
        }
    }

    @Override
    public void draw(Graphics g) {
        if(isFilled) {
            g.fillPolygon(new int[] {p1.getX(), p2.getX(), p3.getX()}, new int[] {p1.getY(), p2.getY(), p3.getY()}, 3);
        } else {
            g.drawPolygon(new int[] {p1.getX(), p2.getX(), p3.getX()}, new int[] {p1.getY(), p2.getY(), p3.getY()}, 3);
        }
        //g.drawRect(bBox.left(), bBox.top(), bBox.right() - bBox.left(), bBox.bottom() - bBox.top());
    }

    @Override
    public void translate(Point newPosition) {
        int xTrans = newPosition.getX() - position.getX();
        int yTrans = newPosition.getY() - position.getY();

        super.translate(newPosition);
        p1.setX(p1.getX()+xTrans);
        p1.setY(p1.getY()+yTrans);
        p2.setX(p2.getX()+xTrans);
        p2.setY(p2.getY()+yTrans);
        p3.setX(p3.getX()+xTrans);
        p3.setY(p3.getY()+yTrans);
    }

    private void setPositionAndBounding() {
        bBox.moveBottom(Math.max(p1.getY(), Math.max(p2.getY(), p3.getY())));
        bBox.moveTop(Math.min(p1.getY(), Math.min(p2.getY(), p3.getY())));
        bBox.moveLeft(Math.min(p1.getX(), Math.min(p2.getX(), p3.getX())));
        bBox.moveRight(Math.max(p1.getX(), Math.max(p2.getX(), p3.getX())));
        position = new Point(bBox.left(), bBox.top());
    }

    private boolean areNotCollinear(Point p1, Point p2, Point p3) {
        int eqLeft = (p1.getY()-p2.getY())*(p3.getX()-p2.getX());
        int eqRight =(p3.getY()-p2.getY())*(p1.getX()-p2.getX());
        return !(eqLeft == eqRight);
    }
}
