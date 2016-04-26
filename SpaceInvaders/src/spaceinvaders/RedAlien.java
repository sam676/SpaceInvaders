package spaceinvaders;

import processing.core.PApplet;
import processing.core.PImage;

public class RedAlien extends Alien
{
	// red aliens get their own graphic
	PImage graphic;
	
	// red aliens are larger
		int size = 30;

	
	public RedAlien(int x, int y, PApplet canvas)
	{
		super(x,y,canvas);
		
		// load in the alien2.png graphic from the data folder
		// store it in our graphic instance variable
		this.graphic = this.canvas.loadImage("alien2.png");
		
		
	}
	
	//override the move method
		@Override
		public void move()
		{
			// only update our x position based on our direction
			this.x += this.direction;

			// if we hit the right edge we should turn around
			// and move down by 1.5 rows
			if (this.x > this.canvas.width)
			{
				this.direction *= -1;
				this.x = this.canvas.width;
				this.y += size * 1.50;
			}
			
			// if we hit the left edge we should turn around
			// and move down by 1.5 rows
			if (this.x < 0 - this.size)
			{
				this.direction *= -1;
				this.x = 0 - this.size;
				this.y += size * 1.50;
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
	

		}
	}
}
