//Liam Rotchford
// 11/28/18
package Main;

/*  The player class handles the player stat variables that change as the player moves through the tree encountering events that affect these stats. I only declare the player object once so it stays
    consistent as the user moves through the tree. The constructor begins the character with base stat values, the update player takes in the args from the function call of the derived class
    displays that chance the values of the stats. The player stats display after they have been updated is called to show the player after each movement where they currently stand stat-wise
 */

public class Player {

    protected int health;   //player stats
    protected int mana;
    protected int stamina;
    protected int coins;

    //CONSTRUCTOR
    public Player(){        //set the player with base stats
        health = 100;
        mana = 100;
        stamina = 100;
        coins = 50;
    }

    //UPDATE PLAYER STATS
    public void update_player(int life, int magic, int energy, int cash){
        this.health = life;             //this function is called after the node object event has been displayed and the effects of the event have altered the values, this is called
        this.mana = magic;                  //to fully update the objects variables so they don't get reset after each event
        this.stamina = energy;
        this.coins = cash;
    }

    //PLAYER STAT DISPLAY
    public void player_stats(){             //display the current values of the player stats
        System.out.print("\n\n\t\to Player Stats: \n\t\t++++++++++++++++");
        System.out.print("\n\t\t+ Health: " + health);
        System.out.print("\n\t\t+ Mana: " + mana);
        System.out.print("\n\t\t+ Stamina: " + stamina);
        System.out.print("\n\t\t+ Coins: " + coins);
    }
    //TODO: for program 5 this is the class that will handle the linked list of arrays, it will also be where the user chooses left or right when wanting to travel through the map,
    //I'll need to add the option to the user menu to start the game to stop running through the BST menu work, and then it will bring them to a separate menu that will focus on user travel
    //and choices when going through the map. in which case will need to add a if else case on when they choose to do something or not that will affect there stats, I may need to remove the player
    //stats display into here, and take the values out of the .txt file to allow for the player to handle that well enough. then i can add literals to it based on the choice
}
