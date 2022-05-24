import java.awt.*;

public class Wizard extends GameObject {
    Handler handler;
    Game game;
    public Wizard(int x, int y, ID id, Handler handler,Game game, SpriteSheet ss) {
        super(x, y, id,ss);
        this.handler = handler;
        this.game=game;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        collision();

        if (handler.getUp()) velY = -5;
        else if (!handler.getDown()) velY = 0;

        if (handler.getDown()) velY = 5;
        else if (!handler.getUp()) velY = 0;

        if (handler.getLeft()) velX = -5;
        else if (!handler.getRight()) velX = 0;

        if (handler.getRight()) velX = 5;
        else if (!handler.getLeft()) velX = 0;
    }
    private void collision(){
        for ( int i=0; i<handler.object.size();i++){
            GameObject temp= handler.object.get(i);
            if (temp.getID()== ID.Block){
                if (getBounds().intersects(temp.getBounds())){
                    x+=velX*-1;
                    y+=velY*-1;
                }
            }
            if (temp.getID()== ID.Crate){
                if (getBounds().intersects(temp.getBounds())){
                    game.ammo+=10;
                    handler.removeObject(temp);
                }
            }
        }
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
