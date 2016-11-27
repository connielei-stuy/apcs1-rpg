public class Monster extends Character{

    public Monster () {
	health = 150;
	strength = (int) (Math.random() * 45 + 20);
	defense = 20;
	attackR = 1;
	name = "Ye Olde Monster";
    }

    public void normalize(){};
    
    public String about(){
	return "Monster\nHealth: " + health + "\nStrength: " + strength + "\nDefense: " + defense + "\nAttack Rating: " + attackR;
    }
}
