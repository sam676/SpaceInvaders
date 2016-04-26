package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class GreenAlien extends Alien
{
	// green aliens get their own graphic
	PImage graphic;
	
	//size
	int size = 26;
	
	//change direction
	int direction = 3; 
	
	public GreenAlien(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
		
		// load in the alien3.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("alien3.png");
	}
	
	//override the move method
	@Override
	public void move()
	{
		// only update our x position based on our direction
		this.x += this.direction;

		// if we hit the right edge we should turn around
		// and move down by one row
		if (this.x > this.canvas.width)
		{
			this.direction *= -1;
			this.x = this.canvas.width;
			this.y += size;
		}
		
		// if we hit the left edge we should turn around
		// and move down by one row
		if (this.x < 0 - this.size)
		{
			this.direction *= -1;
			this.x = 0 - this.size;
			this.y += size;
		}
		
	}

	
	// override the superclass display method
	@Override
	public void display()
	{
		// only draw if we are alive
		if (this.alive)
		{
			// image the graphic to the screen
			canvas.image(this.graphic, this.x ,this.y, this.size, this.size);
			
			//make the green aliens grown and shrink
			if (this.size < 35)
			{
				this.size += 1;
			}
			else 
			{
				this.size = 25;
			}
			
		}
	}
}
