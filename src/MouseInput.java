import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private Handler handler;
    private Camera camera;

    public MouseInput(Handler handler, Camera camera) {
        this.handler = handler;
        this.camera = camera;
    }

    public void mousePressed(MouseEvent e) {
        int mx = (int) (e.getX() + camera.getX());
        int my = (int) (e.getY() + camera.getY());

        for (int i = 0; i< handler.object.size(); i++) {
            GameObject object = handler.object.get(i);

            if (object.getID() == ID.Player) {
                handler.addObject(new Bullet(object.getX() + 16, object.getY() + 24, ID.Bullet, handler, mx, my));
            }
        }
    }
}
