public abstract class Character{
    protected String name;
    protected int health;
    protected int strength;
    protected int defense;
    protected double attackR;
	
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

    public abstract void normalize();
    public abstract void specialize();
    public abstract String about();
}
