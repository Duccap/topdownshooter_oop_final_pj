import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject {

    Handler handler;

    public Wizard(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        //TODO Auto-generated constructor stub
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        x += velX;
        y += velY;

        if (handler.getUp()) velY -= 5;
        else if (!handler.getDown()) velY = 0;

        if (handler.getDown()) velY += 5;
        else if (!handler.getUp()) velY = 0;

        if (handler.getLeft()) velX -= 5;
        else if (!handler.getUp()) velX = 0;

        if (handler.getRight()) velX += 5;
        else if (!handler.getLeft()) velX = 0;
    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 48);
    }

    @Override
    public Rectangle getBounds() {
        // TODO Auto-generated method stub
        return new Rectangle (32, 48);
    }

}
