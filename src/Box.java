import java.awt.Color;
import java.awt.Rectangle;
import java.text.RuleBasedCollator;
import java.awt.Graphics;

public class Box extends GameObject {

    public Box(int x, int y, ID id, SpriteSheet ss) {
        super(x, y, id,ss);
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        // TODO Auto-generated method stub
        return null;
    }

}
