package programme.items;

import programme.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ComplexItem extends Item{
    private ArrayList<Item> children;

    public ComplexItem() {
        super();
        children = new ArrayList<>();
    }

    public ComplexItem(Point position) {
        super(position);
        children = new ArrayList<>();
    }

    public void addChild(Item child) {
        children.add(child);
        if(children.size() == 1) {
            bBox = new BoundingBox(new Point(child.bBox.left(), child.bBox.top()), new Point(child.bBox.right(),child.bBox.top()),
                    new Point(child.bBox.right(), child.bBox.bottom()), new Point(child.bBox.left(),child.bBox.bottom()));
            position = child.getPosition();
        } else fixPositionAndBounding(child);
    }

    @Override
    public void draw(Graphics g) {
        for (Item child : children) {
            child.draw(g);
        }
    }

    @Override
    public void translate(Point newPosition) {
        int xTrans = newPosition.getX() - position.getX();
        int yTrans = newPosition.getY() - position.getY();

        for (int i = 0; i < children.size(); i++) {
            children.get(i).translate(new Point(children.get(i).position.getX()+xTrans, children.get(i).position.getY()+yTrans));
        }

        super.translate(newPosition);
    }

    private void fixPositionAndBounding(Item newChild) {
        if (newChild.getBoundingBox().left() < bBox.left()) {
            position.setX(newChild.getBoundingBox().left());
            bBox.moveLeft(newChild.getBoundingBox().left());
        }

        if (newChild.getBoundingBox().right() > bBox.right()) {
            bBox.moveRight(newChild.getBoundingBox().right());
        }

        if (newChild.getBoundingBox().top() < bBox.top()) {
            position.setY(newChild.getBoundingBox().top());
            bBox.moveTop(newChild.getBoundingBox().top());
        }

        if (newChild.getBoundingBox().bottom() > bBox.bottom()) {
            bBox.moveBottom(newChild.getBoundingBox().bottom());
        }
    }
}
