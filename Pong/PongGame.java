import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.lang.*;

public class PongGame extends Canvas implements Runnable, KeyListener{
    public static JFrame frame;
    public static final Integer WIDTH = 450;
    public static final Integer HEIGHT = 450;
    public static Player player;
    public static Enemy enemy;
    public static Ball ball;
    public static Score score;
    
    public PongGame(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame = new JFrame("Pong");
        frame.setVisible(true);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        new Thread(this).start();
        player = new Player(15, 150);
        enemy = new Enemy(425, 150);
        ball = new Ball(225, 200);
        score = new Score();
        this.addKeyListener(this);
    }

    private void draw(){
        BufferStrategy bs = getBufferStrategy();
        if (bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        player.draw(g);
        enemy.draw(g);
        ball.draw(g);
        score.draw(g);
        bs.show();
    }

    private void update(){
        player.update();
        enemy.update();
        ball.update();
        score.update(ball);
    }

    @Override
    public void run(){
            try{
                while (true) {
                    Thread.sleep(10);
                    draw();
                    update();
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            player.up = true;
            System.out.println(player.y);
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            player.down = true;
            System.out.println(player.y);
        }
    }
    
    
    public void keyTyped(KeyEvent e) {
    }
 
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            player.up = false;
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            player.down = false;
        }
    }
    

    public static void main(String[] args) {
        new PongGame();
    }
}
