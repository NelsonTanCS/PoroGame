import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.*;
import com.golden.gamedev.object.collision.*;

public class Main extends Game
{
BufferedImage fieldImg;
Background bg;
int bgX;

BufferedImage poroImg;
Player player;
public static SpriteGroup playerGroup;

BufferedImage unicornImg;
Unicorn unicorn;
public static SpriteGroup unicornGroup;

BufferedImage laserImg;
Laser laser;
public static SpriteGroup laserGroup;

CollisionManager collider1;
CollisionManager collider2;

	public void initResources()
	{
		// background image
		fieldImg = getImage("field.png");
		bg = new ImageBackground(fieldImg);
		bg.setSize(1600,600);
		
		// player sprite
		poroImg = getImage("poro.png");
		player = new Player(poroImg,bg,this);
		playerGroup = new SpriteGroup("Player");
		playerGroup.add(player);
		
		// unicorn sprites
		unicornImg = getImage("unicorn.png");
		unicorn = new Unicorn(unicornImg,bg,this);
		unicornGroup = new SpriteGroup("Unicorn");
		unicornGroup.add(unicorn);
		
		
		// laser sprite
		laserImg = getImage("laser.png");
		laser = new Laser(laserImg,bg, this, player);
		laserGroup = new SpriteGroup("Laser");
		laserGroup.add(laser);
		
		collider2 = new UnicornLaserCollision();
		collider2.setCollisionGroup(unicornGroup,laserGroup);
		
		collider1 = new UnicornPlayerCollision();
		collider1.setCollisionGroup(unicornGroup,playerGroup);
		
		
	}
	
	public void update(long elapsedTime)
	{
		bg.update(elapsedTime);
		playerGroup.update(elapsedTime);
		unicornGroup.update(elapsedTime);
		laserGroup.update(elapsedTime);
		collider2.checkCollision();
		collider1.checkCollision();
		
		//this.bgX = this.bgX +1;
		//bg.setLocation(this.bgX,0);
	}
	
	public void render(Graphics2D g)
	{
		bg.render(g);
		playerGroup.render(g);
		unicornGroup.render(g);
		laserGroup.render(g);
	}
	
	public static void main(String[]args)
	{
		GameLoader game = new GameLoader();
		game.setup(new Main(), new Dimension(800,600), false);
		game.start();
	}
}