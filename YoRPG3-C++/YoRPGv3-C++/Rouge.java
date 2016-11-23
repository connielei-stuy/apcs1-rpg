public class Rouge extends Character{
    public Rouge(String n){
	name = n;
	health = 125;
	strength = 100;
	ogStrength = 100;
	defense = 45;
	ogDefense = 45;
	attackR = 0.5;
    }
    public String toString(){
	return "\nRouge \nHealth: 125 \nStrength: 100 \nDefense: 45 \nAttack Rating: 0.5";
    }
}
