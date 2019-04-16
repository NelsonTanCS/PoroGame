/*import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import com.golden.gamedev.*;
import com.golden.gamedev.object.*;

public class UnicornDie extends AnimatedSprite
{
	BufferedImage[] frames;
	
	public UnicornDie(BufferedImage[] frames, Unicorn aUnicorn)
	{
		super(frames);
		this.setLocation(5000,0);
		Unicorn = aUnicorn;
		theGame = aGame;
	}
	
	public void update(long elapsedTime)
	{
		super.update(elapsedTime);
		unicornDie();
	}
	
	public void unicornDie()
	{
		if(UnicornLaserCollision == 1){
			this.setLocation(Unicorn.getX(),Unicorn.getY())
			this.setAnimate(true);
			
		}
	}
}