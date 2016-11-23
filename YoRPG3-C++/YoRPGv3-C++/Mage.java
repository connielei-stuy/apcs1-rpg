public class Mage extends Character{
    public Mage(String n){
	name = n;
	health = 90;
	strength = 120;
	ogStrength = 120;
	defense = 30;
	ogDefense = 30;
	attackR = 0.75;
    }
    public String toString(){
	return "\nMage \nHealth: 90 \nStrength: 120 \nDefense: 30 \nAttack Rating: 0.75";
    }
}
