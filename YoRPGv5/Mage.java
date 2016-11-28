public class Mage extends Character{
    public Mage(String n){
	name = n;
	health = 90;
	strength = 120;
	defense = 30;
	attackR = 0.75;
    }

    public void normalize(){
	strength = 120;
	defense = 30;
    }
    
    public void specialize(){
	strength  = 130;
	defense = 25;
    }	    
	
    public String about(){
	return "Mage\nHealth: " + health + "\nStrength: " + strength + "\nDefense: " + defense + "\nAttack Rating: " + attackR;
    }
}
