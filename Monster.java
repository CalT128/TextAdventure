public class Monster {
    int health;
    int attack;
    int healthBonus = 0;
    int attackBonus = 0;
    public Monster(int h, int a){
        healthBonus = h;
        attackBonus = a;
        health = (int)(Math.random()*10+1+healthBonus);
        attack = (int)(Math.random()*10+1+attackBonus);
    }
    public Monster(){
        health = (int)(Math.random()*10+1+healthBonus);
        attack = (int)(Math.random()*10+1+attackBonus);

    }
    public int getHealth(){
        return health;
    }
    public int getAttack(){
        return attack;
    }
    public void attacked(int a){
        health = health-a;
    }
}
