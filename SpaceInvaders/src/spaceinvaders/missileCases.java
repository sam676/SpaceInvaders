package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class missileCases
{
	// store our current position on the screen
	public int x;
	public int y;
	 
	
	// store a reference to our graphical canvas
	public PApplet canvas;
	
	
	


	// constructor
	public missileCases(int x, int y, PApplet canvas)
	{
		this.x = x;
		this.y = y;
		this.canvas = canvas;
	
	}

	// missile cases consistantly move up towards the bottom of the screen
	public void move()
	{
		this.y += (int) (Math.random() * 2 + 2);
			
	}
	
	// draw the missile case on the screen
	public void display()
	{
		this.canvas.fill(255,000,100);
		this.canvas.rect(x,y,15,10);
	}
	
	// "reload" the missile - essentially place it on top of the player
	public void reload(double x, double y)
	{
		this.x = (int)x;
		this.y = (int)y;

	}
	
	// test to see if we hit the player
	public boolean missileCasesHitTest(int mx, int my)
	{
		// if the player is intersecting our current location
		// then return true & reload
		if (mx > this.x && mx < this.x+25 && my > this.y && my < this.y+25)
		{
			
			return true;
		}
		
		return false;
	}
	
	
}