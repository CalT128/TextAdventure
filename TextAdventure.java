import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;


  boolean dead = false;
  
  //monster variables
  String mName;
  int mNameRand;
  int bNameRand;
  int hHealthRand;
  boolean mDead;
  int mCounter = 5;
  

  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0,5);
  }

  public void play()
  {
    String input;
    // start of adventure. You can change this if you like
    console.setImage("distantcity.jpg");

    // ask the user for their name.
    System.out.println("What is your name?\n");
    input = inScanner.nextLine();
    
    // Change ourHero's name
    // ADD CODE HERE
    ourHero.changeName(input);
    // describe the starting situation. Feel free to change this
    System.out.println("You wake up to find yourself on the edge of a shadowy forest. \nYou see what looks like a city in the distance. \nWhat would you like to do? \ncity: go towards the city\nforest: turn around and re-enter the forest\nnap: go back to sleep\n" + hName() + ": ");
    input = inScanner.nextLine();
    if (ourHero.getEnergy() - 2 >0){
      if (input.equals("forest")){
        if (energyCheck()){
          enterZone2();
        }
        else{
          mChanceZone1();
        }
      }
      else if (input.equals("city")){
        if (energyCheck()){
          enterZone4();
        }
        else{
          mChanceZone1();
        }
      }
      else{
        ourHero.nap();
        mChanceZone1();

      }
    }
    // get user input and go to the appropriate zone based on their input
    // ADD CODE HERE
    

  }

  private void enterZone1()
  {
    //DISTANT CITY
    // change image
    // ADD CODE HERE
    console.setImage("distantcity.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You find yourself on the edge of a shadowy forest. \nYou see what looks like a city in the distance. \nWhat would you like to do? \ncity: go towards the city\nforest: turn around and re-enter the forest\nnap: go to sleep\n" + ourHero.getName() + ": ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
    if (input.equals("forest")){
      if (energyCheck()){
        enterZone2();
      }
      else{
        mChanceZone1();
      }
        
    }
    else if (input.equals("city")){
      if (energyCheck()){
        enterZone4();
      }
      else{
        mChanceZone1();
      }
    }
    else{
      ourHero.nap();
      mChanceZone1();
      
    }
  }
    
    

  

  private void enterZone2()
  {
    // change image
    // ADD CODE HERE
    System.out.println("While walking back into the forest");
    monster(0,0,false,"");
    console.setImage("forest.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You find your self in a dark and scary forest, visibility is bad");
    System.out.println("What would you like to do?\ncity opening: go to the opening with the view of the city\ndeeper: tread deeper through the dark forest\nrest: go to sleep\n" + hName() + ": ");
    String input = inScanner.nextLine();
    if (input.equals("city opening")){
      if (energyCheck()){
        enterZone1();
      }
      else{
        mChanceZone2();
      }
    }
    else if (input.equals("deeper")){
      if(energyCheck()){
        enterZone3();
      }
      else{
        mChanceZone2();
      }
    }
    else{
      ourHero.nap();
      mChanceZone2();
    }
  }   
  private void enterZone3()
  {
    // change image
    // ADD CODE HERE
    console.setImage("mountains.png");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You find your self in front of an opening showing large mountain. \nWhat would you like to do? \nmountain: Travel up the mountain \nforest: turn around and enter the forest\nnap: go to sleep\n" + hName() + ": ");
    String input = inScanner.nextLine();
    if (input.equals("mountain")){
      if (energyCheck()){
        enterZone5();
      }
      else{
        mChanceZone3();
      }
    }
    else if (input.equals("forest")){
      if (energyCheck()){
        enterZone2();
      }
      else{
        mChanceZone3();
      }
    }
    else{
      ourHero.nap();
      mChanceZone3();
    }
    
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone4()
  {
    // change image
    // ADD CODE HERE
    console.setImage("city.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You arrive at the city but are supprised to see its completely empty");
    System.out.println("What will you do?\ncity opening: go back towards the forest\ndeeper: continue through the city\nnap: go to sleep\n" + hName() + ": ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if (input.equals("city opening")){
      if (energyCheck()){
        enterZone1();
      }
      else{
        mChanceZone4();
      }
    }
    else if(input.equals("deeper")){
      if (energyCheck()){
        enterZone6();
      }
      else{
        mChanceZone4();
      }
    }
    else{
      ourHero.nap();
      mChanceZone4();
    }
    
  }

  private void enterZone5()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }

  private void enterZone6()
  {
    // change image
    // ADD CODE HERE

    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE

    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    
  }
  private void monster(int h, int a, boolean b,String bossName){
    mName = "";
    boolean boss = b;
    if (boss){
      mName = bossName;
      mNameRand = 100000;
    }
    else{
      mNameRand = (int)(Math.random()*3+1);
    }
    
    Monster monster = new Monster(h,a);
    //setting monster name
    if (mNameRand == 1){
      mName = "Wolf";
      console.setImage("wolf.jpg");
    }
    else if (mNameRand == 2){
      mName = "Pumpkin";
    }
    else if (mNameRand == 3){
      mName = "Ghost";
      console.setImage("ghost.jpg");
    }
    //action
    System.out.println("You have been attacked by a " + mName + ". what will you do?\nYour attack power is: " + hAttack() + "\nYour health is " + hHealth() + "\n" + mName + " attack power is: " + monster.getAttack() + "\n" + mName + " health is: " + monster.getHealth() + "\nattack: Deal " + hAttack() +  " damage\nrun: You may loose some health\n" + hName()+ ": ");
    String input = inScanner.nextLine();
    //option run
    if (input.equals("run")){
      if (boss){
        hHealthRand = (int)(Math.random()*11+90);
      }
      else{
        hHealthRand = (int)(Math.random()*2);
      }
      ourHero.setHealth(ourHero.getHealth() - hHealthRand);
      System.out.println("The " + mName + " dealt " + hHealthRand + " damage while you were running away");
      System.out.println("Your health is now: " + hHealth());
      if (ourHero.getHealth()<0){
        dead = true;
      }
    }
    //option attack
    else{
      mDead = false;
      monster.attacked(hAttack());
      System.out.println("You attacked the " + mName + " for " + hAttack() + " damage.");
      System.out.println("The " + mName +" health is now " + monster.getHealth());
      //if monster is still alive
      if (monster.getHealth()>0){
        ourHero.setHealth(hHealth()-monster.getAttack());
        System.out.println(mName + " attacked you for " + monster.getAttack() + " damage.");
        System.out.println("Your health is now: " + hHealth());
        if (hHealth() <=0){
          dead = true;
        }
      }
      //if monster is dead
      else{
        System.out.println("You have eliminated the " + mName);
        ourHero.defeatMonster();
        if (ourHero.getMonstersDefeated() > mCounter+5){
          mCounter = ourHero.getMonstersDefeated();
          ourHero.bonus(2,2);
        }
        mDead = true;
      }
      if (dead == false && mDead == false){
        while (true){
          System.out.println("What would you like to do?\nYour attack power is: " + hAttack() + "\nYour health is " + hHealth() + "\n" + mName + " attack poewr is: " + monster.getAttack() + "\n" + mName + " health is: " + monster.getHealth() + "\nattack: Deal " + hAttack() +  " damage\nrun: You may loose some health\n" + hName()+ ": ");
          input = inScanner.nextLine();
          //option run
          if (input.equals("run")){
            int hHealthRand = (int)(Math.random()*2);
            ourHero.setHealth(ourHero.getHealth() - hHealthRand);
            System.out.println("The " + mName + " dealt " + hHealthRand + " damage while you were running away");
            System.out.println("Your health is now: " + hHealth());
            if (ourHero.getHealth()<0){
              dead = true;
              break;
            }
          }
          //option attack
          else{
            mDead = false;
            monster.attacked(hAttack());
            System.out.println("You attacked the " + mName + " for " + hAttack() + " damage.");
            System.out.println("The " + mName + "health is now: " + monster.getHealth());
            //if monster is still alive
            if (monster.getHealth()>0){
              ourHero.setHealth(hHealth()-monster.getAttack());
              System.out.println(mName + " attacked you for " + monster.getAttack() + " damage.");
              System.out.println("Your health is now: " + hHealth());
              if (hHealth() <=0){
                dead = true;
                break;
              }
            }
            //if monster is dead
            else{
              System.out.println("You have eliminated the " + mName);
              mDead = true;
              break;
            }
          }
        }

      }
    }
  }
  private void mChanceZone1(){
    if (rand()==1){
      monster(0,0,false,"");
      if(dead){
        gameEnd();
      }
      else {
        enterZone1();
      }
    }
    else{
      enterZone1();
    }
  }
  private void mChanceZone2(){
    if (rand()==1){
      monster(0,0,false,"");
      if(dead){
        gameEnd();
      }
      else{
        enterZone2();
      }
    }
    else{
      enterZone2();
    }
  }
  private void mChanceZone3(){
    
    if (rand()==1){
      monster(5,5,false,"");
      if(dead){
        gameEnd();
      }
      else{
        enterZone3();
      }
    }
    else{
      enterZone3();
    }
  }
  
  private void mChanceZone4(){
    if (rand()==1){
      monster(5,5,false,"");
      if(dead){
        gameEnd();
      }
      else{
        enterZone4();
      }
    }
    else{
      enterZone4();
    }
  }
  private void mChanceZone5(){
    if (rand()==1){
      monster(10,10,false,"");
      if(dead){
        gameEnd();
      }
      else{
        enterZone4();
      }
    }
    else{
      enterZone4();
    }
  }
  private int rand(){
    return (int)(Math.random()*2);
  }
  private int hHealth(){
    return ourHero.getHealth();
  }
  private int hAttack(){
    return ourHero.getAttack();
  }
  private String hName(){
    return ourHero.getName();
  }
  private int hEnergy(){
    return ourHero.getEnergy();
  }
  private boolean energyCheck(){
    if (hEnergy()-2 >0){
      ourHero.energy = hEnergy()-2;
      System.out.println("Energy - 2");
      return true;
    }
    else{
      System.out.println("You must nap before traveling, Energy is too low");
      ourHero.nap();
      return false;
    }
  }
  
  

  private void gameEnd()
  {
    // ADD CODE HERE

    inScanner.close();
  }
}