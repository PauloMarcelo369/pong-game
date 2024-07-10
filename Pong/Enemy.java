import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    public double x, y;
    public Integer enemyWidth, enemyHeight;

    public Enemy(double x, double y){
        this.x = x;
        this.y = y;
        enemyHeight = 100;
        enemyWidth = 10;
    }

    public void draw(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.fillRect((int)x, (int)y, enemyWidth, enemyHeight);
    }

    public void update(){
        y = (PongGame.ball.y) * 0.75;
    }    
}
