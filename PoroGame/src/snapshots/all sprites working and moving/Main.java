import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.*;

public class Main extends Game
{
BufferedImage fieldImg;
Background bg;

BufferedImage poroImg;
Player player;
//public static SpriteGroup playerGroup;

BufferedImage unicornImg;
Unicorn unicorn;
//public static SpriteGroup unicornGroup;

BufferedImage laserImg;
Laser laser;
//public static SpriteGroup laserGroup;

	public void initResources()
	{
		fieldImg = getImage("field.png");
		bg = new ImageBackground(fieldImg);
		
		poroImg = getImage("poro.png");
		player = new Player(poroImg,bg,this);
		//playerGroup = new SpriteGroup("Player Group");
		
		unicornImg = getImage("unicorn.png");
		unicorn = new Unicorn(unicornImg,bg,this);
		//unicornGroup = new SpriteGroup("Unicorn Group");
		
		laserImg = getImage("laser.png");
		laser = new Laser(laserImg,bg, this, player);
		//laserGroup = new SpriteGroup("Laser Group");
		
		
	}
	
	public void update(long elapsedTime)
	{
		bg.update(elapsedTime);
		player.update(elapsedTime);
		unicorn.update(elapsedTime);
		laser.update(elapsedTime);
	}
	
	public void render(Graphics2D g)
	{
		bg.render(g);
		player.render(g);
		unicorn.render(g);
		laser.render(g);
	}
	
	public static void main(String[]args)
	{
		GameLoader game = new GameLoader();
		game.setup(new Main(), new Dimension(800,600), false);
		game.start();
	}
}