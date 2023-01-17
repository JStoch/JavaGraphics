package programme.items;

import programme.Point;

import java.awt.*;

public abstract class Item {

    //TODO what should bounding box's classifier be? Public or protected? What about the fields?

    protected Point position;
    protected BoundingBox bBox;

    protected class BoundingBox {
        private Point topLeft, topRight, bottomLeft, bottomRight;

        public BoundingBox() {
            topLeft = new Point(0, 0);
            topRight = new Point(0, 0);
            bottomLeft = new Point(0, 0);
            bottomRight = new Point(0, 0);
        }
        public BoundingBox(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        public int top() {
            return topLeft.getY();
        }
        public int bottom() {
            return bottomLeft.getY();
        }
        public int right() {
            return topRight.getX();
        }
        public int left() {
            return topLeft.getX();
        }

        public void moveTop(int newTopBound) {
            topRight.setY(newTopBound);
            topLeft.setY(newTopBound);
        }

        public void moveBottom(int newBottomBound) {
            bottomLeft.setY(newBottomBound);
            bottomRight.setY(newBottomBound);
        }

        public void moveLeft(int newLeftBound) {
            topLeft.setX(newLeftBound);
            bottomLeft.setX(newLeftBound);
        }

        public void moveRight(int newRightBound) {
            topRight.setX(newRightBound);
            bottomRight.setX(newRightBound);
        }

        public Point getTopLeft() {
            return topLeft;
        }

        public Point getTopRight() {
            return topRight;
        }

        public Point getBottomLeft() {
            return bottomLeft;
        }

        public Point getBottomRight() {
            return bottomRight;
        }
    }
    public Item() {
        position = new Point(0,0);
        bBox = new BoundingBox();
    }
    public Item(Point position) {
        this.position = position;
        bBox = new BoundingBox(new Point(position.getX(), position.getY()), new Point(position.getX(), position.getY()), new Point(position.getX(), position.getY()), new Point(position.getX(), position.getY()));
    }

    public void translate(Point newPosition) {
        int xTrans = newPosition.getX() - position.getX();
        int yTrans = newPosition.getY() - position.getY();

        bBox.moveTop(bBox.top()+yTrans);
        bBox.moveBottom(bBox.bottom()+yTrans);
        bBox.moveRight(bBox.right()+xTrans);
        bBox.moveLeft(bBox.left()+xTrans);
        position = newPosition;

    }
    public BoundingBox getBoundingBox() {
        return bBox;
    };

    public int getBoundingTop() {
        return bBox.top();
    }

    public int getBoundingBottom() {
        return bBox.bottom();
    }

    public int getBoundingLeft() {
        return bBox.left();
    }

    public int getBoundingRight() {
        return bBox.right();
    }

    public abstract void draw(Graphics g);

    public void drawBounding(Graphics g) {
        g.drawRect(position.getX(), position.getY(), bBox.right()-bBox.left(), bBox.bottom()-bBox.top());
    }

    public Point getPosition() {
        return position;
    }
}
