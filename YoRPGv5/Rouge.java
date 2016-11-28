public class Rouge extends Character{
    public Rouge(String n){
	name = n;
	health = 125;
	strength = 100;
	defense = 45;
	attackR = 0.5;
    }
    
    public void normalize(){
	strength = 100;
	defense = 45;
    }
   
    public void specialize(){
	 strength = 105;
	 defense = 40;
    }
	
    public String about(){
	return	"Rouge\nHealth: " + health + "\nStrength: " + strength + "\nDefense: " + defense + "\nAttack Rating: " + attackR;
    }
}
