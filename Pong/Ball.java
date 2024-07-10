import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
    public double x, y, dx, dy, speed;
    public double originalX, originalY;
    public int ballWidth, ballHeight;

    public Ball(int x, int y){
        originalX = x;
        originalY = y;
        ballWidth = 10;
        ballHeight = 10;
        speed = 2.0;
        startBall();
    }

    public void startBall(){
        // try{
        //     Thread.sleep(30);
        // }
        // catch (InterruptedException e){
        //     e.printStackTrace();
        // }
        x = originalX;
        y = originalY;
        Random random = new Random();
        dx = random.nextBoolean() ? 1 : -1; 
        dy = random.nextBoolean() ? 1 : -1; 
    }

    public void draw(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.fillRect((int)x, (int)y, ballWidth, ballHeight);
    }

    public void update(){
        
        if (y <= 0 || y >= PongGame.HEIGHT - ballHeight){
            dy = -dy;
        }
        
        Rectangle ball = new Rectangle((int) (x + dx * speed), (int) (y + dy * speed ), ballWidth, ballHeight);
        Rectangle player = new Rectangle(PongGame.player.x, PongGame.player.y, PongGame.player.widthPlayer, PongGame.player.heightPlayer);
        Rectangle enemy = new Rectangle((int) PongGame.enemy.x, (int) PongGame.enemy.y, PongGame.enemy.enemyWidth, PongGame.enemy.enemyHeight);

        if (ball.intersects(player)){ 
            dx = -dx;
        }else if(ball.intersects(enemy)){
            dx = -dx;
        }
        x += dx * speed;
        y += dy * speed;
    }
}
