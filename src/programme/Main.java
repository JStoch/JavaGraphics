package programme;

import programme.items.*;
import programme.items.primitive.Segment;
import programme.items.primitive.shapes.Rectangle;
import programme.scene.NoSuchItem;
import programme.scene.*;
import programme.items.primitive.shapes.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SelectiveScene scene = new SelectiveScene(new Scene());
        ComplexItem c = new ComplexItem();
        c.addChild(new Star(new Point(230, 150), 50, 15, 4, false));
        c.addChild(new Triangle(new Point(300, 300), new Point(350, 400), new Point(320, 400)));
        scene.addItem(c);
        scene.addItem(new Star(new Point(80, 80), 70, 7, 5, false));
        scene.addItem(new Rectangle(new Point(100, 15), 40, 60, true));
        scene.addItem(new Circle(new Point(130, 130), 20, true));
        scene.addItem(new Triangle(new Point(50, 40), new Point(80, 45), new Point(50, 60), true));
        scene.addItem(new Segment(new Point(30, 80), new Point( 50, 140)));
        try {
            scene.selectItem(new Point(80, 80));
        } catch (NoSuchItem e) {
            System.out.println(e.getMessage());
        }




        //scene.selectItem(0);
        scene.selectAllItems();
        scene.draw();
    }
}