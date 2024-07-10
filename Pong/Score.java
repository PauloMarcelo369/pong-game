import java.awt.Color;
import java.awt.Graphics;

public class Score {
    int playerScore;
    int enemyScore;

    public Score(){
        playerScore = 0;
        enemyScore = 0;
    }
    public void incrementScorePlayer(){
        playerScore++;
    }
    
    public void incrementScoreEnemy(){
        enemyScore++;
    }

    public void draw(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.drawString("player: " + playerScore + " | enemy: " + enemyScore , 175, 15);
    }
    
    public void update(Ball ball){
        if (ball.x <= 0){
            enemyScore++;
            ball.startBall();
        } 
        else if (ball.x >= PongGame.WIDTH - ball.ballWidth){
            playerScore++;
            ball.startBall();
        }
    }
}
