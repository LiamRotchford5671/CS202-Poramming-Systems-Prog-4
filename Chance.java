//Liam Rotchford
// 11/28/18
package Main;

/* This class handles chance event nodes, dependant on the event there will be a value assigned to the bonus and consequence variables, along with the adjoining potion and poison variables to determine
    what player stat they should apply that value to. This class has a focus on the altering the player stats in terms of health, mana, and stamina. In the chance class there is a constructor to
    initialize all values to 0, a constructor with args to take in values and set the chance class variables and the base class variables it inherits. A copy constructor, and a derived chance display
    that is dynamically bound via base class.
 */
public class Chance extends Journey{
    protected int bonus;
    protected int potion;
    protected int consequence;
    protected int poison;

    //CONSTRUCTOR
    public Chance(){
        bonus = 0;
        potion = 0;
        consequence = 0;
        poison = 0;
    }

    //COPY CONSTRUCTOR
    public Chance(final Chance c){
        this.bonus = c.bonus;
        this.potion = c.potion;
        this.consequence = c.consequence;
        this.poison = c.poison;
        super.copy(c);              //call the journey base class copy constructor
    }

    //CONSTRURTOR WITH ARGS
    public Chance(String set, String event, int num, int gain, int gain_type, int loss, int loss_type){
        setting = set;              //set the chance variables and the chance variables to the args
        type = event;
        ID = num;
        bonus = gain;
        potion = gain_type;
        consequence = loss;
        poison = loss_type;
    }

    //DERIVED CHANCE DISPLAY
    public int display(Player character){
        System.out.print("\n===========================================================");
        System.out.print("\n\to Space ID: " + ID);
        System.out.print("\n\to Setting: \n\t\t-" + setting);
        //TODO: ASK THE USER WHICH PATH TO TAKE HERE
        System.out.print("\n\to Chance Event: \n\t\t-" + type);
        //TODO: ENTER IN IF ELSE BLOCK TO ASK USER IF THEY ACCEPT THE CHANCE EVENT OR LEAVE IT

        System.out.print("\n\to Bonus Value: " + bonus);
        System.out.print("\n\to Bonus Type: ");
        if(potion == 1) {                               //determine what stat the bonus applies to
            System.out.print("Health");
            character.health += bonus;
        }else if(potion == 2) {
            System.out.print("Mana");
            character.mana += bonus;
        }else if(potion == 3){
            System.out.print("Stamina");
            character.stamina += bonus;
        }
        System.out.print("\n\to Consequence Value: " + consequence);
        System.out.print("\n\to Consequence Type: ");   //determine what stat the consequence value applies too
        if(poison == 1) {
            System.out.print("Health");
            character.health -= consequence;
        }else if(poison == 2) {
            System.out.print("Mana");
            character.mana -= consequence;
        }else if(poison == 3){
            System.out.print("Stamina");
            character.stamina -= consequence;
        }
                                                    //update the player stat variables and then display them
        character.update_player(character.health, character.mana, character.stamina, character.coins);
        character.player_stats();
        return 1;
    }
}
