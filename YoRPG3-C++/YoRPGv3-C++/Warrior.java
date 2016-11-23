public class Warrior extends Character{
    public Warrior(String n){
	name = n;
	health = 125;
	strength = 80;
	ogStrength = 80;
	defense = 90;
	ogDefense = 90;
	attackR = 0.2;
    }
    public String toString(){
	return "\nWarrior \nHealth: 125 \nStrength: 80 \nDefense: 90 \nAttack Rating: 0.2";
    }
}
