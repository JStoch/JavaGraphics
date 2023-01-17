package programme;

import programme.items.ComplexItem;
import programme.items.TextItem;
import programme.items.primitive.Segment;
import programme.items.primitive.shapes.*;
import programme.items.primitive.shapes.Rectangle;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Scene scene = new Scene();
        /*ComplexItem c = new ComplexItem();
        c.addChild(new Star(new Point(80, 80), 70, 7, 5, false));
        c.addChild(new Rectangle(new Point(100, 15), 40, 60, true));
        c.addChild(new Circle(new Point(130, 130), 20, true));
        c.addChild(new Triangle(new Point(50, 40), new Point(80, 45), new Point(50, 60), true));
        c.addChild(new Segment(new Point(30, 80), new Point( 50, 140)));
        c.addChild(new TextItem(new Point(10,10), new Font("Arial", Font.ITALIC, 25), "apsik!"));
        scene.addItem(c);
        //c.translate(new Point(200, 200));
        scene.addItem(new TextItem(new Point(200, 180), new Font("Arial", Font.BOLD, 20), "tu przenieś"));

        */
        scene.addItem(SingletonTriangle.getInstance(new Point(50, 40), new Point(80, 45), new Point(50, 60), true));
        scene.addItem(SingletonTriangle.getInstance(new Point(150, 140), new Point(180, 145), new Point(150, 160), true));

        scene.draw();
    }
}