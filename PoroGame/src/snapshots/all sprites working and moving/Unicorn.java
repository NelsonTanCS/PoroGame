import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;

public class Unicorn extends Sprite
{
	BufferedImage unicorn;
	
	public Unicorn(BufferedImage unicorn, Background bg, Game aGame)
	{
		super(unicorn);
		this.setBackground(bg);
		this.setLocation(800-this.getWidth()/2,300-this.getHeight()/2);
		this.setSpeed(-.1,.5);
	}
	
	public void update(long elapsedTime)
	{
		super.update(elapsedTime);
		moveUnicorn();
	}
	
	public void moveUnicorn()
	{
		double y = this.getY();
		if(y > 450-this.getHeight()){
			this.setSpeed(-.1,-.5);
		}
		else if(y<150){
			this.setSpeed(-.1,.5);
		}
		else{}
	}
}