package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class AlienMissile
{
	// store our current position on the screen
	public int x;
	public int y;
	 
	
	// store a reference to our graphical canvas
	public PApplet canvas;
	
	//player 
	boolean PlayerAlive = true;
	


	// constructor
	public AlienMissile(int x, int y, PApplet canvas)
	{
		this.x = x;
		this.y = y;
		this.canvas = canvas;
	
	}

	// missiles consistantly move up towards the bottom of the screen
	public void move()
	{
		this.y += (int) (Math.random() * 2 + 2);
			
	}
	
	// draw the missile on the screen
	public void display()
	{
		this.canvas.fill(225);
		this.canvas.rect(x,y,3,10);
	}
	
	// "reload" the missile - essentially place it on top of the player
	public void reload(int x, int y)
	{
		this.x = x;
		this.y = y;

	}
	
	
}