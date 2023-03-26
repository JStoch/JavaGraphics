package programme.scene;

import programme.Point;
import programme.items.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SelectiveScene extends SceneDecor {

    private ArrayList<Item> selected;

    @Override
    public void paint(Graphics g){
        for(Item item: selected) {
            item.drawBounding(g);
        }

        subject.paint(g);
    }

    @Override
    public void draw() {
        Frame frame = subject.drawFrameSetup();
        frame.add(this);
    }

    public SelectiveScene(Scene subject) {
        super(subject);
        selected = new ArrayList();
    }

    //returns an item given its index in the scene
    public Item getItem(int index) {
        return subject.items.get(index);
    }

    //return the first item found at given location
    public Item getItem(Point inBoundsOfItem) throws NoSuchItem {
        for(int i = 0; i < subject.items.size(); i++) {
            if(isInBounds(inBoundsOfItem, subject.items.get(i))) {
                return subject.items.get(i);
            }
        }
        throw new NoSuchItem("There is no item in the scene at this coordinates");
    }

    //returns an array with all items at specified location
    public ArrayList<Item> getAllItems(Point inBoundsOfItem) {
        ArrayList<Item> foundItems = new ArrayList();
        for(int i = 0; i < subject.items.size(); i++) {
            if(isInBounds(inBoundsOfItem, subject.items.get(i))) {
                foundItems.add(subject.items.get(i));
            }
        }
        return foundItems;
    }

    //selects an item, given its index in the scene
    public void selectItem(int index) {
         selected.add(subject.items.get(index));
    }

    //selects the first found item at specified location
    public void selectItem(Point inBoundsOfItem) throws NoSuchItem {
        int i = 0;
        boolean found = false;
        while(i < subject.items.size() && !found) {
            if(isInBounds(inBoundsOfItem, subject.items.get(i))) {
                selected.add(subject.items.get(i));
                found = true;
            }
            i++;
        }
        if (!found) throw new NoSuchItem("There is no item in the scene at this coordinates");
    }

    //selects all items at specified location
    public void selectAllItems(Point inBoundsOfItem) {
        for(int i = 0; i < subject.items.size(); i++) {
            if(isInBounds(inBoundsOfItem, subject.items.get(i))) {
                selected.add(subject.items.get(i));
            }
        }
    }

    //selects all items present in the scene
    public void selectAllItems() {
        for(int i = 0; i < subject.items.size(); i++) {
            selected.add(subject.items.get(i));
        }
    }

    private boolean isInBounds(Point inside, Item toCheck) {
        return inside.getY() >= toCheck.getBoundingTop() &&
                inside.getY() <= toCheck.getBoundingBottom() &&
                inside.getX() >= toCheck.getBoundingLeft() &&
                inside.getX() <= toCheck.getBoundingRight();
    }
}
