public class Assassin extends Character{
    public Assassin(String n){
	name = n;
	health = 90;
	strength = 125;
	defense = 0;
	attackR = 1.2;
    }

    public void specialize(){
	strength = 130;
	defense = 0;
    }
	
    public void normalize(){
	strength = 125;
	defense = 0;
    }
    
    public String about(){
	return	"Assassin\nHealth: " + health + "\nStrength: " + strength + "\nDefense: " + defense + "\nAttack Rating: " + attackR;
    }
}
