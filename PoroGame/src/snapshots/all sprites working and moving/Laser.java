import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import com.golden.gamedev.*;
import com.golden.gamedev.object.*;

public class Laser extends Sprite
{
	BufferedImage laser;
	Player player;
	Game theGame;
	
	public Laser(BufferedImage laser, Background bg, Game aGame, Player aPlayer)
	{
		super(laser);
		this.setLocation(1000,0);
		player = aPlayer;
		theGame = aGame;
	}
	
	public void update(long elapsedTime)
	{
		super.update(elapsedTime);
		shootLaser();
		laserSound();
	}
	
	public void shootLaser()
	{
		double bulletDistance = this.getDistance(player);
		if(theGame.keyDown(KeyEvent.VK_SPACE)) {
			if(bulletDistance >800){ //get distance to make fire rate constant
					this.setLocation(player.getX()+player.getWidth()-this.getWidth()/2,player.getY()+player.getHeight()/2-this.getHeight()/2);
					this.setSpeed(1,0);
				}
			}
	}
	
	public void laserSound(){
		if(theGame.keyDown(KeyEvent.VK_SPACE)){
			theGame.playSound("SpaceGun10.wav");
		}
	}
}