import java.util.*;

public class Player
{
  String name;
  int health;
  int attack;
  double gold;
  int monstersDefeated;
  int energy = 10;

  public Player(String playerName, int startingHealth, double startingGold,int attackPower)
  {
    // ADD CODE HERE
    name = playerName;
    health = startingHealth;
    gold = startingGold;
    attack = attackPower;
  }

  public String getName()
  {
    return name;
  }

  public void changeName(String newName)
  {
    // ADD CODE HERE
    name = newName;
  }

  public int getHealth()
  {
    return health;
  }

  public void setHealth(int newHealth)
  {
    // ADD CODE HERE
    health = newHealth;
  }

  public double getGold()
  {
    return gold;
  }

  public void setGold(double newAmount)
  {
    // ADD CODE HERE
    gold = newAmount;
  }

  public int getMonstersDefeated()
  {
    return monstersDefeated;
  }

  public void defeatMonster()
  {
    // ADD CODE HERE
    monstersDefeated++;
  }
  public int getEnergy(){
    return energy;
  }
  public void nap(){
    energy = energy + 5;
    System.out.println("You took a nap\nEnergy + 5");
  }
  public int randAttack(){
    return (int)(Math.random()*10+attack);
  }
  public void bonus(int healthBonus, int attackBonus){
    health = health+healthBonus;
    attack = attack+attackBonus;
  }
}