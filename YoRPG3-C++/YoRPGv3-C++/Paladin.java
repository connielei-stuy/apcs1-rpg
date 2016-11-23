public class Paladin extends Character{
    public Paladin(String n){
	name = n;
	health = 175;
	strength = 80;
	ogStrength = 80;
	defense = 90;
	ogDefense = 90;
	attackR = 0.2;
    }
    public String toString(){
	return "\nPaladin \nHealth: 175  \nStrength: 80 \nDefense: 90 \nAttack Rating: 0.2";
    }
}
