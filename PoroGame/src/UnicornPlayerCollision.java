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
	public static int GameOVER = 0;
	public UnicornPlayerCollision(Game aGame)
	{
		theGame = aGame;
	}

	public void collided(Sprite unicorn,Sprite player)
	{
		GameOVER = 1;
		player.setActive(false);
		System.out.println("you dead");
	}
}