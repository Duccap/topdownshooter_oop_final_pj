import java.awt.*;

public class Wizard extends GameObject {
    Handler handler;

    public Wizard(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (handler.getUp()) velY = -5;
        else if (!handler.getDown()) velY = 0;

        if (handler.getDown()) velY = 5;
        else if (!handler.getUp()) velY = 0;

        if (handler.getLeft()) velX = -5;
        else if (!handler.getRight()) velX = 0;

        if (handler.getRight()) velX = 5;
        else if (!handler.getLeft()) velX = 0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,32,48);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,48);
    }
}
