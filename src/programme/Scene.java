package programme;

import programme.items.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends Canvas {
    ArrayList<Item> items;

    public Scene() {
        super();
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void draw() {
        JFrame frame = new JFrame();
        frame.add(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
