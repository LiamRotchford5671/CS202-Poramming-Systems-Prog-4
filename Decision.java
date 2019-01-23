//Liam Rotchford
// 11/28/18
package Main;

/* This class handles decision event nodes, the decision class holds a focus on the coins stat on the player. the income value will increase the coin stat and the payment variable will decrease it .
    In the decision class there is a constructor to initialize all values to 0, a constructor with args to take in values and set the decision class variables and the base class variables it inherits.
    A copy constructor, and a derived decision display that is dynamically bound via base class.
 */

public class Decision extends Journey {
    protected int income;           //variable who's value will increase the player coin stat
    protected int payment;          //variable who's value will decrease the player coin stat

    //CONSTRUCTOR
    public Decision(){
        income = 0;         //initialize decision values to 0
        payment = 0;
    }

    //COPY CONSTRUCTOR
    public Decision(final Decision d){
        this.income = d.income;
        this.payment = d.payment;
        super.copy(d);          //call the journey base class copy constructor
    }

    //CONSTRUCTOR WITH ARGS
    public Decision(String set, String event, int num, int gain, int loss){
        setting = set;              //set the decision values and the journey values that it inherits as a derived class
        type = event;
        ID = num;
        income = gain;
        payment = loss;
    }

    //DERIVED DECISION DISPLAY
    public int display(Player character){       //take in the player object that contains the player stat variables
        System.out.print("\n===========================================================");
        System.out.print("\n\to Space ID: " + ID);
        System.out.print("\n\to Setting: \n\t\t-" + setting);
        //TODO: ASK THE USER WHICH PATH TO TAKE HERE
        System.out.print("\n\to Decision Event: \n\t\t-" + type);

        //TODO: ENTER IN IF ELSE BLOCK TO ASK USER IF THEY ACCEPT THE CHANCE EVENT OR LEAVE IT
        System.out.print("\n\to Income: " + income);
        System.out.print("\n\to Payment: " + payment);

        if(income != 0)                         //alter the coin stat if the income and payment values are anything besides 0
            character.coins += income;
        else if(payment != 0)
            character.coins -= payment;
                                                //update the player stat variables and then display them
        character.update_player(character.health, character.mana, character.stamina, character.coins);
        character.player_stats();
        return 1;
    }
}
