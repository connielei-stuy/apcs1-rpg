/*
Team C-
Caleb Smith Salzberg
Connie Lei
HW34 -- Ye Olde Role Playing Game, Unchained
2016-11-21
*/

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated...
    private Character pat; //Is it man or woman?
    private Character smaug; //Friendly generic monster name?

    private int moveCount;
    private boolean gameOver;
    private int difficulty;
    private int character;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG()
    {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- gathers info to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame()
    {
	String s;
	String name = "";
	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "\nYou're alive! What do you want to be?\n";
	s +=  "Each role has different strengths and weaknesses.\n A warrior has medium health, high defense and strength and low attack rating.\n A mage has low health, low defense, high strength and high attack rating.\n A rouge has medium health, defense, strength, attack rating.\n An assassin has low health, no defense, extremely high strength and attack rating.\n A paladin has high health and defense, low strength and attack rating.\n";	
	s += "\t1: Warrior\n";
	s += "\t2: Mage\n";
	s += "\t3: Rouge\n";
	s += "\t4: Assasin\n";
	s += "\t5: Paladin\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    character = Integer.parseInt( in.readLine() );
	}
	catch (IOException e ) { }

	s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	//instantiate the player's character
	if ( character == 1)
	    pat = new Warrior( name );
	else if ( character == 2)
	    pat = new Mage (name);
	else if ( character == 3)
	    pat = new Rouge ( name );
	else if ( character == 4)
	    pat = new Assassin ( name );
	else
	    pat = new Paladin ( name );
    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    int weapon = 0;
    int armor = 0;
    public boolean playTurn()
    {
	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {
		if (pat.health < 20) {
			try{
				System.out.println("\nYour health is low! Splash health potion?");
				System.out.println("\t1:Nay.\n\t2: Aye!");
			}
			catch (IOException e){}
			int healthGain = (int)(Math.random() * 21);
			pat.health = pat.health + healthGain;
			System.out.println("\nYou have regained " + healthGain + "health.");
			healthGain = (int)Math.random() * 21;
			smaug.health = (smaug.health + healthGain);
			System.out.println("\nThe monster has regained" + healthGain + "health.");
		}
					
		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "\nDo you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    pat.specialize();
		else
		    pat.normalize();
      		if (weapon == 1){
            	    pat.strength=(int)(pat.strength*1.3);
                    pat.defense=(int)(pat.defense*.8);
		}
        	if (armor == 1){
            	    pat.strength=(int)(pat.strength*.8);
            	    pat.defense=(int)(pat.defense*1.3);
        	}
		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );

		System.out.println( "\n" + pat.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
				    " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		try {
		    System.out.println( "\nThe monster dropped his booty!" );
		    System.out.println( "\t1: Pick up the weapon! \n\t2: Pick up the armor!\n\t3: I don't need anythin'!");
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }
        if ( i == 1 ){
            weapon=1;
            System.out.println("You will be stronger, but it is now harder to defend yourself!");
        }
        else if (i == 2){
            armor=1;
            System.out.println("You will be weaker, but it is now easier to defend yourself!");
        }
        else
            System.out.println(" Interesting choice..."); 

		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args )
    {
	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//================================================
	//loading...
       	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
	//================================================
    }//end main

}//end class YoRPG


