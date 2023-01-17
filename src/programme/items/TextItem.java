package programme.items;

import programme.Point;

import java.awt.*;
import java.awt.font.FontRenderContext;

public class TextItem extends Item{

    private String text;
    private Font font;

    public TextItem() {
        super();
        text = "";
    }

    public TextItem(Point position, Font font, String text) {
        super(position);
        this.text = text;
        this.font = font;

        setBounding();
    }

    @Override
    public void draw(Graphics g) {
        g.setFont(font);
        g.drawString(text, position.getX(), position.getY()+g.getFont().getSize());
        bBox.moveRight(position.getX() + (int)font.getStringBounds(text, g.getFontMetrics().getFontRenderContext()).getWidth());
        //g.drawRect(bBox.left(), bBox.top(), bBox.right() - bBox.left(), bBox.bottom() - bBox.top());
    }

    private void setBounding() {
        int height = text.split("\n").length * font.getSize() + font.getSize()/3;
        int width = text.length() * font.getSize();

        bBox.moveBottom(bBox.bottom() + height);
        bBox.moveRight(bBox.right() + width);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
