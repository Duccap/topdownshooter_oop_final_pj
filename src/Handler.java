import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();
    private boolean up = false, down = false, right = false, left = false;

    public void tick(){
        for(int i=0;i<object.size();i++){
            GameObject tempObject= object.get(i);

            tempObject.tick();
        }
    }

    public  void render(Graphics g){
        for(int i=0;i<object.size();i++){
            GameObject tempObject= object.get(i);

            tempObject.render(g);
        }
    }
    public void addObject(GameObject tempObject ){
        object.add(tempObject);
    }
    public void removeObject(GameObject temObject){
        object.remove(temObject);
    }

    public boolean getUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean getDown() {
        return down;
    }

    public void  setDown(boolean down) {
        this.down = down;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean getRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
