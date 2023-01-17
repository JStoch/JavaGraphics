package programme.items.primitive;

import programme.Point;

import java.awt.*;

public class Segment extends Primitive {

    private Point start, end;

    public Segment() {
        super();
        start = new Point(0, 0);
        end = new Point(0,0);
    }

    public Segment(Point start, Point end) {
        super();
        this.start = start;
        this.end = end;
        setPositionAndBounding();
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
        //g.drawRect(bBox.left(), bBox.top(), bBox.right() - bBox.left(), bBox.bottom() - bBox.top());
    }

    @Override
    public void translate(Point newPosition) {
        int xTrans = newPosition.getX() - position.getX();
        int yTrans = newPosition.getY() - position.getY();

        super.translate(newPosition);
        start.setX(start.getX()+xTrans);
        start.setY(start.getY()+yTrans);
        end.setX(end.getX()+xTrans);
        end.setY(end.getY()+yTrans);
    }

    private void setPositionAndBounding() {
        bBox.moveLeft(Math.min(start.getX(), end.getX()));
        bBox.moveRight(Math.max(start.getX(), end.getX()));
        bBox.moveTop(Math.min(start.getY(), end.getY()));
        bBox.moveBottom(Math.max(start.getY(), end.getY()));
        position = new Point(bBox.left(), bBox.top());
    }

    public double getLength() {
        return Math.sqrt(Math.pow(start.getX()-end.getX(), 2)+Math.pow(start.getY()-end.getY(), 2));
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}
