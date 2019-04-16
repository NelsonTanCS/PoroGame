import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.collision.*;

public class Unicorn extends Sprite
{
	BufferedImage unicorn;
	
	public static Sprite[] unicorns;
	
	Game theGame;
	
	public Unicorn(BufferedImage unicorn, Background bg,int x, int y, Game aGame)
	{
		super(unicorn);
		//unicorns = Main.unicornGroup.getSprites();
		this.setBackground(bg);
		this.setLocation(x,y);
		this.setSpeed(-.1,5);
		
		theGame = aGame;
	}
	
	public void update(long elapsedTime)
	{
		super.update(elapsedTime);
		moveUnicorn();
		
	}
	
	public void moveUnicorn()
	{
		double y = this.getY();
		if(y > 800 - this.getHeight()){
			this.setSpeed(-.1,-.5);
		}
		else if(y<0){
			this.setSpeed(-.1,.5);
		}
		else{}
	}
}