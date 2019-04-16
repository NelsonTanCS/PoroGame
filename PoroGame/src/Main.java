import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.*;
import com.golden.gamedev.object.collision.*;
import com.golden.gamedev.object.font.*;

public class Main extends Game {
    Font myFont	 = new Font("Serif", Font.BOLD, 44);
    SystemFont sf;	
    int score = 0;
    
    BufferedImage skyImg;            // manual Parallax scrolling because api doesnt explain it well
    BufferedImage cloudsImg;
    BufferedImage grassImg;
    Background bg1;
    Background bg2;
    Background bg3;
    double bg1X;
    double bg2X;
    int bg3X;
    
    BufferedImage poroImg;
    Player player;
    public static SpriteGroup playerGroup;
    
    BufferedImage unicornImg;
    Unicorn unicorn;
    int unicornY = 0; // Y starting point for array
    int unicornX = 800;	// X starting point for array
    int randomX = 0;
    int minX = 10;
    int maxX = 100;
    int randomY = 0;
    int minY = 0;
    int maxY = 800;
    public static SpriteGroup unicornGroup;
    
    BufferedImage bossUnicornImg;
    BossUnicorn bossUnicorn;
    public static SpriteGroup bossUnicornGroup;
    
    BufferedImage laserImg;
    Laser laser;
    public static SpriteGroup laserGroup;
    
    CollisionManager collider1;
    CollisionManager collider2;
    
    BufferedImage[] frames;
    AnimatedSprite unicornDie;
    
    public void initResources() {
    	sf = new SystemFont(myFont,Color.BLACK);
    		
    		
    	// background images
   		skyImg = getImage("skyBg.png");
   		bg1 = new ImageBackground(skyImg);
   		bg1.setSize(3200,600);
    		
   		cloudsImg = getImage("cloudsBg.png");
   		bg2 = new ImageBackground(cloudsImg);
   		bg2.setSize(3200,600);
    		
   		grassImg = getImage("grassBg.png");
   		bg3 = new ImageBackground(grassImg);
   		bg3.setSize(3200,600);
    		
   		// player sprite
   		poroImg = getImage("poro.png");
   		player = new Player(poroImg,bg3,this);
   		playerGroup = new SpriteGroup("Player");
   		playerGroup.add(player);
    		
   		// unicorn sprites
   		unicornImg = getImage("unicorn.png");
   		unicorn = new Unicorn(unicornImg,bg3,unicornX, unicornY, this);
   		unicornGroup = new SpriteGroup("Unicorn");
   		for (int i=0;i<=1000;i++){ //add 1001 unicorns to sprite group
   			int randomX = (int)(Math.random()*(maxX - minX+1)+minX);
   			int randomY = (int)(Math.random()*(maxY - minY+1)+minY);
   			unicornX += randomX; // make em random
   			unicornY += randomY; // make em random
   			unicorn = new Unicorn(unicornImg,bg3,unicornX, unicornY, this);
   			//unicorn.setID(i);
    		unicornGroup.add(unicorn);
   			// System.out.println(randomX); check values coming from random
   			//System.out.println("unicorn " + i + " created");
   		}
   		
   		//boss sprite has render error
   		bossUnicornImg = getImage("bossUnicorn.png");
   		bossUnicorn = new BossUnicorn(bossUnicornImg,bg3,this);
   		bossUnicornGroup = new SpriteGroup("UnicornBoss");
   		bossUnicornGroup.add(bossUnicorn);
   		
   		// laser sprite
   		laserImg = getImage("laser.png");
   		laser = new Laser(laserImg,bg3, this, player);
   		laserGroup = new SpriteGroup("Laser");
   		laserGroup.add(laser);
   		
   		// animated sprite death animation
   		frames= getImages("unicornDie.png",4,1);
   		unicornDie = new AnimatedSprite(frames,-100,-100);
   		//unicornDie.setAnimate(true);
   		//unicornDie.setLoopAnim(true);
   		//unicornDie.getAnimationTimer().setDelay(100);
   		
   		//colliders
   		collider2 = new UnicornLaserCollision(this);
   		collider2.setCollisionGroup(unicornGroup,laserGroup);
   	
    	collider1 = new UnicornPlayerCollision(this);
    	collider1.setCollisionGroup(unicornGroup,playerGroup);
    	
    	
    }
    
    public void update(long elapsedTime) {
		bg1.update(elapsedTime);
		bg2.update(elapsedTime);
		bg3.update(elapsedTime);
		playerGroup.update(elapsedTime);
		unicornGroup.update(elapsedTime);
		bossUnicornGroup.update(elapsedTime);
		laserGroup.update(elapsedTime);
		unicornDie.update(elapsedTime);
		collider2.checkCollision(); // if collision, go to UnicornPlayerCollision.java
		collider1.checkCollision();
		if(UnicornPlayerCollision.GameOVER == 1)
		{
			finish();
		}
		if(UnicornLaserCollision.play == 1)
		{
			playSound("ClassicReward.wav");
		}
		
		//moveUnicorn();
		//move grass
		this.bg3X = this.bg3X +1;
		bg3.setLocation(this.bg3X,0);
		//move clouds half speed
		this.bg2X = this.bg2X +.5;
		bg2.setLocation(this.bg2X,0);
		//move sun tenth speed
		this.bg1X = this.bg1X+ .1;
		bg1.setLocation(this.bg1X,0);
		
	}
	
	public void render(Graphics2D g)
	{
		bg1.render(g); //sky
		bg2.render(g); //clouds
		bg3.render(g); //grass
		playerGroup.render(g);
		unicornGroup.render(g);
		laserGroup.render(g);
		unicornDie.render(g);
		//unicornBossGroup.render(g); error?
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