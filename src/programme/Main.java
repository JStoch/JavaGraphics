package programme;

import programme.items.ComplexItem;
import programme.items.TextItem;
import programme.items.primitive.Segment;
import programme.items.primitive.shapes.Circle;
import programme.items.primitive.shapes.Rectangle;
import programme.items.primitive.shapes.Star;
import programme.items.primitive.shapes.Triangle;
import programme.scene.NoSuchItem;
import programme.scene.Scene;
import programme.scene.SelectiveScene;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SelectiveScene scene = new SelectiveScene(new Scene());
        ComplexItem c = new ComplexItem();
        scene.addItem(new Star(new Point(80, 80), 70, 7, 5, false));
        scene.addItem(new Rectangle(new Point(100, 15), 40, 60, true));
        scene.addItem(new Circle(new Point(130, 130), 20, true));
        scene.addItem(new Triangle(new Point(50, 40), new Point(80, 45), new Point(50, 60), true));
        scene.addItem(new Segment(new Point(30, 80), new Point( 50, 140)));
        scene.addItem(new TextItem(new Point(10,10), new Font("Arial", Font.ITALIC, 25), "apsik!"));
        scene.addItem(c);
        scene.addItem(new TextItem(new Point(200, 180), new Font("Arial", Font.BOLD, 20), "tu przenieś"));
        //c.translate(new Point(200, 200));
        /*try {
            scene.selectItem(new Point(140, 140));
        } catch (NoSuchItem e) {
            System.out.println(e.getMessage());
        }
         */
        //scene.selectItem(2);
        scene.selectAllItems(new Point(140, 140));

        scene.draw();
    }
}