import java.awt.Color;
import java.awt.Graphics;

public class Player {
    public boolean up, down;
    public int x, y;
    public int widthPlayer, heightPlayer;

    public Player(int  x, int y){
        this.x = x;
        this.y = y;
        widthPlayer = 10;
        heightPlayer = 100;
    }

    public void draw(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.fillRect(x, y, widthPlayer, heightPlayer);
    }

    public void update(){
        if (up){
            y-=4;
        }else if (down){
            y+=4;
        }

        if (PongGame.HEIGHT < y + heightPlayer){
            y = PongGame.HEIGHT - heightPlayer;
        }else if (y < 0) y = 0;
    }
}
