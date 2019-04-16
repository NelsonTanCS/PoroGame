import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.*;
import com.golden.gamedev.object.collision.*;
import com.golden.gamedev.object.font.*;

public class Main extends Game
{
Font myFont	 = new Font("Serif", Font.BOLD, 44);
SystemFont sf;	
int score = 0;

BufferedImage fieldImg;
Background bg;
int bgX;

BufferedImage poroImg;
Player player;
public static SpriteGroup playerGroup;

BufferedImage unicornImg;
Unicorn unicorn;
int unicornY = 300;
int unicornX = 800;
public static SpriteGroup unicornGroup;

BufferedImage laserImg;
Laser laser;
public static SpriteGroup laserGroup;

CollisionManager collider1;
CollisionManager collider2;



	public void initResources()
	{
		sf = new SystemFont(myFont,Color.BLACK);
		
		
		// background image
		fieldImg = getImage("bigfield.png");
		bg = new ImageBackground(fieldImg);
		bg.setSize(1600,600);
		
		// player sprite
		poroImg = getImage("poro.png");
		player = new Player(poroImg,bg,this);
		playerGroup = new SpriteGroup("Player");
		playerGroup.add(player);
		
		// unicorn sprites
		unicornImg = getImage("unicorn.png");
		unicorn = new Unicorn(unicornImg,bg,unicornX, unicornY, this);
		unicornGroup = new SpriteGroup("Unicorn");
		for (int i=0;i<=9;i++){
			unicornX += unicorn.getWidth()+50;
			unicornY += unicorn.getHeight()+10;
			unicorn = new Unicorn(unicornImg,bg,unicornX, unicornY, this);
			unicorn.setID(i);
			unicornGroup.add(unicorn);
			//System.out.println("unicorn " + i + " created");
		}		
		
		
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
		
		//moveUnicorn();
		this.bgX = this.bgX +1;
		bg.setLocation(this.bgX,0);
	}
	
	public void render(Graphics2D g)
	{
		bg.render(g);
		playerGroup.render(g);
		unicornGroup.render(g);
		laserGroup.render(g);
		sf.drawString(g,"Boints: " + score,10,10);
	}
	
	/*public void moveUnicorn()
	{
		if(unicorn[0].getY < 0)
		{
			unicorn.setSpeed(.1,.5);
		}
		else if(unicorn[0].getY>700)
		{
			unicorn.setSpeed(-.1,.5);
		}
	}*/

	
	public static void main(String[]args)
	{
		GameLoader game = new GameLoader();
		game.setup(new Main(), new Dimension(800,600), false);
		game.start();
	}
}