package programme.items.primitive.shapes;

import programme.Point;

import java.awt.*;
import java.util.ArrayList;

public class Star extends Shape {

    private ArrayList<Point> points;
    private int density;
    private int radius;

    public Star() {
        super();
        points = new ArrayList<>();
        density = 0;
        radius = 0;
    }

    public Star(Point position, int radius, int nOfPoints, int density) {
        super(position);
        points = new ArrayList<>();
        if (areRelativelyPrime(nOfPoints, density)) {
            this.density = density;
            this.radius = radius;
            calculatePoints(radius, nOfPoints);
            setBounding();
        } else {
            points.add(position);
            this.density = 0;
            this.radius = 0;
        }
    }

    public Star(Point position, int radius, int nOfPoints, int density, boolean isFilled) {
        super(position, isFilled);
        points = new ArrayList<>();
        if (areRelativelyPrime(nOfPoints, density)) {
            this.density = density;
            this.radius = radius;
            calculatePoints(radius, nOfPoints);
            setBounding();
        } else {
            points.add(position);
            this.density = 0;
            this.radius = 0;
        }
    }

    @Override
    public void draw(Graphics g) {
        int[] x = new int[points.size()];
        int[] y = new int[points.size()];

        int k = 0;
        for(int i = 0; i < points.size(); i++) {
            k = (k + density) % points.size();
            x[i] = points.get(k).getX();
            y[i] = points.get(k).getY();
        }

        if(isFilled) {
            g.fillPolygon(x, y, points.size());
        } else {
            g.drawPolygon(x, y, points.size());
        }
        //g.drawRect(bBox.left(), bBox.top(), bBox.right() - bBox.left(), bBox.bottom() - bBox.top());

    }

    @Override
    public void translate(Point newPosition) {
        int xTrans = newPosition.getX() - position.getX();
        int yTrans = newPosition.getY() - position.getY();

        for(int i = 0; i < points.size(); i++) {
            points.get(i).setX(points.get(i).getX()+xTrans);
            points.get(i).setY(points.get(i).getY()+yTrans);
        }

        super.translate(newPosition);
    }

    private void setBounding() {
        bBox.moveRight(bBox.right()+2*radius);
        bBox.moveBottom(bBox.bottom()+2*radius);
    }

    private boolean areRelativelyPrime(int a, int b) {
        return greatestCommonDivider(a, b) == 1;
    }

    private int greatestCommonDivider(int a, int b) {
        if (b == 0) return a;
        return greatestCommonDivider(b, a % b);
    }

    private void calculatePoints(int radius, int nOfPoints) {
        double angle = 2*Math.PI / nOfPoints;
        int prevX = radius;
        int prevY = 0;

        for(int i = 0; i < nOfPoints; i++) {
            points.add(new Point(position.getX()+radius+prevX, position.getY()+radius+prevY));
            int newX = (int) Math.round(prevX*Math.cos(angle)-prevY*Math.sin(angle));
            int newY = (int) Math.round(prevY*Math.cos(angle)+prevX*Math.sin(angle));
            prevX = newX;
            prevY = newY;
        }
    }


}
