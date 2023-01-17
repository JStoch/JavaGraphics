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
        /*DECORATOR TESTS
        SelectiveScene scene = new SelectiveScene(new Scene());
        ComplexItem c = new ComplexItem();
        scene.addItem(new Star(new Point(80, 80), 70, 7, 5, false));
        scene.addItem(new Rectangle(new Point(100, 15), 40, 60, true));
        scene.addItem(new Circle(new Point(130, 130), 20, true));
        scene.addItem(new Triangle(new Point(50, 40), new Point(80, 45), new Point(50, 60), true));
        scene.addItem(new Segment(new Point(30, 80), new Point( 50, 140)));
        scene.addItem(new TextItem(new Point(10,10), new Font("Arial", Font.ITALIC, 25), "apsik!"));
        try {
            scene.selectItem(new Point(140, 140));
        } catch (NoSuchItem e) {
            System.out.println(e.getMessage());
        }

        //scene.selectItem(2);
        //scene.selectAllItems(new Point(140, 140));
        scene.draw();
        */

        /*SINGLETON TESTS
        Scene scene = new Scene();
        scene.addItem(SingletonTriangle.getInstance(new Point(50, 40), new Point(80, 45), new Point(50, 60), true));
        scene.addItem(SingletonTriangle.getInstance(new Point(150, 140), new Point(180, 145), new Point(150, 160), true));
        scene.draw();
        */
    }
}