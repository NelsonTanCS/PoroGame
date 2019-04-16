import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import com.golden.gamedev.*;
import com.golden.gamedev.object.*;

public class BossUnicorn extends Sprite
{
	BufferedImage bossUnicorn;
	Game theGame;
	public BossUnicorn(BufferedImage bossUnicorn,Background bg, Game aGame)
	{
		super(bossUnicorn);
		this.setBackground(bg);
		this.setLocation(800,300);
		this.setSpeed(-.1,.5);
		
		theGame = aGame;
	}
	
	public void update(long elapsedTime)
	{
		super.update(elapsedTime);
	}
}