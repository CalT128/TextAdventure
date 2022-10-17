public class Monster {
    int health;
    int attack;
    int healthBonus = 0;
    int attackBonus = 0;
    public Monster(int h, int a){
        healthBonus = h;
        attackBonus = a;
        health = (int)(Math.random()*11+20+healthBonus);
        attack = (int)(Math.random()*11+10+attackBonus);
    }
    public Monster(){
        health = (int)(Math.random()*11+30+healthBonus);
        attack = (int)(Math.random()*11+15+attackBonus);

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
