import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.collision.*;

public class UnicornLaserCollision extends BasicCollisionGroup
{	
	
	Game theGame;
	public static int play = 0;
	public static int dead = 0;
	public UnicornLaserCollision(Game aGame)
	{
		theGame=aGame;
	}

	public void collided(Sprite unicorn,Sprite laser)
	{
		//play = 1;
		dead = 1;
		unicorn.setActive(false);
		laser.setLocation(1000,0);
	}
}