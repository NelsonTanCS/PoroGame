import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.collision.*;

public class UnicornLaserCollision extends BasicCollisionGroup
{	
	
	Game theGame;
	public UnicornLaserCollision()
	{
		
	}

	public void collided(Sprite unicorn,Sprite laser)
	{
		
		unicorn.setActive(false);
		laser.setLocation(1000,0);
	}
}