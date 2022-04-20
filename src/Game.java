import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private final static long serialversionUID = 1L;

    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;

    public Game() {
        new Window(1000,563,"lEFT 4 DEAD 3",this);
        start();
        handler= new Handler();
        this.addKeyListener(new KeyInput(handler));

        //handler.addObject(new Box(100, 100, ID.Block));

        handler.addObject(new Wizard(100, 100, ID.Player, handler));

    }

    public static void main(String[] args) {
        new Game();

    }

    private void start(){
        isRunning=true;
        thread= new Thread(this);
        thread.start();
    }

    private void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("o");
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 2000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning){
            long now = System.nanoTime();
            delta+=(now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            //if(isRunning)
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void tick(){
        handler.tick();
    }
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3); //when the game is running it will create in advance 3 frames
            return;
        }
        Graphics g = bs.getDrawGraphics();

        ////////////////////////////////// all the lines of code below this area in charge of rendering/drawing stuff
        g.setColor(Color.RED);
        g.fillRect(5,5,10,10);
        handler.render(g);
        //////////////////////////////////
        g.dispose();
        bs.show();

    }

}
