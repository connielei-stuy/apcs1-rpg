public class Monster extends Character{

    /*=============================================
      constructor -- intializes attributes
      pre:  Monster class has been initialized
      post: sets strength to a random number in the range [20,65)
      sets health to 150, defense to 20 and attackR to 1
      =============================================*/
    public Monster () {
	health = 150;
	strength = (int) (Math.random() * 45 + 20);
	defense = 20;
	attackR = 1;
	name = "Ye Olde Monster";
    }
}
