//Liam Rotchford
// 11/28/18
package Main;

/* This class handles spell event nodes, dependant on the event there will be a value assigned to the miracle and curse variables, along with the adjoining blessing and bane variables to determine
    what player stat they should apply that value to. This class has a focus on the altering the player stats in terms of health, mana, and stamina. In the spell class there is a constructor to
    initialize all values to 0, a constructor with args to take in values and set the spell class variables and the base class variables it inherits. A copy constructor, and a derived spell display
    that is dynamically bound via base class.
 */
public class Spell extends Journey{
    protected int miracle;          //spell variables, miracle, beneficial value
    protected int blessing;             //determines which stat miracle value is applied (health, mana, stamina)
    protected int curse;                //curse, provides a value that will decrement from a stat, and bane determines what stat that will be
    protected int bane;

    //CONSTRUTOR
    public Spell(){
        miracle = 0;
        blessing = 0;
        curse = 0;
        bane = 0;
    }

    //COPY CONSTRUCTOR
    public Spell(final Spell s){
        this.miracle = s.miracle;
        this.blessing = s.blessing;
        this.curse = s.curse;
        this.bane = s.bane;
        super.copy(s);          //call journey base class copy constructor
    }

    //CONSTRUCTOR WITH ARGS
    public Spell(String set, String event, int num, int mira, int bless, int cur , int ban){
        setting = set;          //initialize Spell values and journey values for a spell object to then be stored in the bnode to be inserted into the BST tree
        type = event;
        ID = num;
        miracle = mira;
        blessing = bless;
        curse = cur;
        bane = ban;
    }

    //SPELL DISPLAY
    public int display(Player character){       //dynamically bound display to journey
        System.out.print("\n===========================================================");
        System.out.print("\n\to Space ID: " + ID);
        System.out.print("\n\to Setting: \n\t\t-" + setting);
        //TODO: ASK THE USER WHICH PATH TO TAKE HERE
        System.out.print("\n\to Spell Event: \n\t\t-" + type);

        //TODO: ENTER IN IF ELSE BLOCK TO ASK USER IF THEY ACCEPT THE EVENT OR LEAVE IT
        System.out.print("\n\to Miracle Value: " + miracle);
        System.out.print("\n\to Miracle Type: ");
        if(blessing == 1) {                                 //determine what the miracle value will apply too on character stats which are stored as player object values
            System.out.print("Health");
            character.health += miracle;
        }else if(blessing == 2) {
            System.out.print("Mana");
            character.mana += miracle;
        }else if(blessing == 3){
            System.out.print("Stamina");
            character.stamina += miracle;
        }

        System.out.print("\n\to Curse Value: " + curse);
        System.out.print("\n\to Curse Type: ");             //determine what the curse value will apply too on character stats which are stored as player object values
        if(bane == 1) {
            System.out.print("Health");
            character.health -= curse;
        }else if(bane == 2) {
            System.out.print("Mana");
            character.mana -= curse;
        }else if(bane == 3){
            System.out.print("Stamina");
            character.stamina -= curse;
        }
                                                            //update the character stat values now that they have been altered by the miracle and curse values
        character.update_player(character.health, character.mana, character.stamina, character.coins);
        character.player_stats();                           //display the character stats
        return 1;
    }

}
