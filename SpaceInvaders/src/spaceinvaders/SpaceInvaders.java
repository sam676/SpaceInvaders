package spaceinvaders;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import sun.security.pkcs.EncodingException;

public class SpaceInvaders extends PApplet 
{
	
	
	// the user controlled player
	Player thePlayer;
	int playerMovementDirection = 0;

	// the user controlled missiles
	Missile missile1;
	Missile missile2;
	
	//# of missiles
	int numMissiles1 = 5;
	int numMissiles2 = 5;
	
	
	
	//alien missiles
	AlienMissile [] theAlienMissiles;

	// our aliens
	Alien[] theAliens;
	
	//our missile cases
	missileCases [] cases; 
	
	//alien hit counter
	int AlienCounter= 0;
	
	// store a reference to the canvas
		PApplet canvas;
		
	//splash screen image	
		PImage welcome;
		PImage lost;
		PImage won;
		
	//game state
		int state = 0;
		
		
		
	
	public void setup() {
		// set the size of our graphics canvas
		size(1000, 700);

		// smooth all drawing
		smooth();

		// draw all rectangles from their center points
		rectMode(CENTER);

		// create a new instance of our Player class
		this.thePlayer = new Player(this.width / 2, this.height - 25, this, true);

		// create new instances of our Missile class
		this.missile1 = new Missile(0, -50, this);
		this.missile2 = new Missile(0, -50, this);
	

		// create new aliens
		this.theAliens = new Alien[20];
		this.theAliens[0] = new BlueAlien(0, 25, this);
		this.theAliens[1] = new BlueAlien(25, 25, this);
		this.theAliens[2] = new BlueAlien(50, 25, this);
		this.theAliens[3] = new BlueAlien(75, 25, this);
		this.theAliens[4] = new BlueAlien(100, 25, this);
		this.theAliens[5] = new BlueAlien(125, 25, this);
		this.theAliens[6] = new PurpleAlien(0, 50, this);
		this.theAliens[7] = new PurpleAlien(25, 50, this);
		this.theAliens[8] = new PurpleAlien(50, 50, this);
		this.theAliens[9] = new PurpleAlien(75, 50, this);
		this.theAliens[10] = new PurpleAlien(100, 50, this);
		this.theAliens[11] = new PurpleAlien(125, 50, this);
		this.theAliens[12] = new GreenAlien(0, 75, this);
		this.theAliens[13] = new GreenAlien(25, 75, this);
		this.theAliens[14] = new GreenAlien(50, 75, this);
		this.theAliens[15] = new GreenAlien(75, 75, this);
		this.theAliens[16] = new RedAlien(-25, 100, this);
		this.theAliens[17] = new RedAlien(0, 100, this);
		this.theAliens[18] = new RedAlien(75, 100, this);
		this.theAliens[19] = new RedAlien(100, 100, this);

		// create missiles
		this.theAlienMissiles = new AlienMissile[20];
		this.theAlienMissiles[0] = new AlienMissile(0, 25, this);
		this.theAlienMissiles[1] = new AlienMissile(25, 25, this);
		this.theAlienMissiles[2] = new AlienMissile(50, 25, this);
		this.theAlienMissiles[3] = new AlienMissile(75, 25, this);
		this.theAlienMissiles[4] = new AlienMissile(100, 25, this);
		this.theAlienMissiles[5] = new AlienMissile(125, 25, this);
		this.theAlienMissiles[6] = new AlienMissile(0, 50, this);
		this.theAlienMissiles[7] = new AlienMissile(25, 50, this);
		this.theAlienMissiles[8] = new AlienMissile(50, 50, this);
		this.theAlienMissiles[9] = new AlienMissile(75, 50, this);
		this.theAlienMissiles[10] = new AlienMissile(100, 50, this);
		this.theAlienMissiles[11] = new AlienMissile(125, 50, this);
		this.theAlienMissiles[12] = new AlienMissile(0, 75, this);
		this.theAlienMissiles[13] = new AlienMissile(25, 75, this);
		this.theAlienMissiles[14] = new AlienMissile(50, 75, this);
		this.theAlienMissiles[15] = new AlienMissile(75, 75, this);
		this.theAlienMissiles[16] = new AlienMissile(-25, 100, this);
		this.theAlienMissiles[17] = new AlienMissile(0, 100, this);
		this.theAlienMissiles[18] = new AlienMissile(75, 100, this);
		this.theAlienMissiles[19] = new AlienMissile(100, 100, this);
		
		//create missile cases
		this.cases = new missileCases[3];
		this.cases[0] = new missileCases(100, 25, this);
		this.cases[1] = new missileCases(500, 25, this);
		this.cases[2] = new missileCases(750, 25, this);
				
 		// load in our font so that we can draw text to the screen
		PFont genericFont = loadFont("sansSerifFont24.vlw");

		// set the default font as the one we just loaded
		this.textFont(genericFont);

		//load splash screens
		//this.welcome = this.canvas.loadImage("spaceInvaders.png");
		//this.won = this.canvas.loadImage("youWon.png");
		//this.lost = this.canvas.loadImage("gameOver.png");
		

	}

	public void draw() 
	{
		if (state == 0)
		{
			// erase the background
			background(0);
			fill (0,255,0);
			text("SPACE INVADERS", 400, 300);
			
			text("A = Moves Left", 400, 350);
			text("D = Moves Right", 400, 375);
			text("S = Fire Missile 1", 400, 400);
			text("F = Fire Missile 2", 400, 425);
			fill(255,000,100);
			text("CATCH A RED MISSILE CASE TO RELOAD!", 275, 460);
			
			fill(255);
			text("CLICK ANY KEY TO CONTINUE ", 325, 500);
			

			// image the graphic to the screen
			//canvas.image(this.welcome, 0 ,0, this.width, this.height);
			
		}
		else if (state == 1){
		
		// erase the background
		background(0);
		
		// title text
		fill(0,255,0);
		text("Space Invaders!", 0, 25);
		fill(255);
		
		text("Score = ", 800, 25);
		text("Missile1 Shots = ", 300, 25);
		text("Missile2 Shots = ", 550, 25);
		fill(0,255,0);
		text(AlienCounter, 900, 25);
		
		text(numMissiles1, 505, 25);
		text(numMissiles2, 755, 25);
		
		if (AlienCounter == 20)
		{
			state = 2;
		}
				
		// iterate over all aliens
		for (int i = 0; i < this.theAliens.length; i++)
		{
			// tell each one to move
			this.theAliens[i].move();
		
			
			// check each alien to see if the missile hit them
			// if so the alien will flip its own "alive" variable to false
			boolean hit = this.theAliens[i].missileHitTest(this.missile1.x,  this.missile1.y);
			boolean hit2 = this.theAliens[i].missileHitTest(this.missile2.x,  this.missile2.y);
			
			// you could do something with "hit" here if you needed to react to an alien being hit
			
			if (hit == true || hit2 ==true)
			{
				AlienCounter += 1;
			}
			
			
			
				// move and display each alien missile
				this.theAlienMissiles[i].move();
				this.theAlienMissiles[i].display();
				
				//reload Alien Missiles
				if (hit == false || hit2 == false)
				{
					if (theAlienMissiles[i].y > 700)
					{
						this.theAlienMissiles[i].reload((int) theAliens[i].x, (int) theAliens[i].y);
					}
				}
				
				//game over if the aliens touch the player
				if (theAliens[i].y > 690)
				{
					state = 3;
				}
			

			// display each alien
			this.theAliens[i].display();
		}
		
		//iterate over all the missile cases
		for (int i = 0; i < this.cases.length; i++)
		{
			this.cases[i].move();
			this.cases[i].display();
			
			
			if (this.cases[i].missileCasesHitTest(this.thePlayer.x, this.thePlayer.y))
			{
				numMissiles1 = 5;
				numMissiles2 = 5;
				
			}
			
			if (this.cases[i].y > 700)
			{
				this.cases[i].reload((Math.random()*1000), 25);
			}
			
		}
		
		
		
		
			
		// move and display the missile
		this.missile1.move();
		this.missile1.display();
		this.missile2.move();
		this.missile2.display2();
	
		// iterate over all missiles
				for (int i = 0; i < this.theAlienMissiles.length; i++)
				{
					// check the player to see if a missile hit 
					// if so the player will flip its own "alive" variable to false
					boolean PlayerHit = this.thePlayer.missileHitTest(this.theAlienMissiles[i].x, this.theAlienMissiles[i].y);
					
					
					if (PlayerHit == true)
					{
					
							state = 3;
				
					}
				}
		
		// move and display the player
		this.thePlayer.move(this.playerMovementDirection);
		this.thePlayer.display();
		
		}
		else if (state == 2)
		{
			background(0);
			fill(00,255,00);
			text("YOU WON!", 450, 300);
			
			
			// image the graphic to the screen
			//canvas.image(won, 0, 0 , this.width, this.height);
						
		}
		else
		{
			// erase the background
			background(0);
			fill(00,255,00);
			text("YOU LOST!", 450, 300);
			
			
			//image the graphic to the screen
			//canvas.image(lost, 0, 0, this.width, this.height);
			
		}
		
	
	}

	// every time a key is pressed this method will execute
	public void keyPressed()
	{
			if (key == ' ');
		{
			//change the state 
			state = 1; 
		}
		
		// user hit the 'a' key - indicate that we want to move left
		if (key == 'a')
		{
			this.playerMovementDirection = -1;
		}
		
		// user hit the 'd' key - indicate that we want to move right
		if (key == 'd')
		{
			this.playerMovementDirection = 1;
		}
		
		// user hit the 's' key - fire missile 1
		if (numMissiles1 > 0 && key == 's')
		{
			this.missile1.reload(this.thePlayer.x, this.thePlayer.y);
			numMissiles1--; 
		}
		
		//fire missile 2
		if ( numMissiles2 > 0 && key == 'f')
		{
			this.missile2.reload(this.thePlayer.x, this.thePlayer.y);
			numMissiles2--;
		}
		
		
		
	}
	
	// every time a key is released this method will execute
	public void keyReleased()
	{
		// indicate that the player should stop moving
		this.playerMovementDirection = 0;
	}
	
}
