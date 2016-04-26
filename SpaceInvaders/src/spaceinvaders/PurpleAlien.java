package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class PurpleAlien extends Alien
{
	// purple aliens get their own graphic
	PImage graphic;
	PImage graphicTemp;
	
	
	public PurpleAlien(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
		
	
		// load in the alien4.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("alien4.png");
		this.graphicTemp = this.canvas.loadImage("alien1.png");
	
	}
	
	// override the superclass display method
	@Override
	public void display()
	{
		// only draw if we are alive
		if (this.alive)
		{
			//change the color of the alien
			if ((this.x > 300 && this.x < 500) || (this.x > 750))
			{
				// image the graphic to the screen
				canvas.image(this.graphic, this.x ,this.y, this.size, this.size);
			}
			else 
			{
				// image the graphic to the screen
				canvas.image(this.graphicTemp, this.x ,this.y, this.size, this.size);
			}
			

			
		}
	}
}
