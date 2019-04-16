import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.collision.*;

public class UnicornPlayerCollision extends BasicCollisionGroup
{
	Game theGame;
	//Player aPlayer;

	public void collided(Sprite unicorn,Sprite player)
	{
		
		player.setActive(false);
		System.out.println("you dead");
		theGame.finish();
	}
}