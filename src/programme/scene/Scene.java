package programme.scene;

import programme.items.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends Canvas {
    protected ArrayList<Item> items;

    public Scene() {
        super();
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void draw() {
        JFrame frame = drawFrameSetup();
        frame.add(this);
    }

    protected JFrame drawFrameSetup() {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }

    @Override
    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        //setForeground(Color.RED);

        for (Item item: items) {
            item.draw(g);
        }
    }
}
