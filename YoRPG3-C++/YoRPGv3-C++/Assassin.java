public class Assassin extends Character{
    public Assassin(String n){
	name = n;
	health = 90;
	strength = 125;
	ogStrength = 125;
	defense = 0;
	ogDefense = 0;
	attackR = 1.2;
    }
    public String toString(){
	return "\nAssassin \nHealth: 90 \nStrength: 125 \nDefense: 0 \nAttack Rating: 1.2";
    }
}
