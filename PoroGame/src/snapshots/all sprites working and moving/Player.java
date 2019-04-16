import java.awt.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;

public class Player extends Sprite
{
	BufferedImage poro;
	Game theGame;
	
	public Player(BufferedImage poro, Background bg, Game aGame)
	{
		super(poro);
		this.setBackground(bg);
		this.setLocation(10,300-this.getHeight()/2);
		theGame = aGame;
	}
	
	public void update(long elapsedTime)
	{
		super.update(elapsedTime);
		movePoro();
	}
	
	public void movePoro()
	{
		if(theGame.keyDown(KeyEvent.VK_UP)){
			this.setSpeed(0,-.25);
		}
		else if(theGame.keyDown(KeyEvent.VK_DOWN)){
			this.setSpeed(0,.25);
		}
		else if(theGame.keyDown(KeyEvent.VK_RIGHT)){
			this.setSpeed(.25,0);
		}
		else if(theGame.keyDown(KeyEvent.VK_LEFT)){
			this.setSpeed(-.25,0);
		}
		else{
			this.setSpeed(0,0);
		}
		
		double x = this.getX();
		double y = this.getY();
		if(x > 800-this.getWidth()){
			this.setSpeed(0,0);
			this.setX(799-this.getWidth());
		}
		else if(x < 0){
			this.setSpeed(0,0);
			this.setX(1);
		}
		else if(y<0){
			this.setSpeed(0,0);
			this.setY(1);
		}
		else if(y>600-this.getHeight()){
			this.setSpeed(0,0);
			this.setY(595-this.getWidth());
		}
	}
}