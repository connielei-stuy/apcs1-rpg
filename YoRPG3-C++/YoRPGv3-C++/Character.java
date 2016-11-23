public class Character{
    protected String name;
    protected int health;
    protected int strength;
    protected int defense;
    protected double attackR;

    protected int ogStrength;
    protected int ogDefense;
	
    public boolean isAlive(){
	return (health > 0);
    }

    public int getDefense(){
	return defense;
    }

    public String getName(){
	return name;
    }

    public void lowerHP(int damage){
	health = health - damage;
    }

    public int attack(Character enemy){
	int damage = (int) ((strength * attackR) - enemy.getDefense());
	if (damage < 0)
	    damage = 0;
	enemy.lowerHP(damage);
	return damage;
    }

    public void specialize(){
	if (defense - 5 <= 0)
	    defense = 0;
	else
	    defense = defense - 5;
	strength = strength + 5;
    }

    public void normalize(){
	defense = ogDefense;
	strength = ogStrength;
    }
    
    public String about(){
	Character temp = new Warrior("");
	String s;
	s = temp.toString();	    
	temp = new Mage("");
	s += temp.toString();
	temp = new Assassin("");
	s += temp.toString();
	temp = new Paladin("");
	s += temp.toString();
	temp = new Rouge("");
	s += temp.toString();
	return s;
    }
}
