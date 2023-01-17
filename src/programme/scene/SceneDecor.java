package programme.scene;

import programme.items.Item;

import javax.swing.*;
import java.awt.*;

public abstract class SceneDecor extends Scene {
    protected Scene subject;

    public SceneDecor(Scene subject) {
        this.subject = subject;
    }

    public void addItem(Item item) {
        subject.addItem(item);
    }

    public void draw() {
        subject.draw();
    }

    @Override
    public void paint(Graphics g) {
        subject.paint(g);
    }
}
