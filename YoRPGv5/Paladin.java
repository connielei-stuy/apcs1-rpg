public class Paladin extends Character{
    public Paladin(String n){
	name = n;
	health = 175;
	strength = 80;
	defense = 90;
	attackR = 0.2;
    }

    public void normalize(){
	strength = 80;
	defense = 90;
    }
	
    public void specialize(){
	strength = 85;
	defense = 85;
    }	    
	    
    public String about(){
	return "Paladin\nHealth: " + health + "\nStrength: " + strength + "\nDefense: " + defense + "\nAttack Rating: " + attackR;
    }
}
