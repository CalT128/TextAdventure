import java.util.*;

public class TextAdventure 
{
  FancyConsole console;
  Scanner inScanner;
  Player ourHero;

  boolean win = false;
  boolean dead = false;
  boolean fallingDeath = false;
  
  //monster variables
  String mName;
  int mNameRand;
  int bNameRand;
  int hHealthRand;
  boolean mDead;
  int mCounter = 0;
  //bosses
  boolean golem = true;
  boolean humanoid = true;
  boolean skeleton = true;
  int damageRed = 0;
  int actDamageRed;
  boolean firstEncounter = true;
  //chests
  boolean mountainChest = false;
  boolean pathChest = false;
  boolean mechanicalChest = false;
  
  

  public TextAdventure()
  {
    console = new FancyConsole("Great Text Adventure!", 600, 600);
    inScanner = new Scanner(System.in);

    // feel free to change the player's starting values
    ourHero = new Player("Bob", 100, 0,15);
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
    System.out.println("You wake up to find yourself on the edge of a shadowy forest. \nYou see what looks like a city in the distance. \nWhat would you like to do? \ncity: \tgo towards the city\nforest: \tturn around and re-enter the forest\nnap: \tgo back to sleep\n" + hName() + ": ");
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
    System.out.println("You find yourself on the edge of a shadowy forest. \nYou see what looks like a city in the distance. \nWhat would you like to do? \ncity: \tgo towards the city\nforest: \tturn around and re-enter the forest\nnap: \tgo to sleep\n" + ourHero.getName() + ": ");
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
    if (firstEncounter){
      System.out.println("While walking back into the forest");
      monster(0,0,false,"");
      if (dead){
        gameEnd();
      }
      firstEncounter = false;
    }
    console.setImage("forest.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You find your self in a dark and scary forest, visibility is bad");
    System.out.println("What would you like to do?\ncity opening: \tgo to the opening with the view of the city\ndeeper: \ttread deeper through the dark forest\nnap: \tgo to sleep\n" + hName() + ": ");
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
    System.out.println("You find your self in front of an opening showing large mountain. \nWhat would you like to do? \nmountain: \tTravel up the mountain \nforest: \tturn around and enter the forest\nnap: \tgo to sleep\n" + hName() + ": ");
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
    System.out.println("What will you do?\ncity opening: \tgo back towards the forest\ndeeper: \tcontinue through the city\nnap: \tgo to sleep\n" + hName() + ": ");
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
      //if mountain chest was opened
      if (mountainChest){
        if (energyCheck()){
          enterZone6();
        }
        else{
          mChanceZone4();
        }
      }
      //if mountain chest was not opened
      else{
        System.out.println("You cannot proceed without the \"The Chestplate of the lone golem\"");
        enterZone4();
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
    if (golem){
      System.out.println("The Golem of the mountain temple is preparing to attack you");
      monster(30,30,true,"Golem of the Temple");
      if (dead){
        gameEnd();
      }
      golem = false;
    }
    
    console.setImage("runesite.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You come across an ancient site at the top of the mountain. There is a chest straight ahead of you");
    System.out.println("what will you do?\nchest: \twalk towards the chest and open it\nturn around: \thead back down the mountain\nnap: \tgo to sleep\n" + hName() + ": ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if (input.equals("chest")){
      if (!mountainChest){
        ourHero.bonus(30,0);
        System.out.println("You've obtained \"The Chestplate of the lone golem\"\nDamage reduction of all monsters is -5");
        damageRed = damageRed + 5;
        mountainChest = true;
      }
      else{
        System.out.println("This chest is empty, as if it has already been opened");
      }
      enterZone5();
    }
    else if (input.equals("turn around")){
      if (energyCheck()){
        enterZone3();
      }
      else{
        mChanceZone5();
      }
    }
    else{
      ourHero.nap();
      mChanceZone5();
    }
  }

  private void enterZone6()
  {
    // change image
    // ADD CODE HERE
    console.setImage("massiveBuilding.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You appear before a massive building, their is an entrance ahead. Their is also a path next to the building");
    System.out.println("What will you do?\nentrance: \tenter the building\npath: \tfollow the path next to the building\ncity: \tgo to the city\nnap: \tgo to sleep\n" + hName() + ": ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if (input.equals("entrance")){
      if (energyCheck()){
        enterZone7();
      }
      else{
        mChanceZone6();
      }
    }
    else if(input.equals("path")){
      if (energyCheck()){
        enterZone8();
      }
      else{
        mChanceZone6();
      }
    }
    else if(input.equals("city")){
      if (energyCheck()){
        enterZone4();
      }
      else{
        mChanceZone6();
      }
    }
    else{
      ourHero.nap();
      mChanceZone6();
    }

    
  }
  private void enterZone7(){
    if (humanoid){
      System.out.println("When you reach the top of the building, their is a mechanical humanoid machine infront of you");
      System.out.println("The humanoid machine prepares to attack you");
      monster(40,40,true,"Humanoid Machine");
      if (dead){
        gameEnd();
      }
      humanoid = false;
    }
    // change image
    // ADD CODE HERE
    console.setImage("topBuilding.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("a wide expansive view of the city surrounds you");
    System.out.println("What will you do?\njump: \tjump off the side of the building, not recommended if you want your life intact\ndown:\tgo back down the building\nnap:\t go to sleep\n" + hName() + ": ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if (input.equals("jump")){
      if (mechanicalChest){
        enterZone11();
      }
      else{
        gameEnd();
      }
    }
    else if (input.equals("down")){
      if (energyCheck()){
        enterZone6();
      }
      else{
        mChanceZone7();
      }
    }
    else{
      ourHero.nap();
      mChanceZone7();
    }
  }
  private void enterZone8(){
    // change image
    // ADD CODE HERE
    console.setImage("path.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    String secretPath = "";
    String secretOption = "";
    if (pathChest){
      secretPath = ". Their is also a side path that has appeared";
      secretOption = "\nside path: follow the side path";
    }
    System.out.println("You arrive in the middle of the path, it is a small clearing" + secretPath);
    System.out.println("What will you do\npath: continue down the path" + secretOption + "\nbuilding: \tgo to the massive building\nnap: go to sleep\n" + hName() + ": ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if (input.equals("path")){
      if (energyCheck()){
        enterZone9();
      }
      else{
        mChanceZone8();
      }
    }
    else if (input.equals("side path")){
      if (pathChest){
        if (energyCheck()){
          enterZone10();
        }
        else{
          mChanceZone8();
        }
      }
      else{
        ourHero.nap();
        mChanceZone8();
      }
    }
    else if(input.equals("building")){
      if (energyCheck()){
        enterZone6();
      }
      else{
        mChanceZone8();
      }
    }
    else{
      ourHero.nap();
      mChanceZone8();
    }
  }
  private void enterZone9(){
    if (skeleton){
      System.out.println("A skeleton suddenly bursts from the ground");
      System.out.println("The Skeleton King prepares to attack you");
      monster(60,60,true,"Skeleton King");
      if (dead){
        gameEnd();
      }
      skeleton = false;
    }
    // change image
    // ADD CODE HERE
    console.setImage("graveyard.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You arrive at a graveyard, it is covered in smoke and you can barely see anything. Although you can see a path a dirt that looks supspicous");
    System.out.println("What will you do?\ndig: \tdig up the suspicous dirt\npath: \tgo back to the path\nnap: \tgo to sleep, although why would you sleep in a graveyard?\n" + hName() + ": ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if (input.equals("dig")){
      if (!pathChest){
        System.out.println("You dig up a pair of strange glasses");
        System.out.println("affect unknown");
        pathChest = true;
      }
      else{
        System.out.println("You find nothing, although the dirt is very loose");
      }
      enterZone9();
    }
    else if (input.equals("path")){
      if (energyCheck()){
        enterZone8();
      }
      else{
        mChanceZone9();
      }
    }
    else{
      ourHero.nap();
      mChanceZone9();
    }
  }
  private void enterZone10(){
    // change image
    // ADD CODE HERE
    console.setImage("ruinsite.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("You come across a ruined site, everything looks broken but their is an undamaged chest ahead");
    System.out.println("What will you do?\nopen: \topen the chest\npath: \tgo back to the side path\nnap: \tgo to sleep\n" + hName() + "; ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if (input.equals("open")){
      if (!mechanicalChest){
        System.out.println("Inside the chest their are a pair of interesting boots");
        System.out.println("You have obtained \"falling boots\n");
        mechanicalChest = true;
      }
      else{
        System.out.println("This chest is empty, as if it has already been opened");
      }
      enterZone10();
    }
    else if (input.equals("path")){
      if (energyCheck()){
        enterZone8();
      }
      else{
        mChanceZone10();
      }
    }
    else{
      ourHero.nap();
      mChanceZone10();
    }
  }
  private void enterZone11(){
    // change image
    // ADD CODE HERE
    console.setImage("bunker.jpg");
    // describe the area/situation to the user. 
    // Give them options for choices.
    // ADD CODE HERE
    System.out.println("The falling boots prevent you from falling to your death as you land safely in front of a mysterious bunker");
    System.out.println("What will you do\nenter: \tenter the bunker\nnap: \tgo to sleep\n" + hName() + ": ");
    String input = inScanner.nextLine();
    // Take action or go to another zone based on their choice
    // ADD CODE HERE
    if (input.equals("enter")){
      enterZone12();
    }
    else{
      ourHero.nap();
      mChanceZone11();
    }
  }
  private void enterZone12(){
    win = true;
    gameEnd();
  }
  private void monster(int healthBonus, int attackBonus, boolean b,String bossName){
    mName = "";
    boolean boss = b;
    if (boss){
      mName = bossName;
      mNameRand = 100000;
    }
    else{
      mNameRand = (int)(Math.random()*3+1);
    }
    if (mName.equals("Golem of the Temple")){
      console.setImage("golem.jpg");
    }
    else if (mName.equals("Humanoid Machine")){
      console.setImage("humanoid.png");
    }
    else if (mName.equals("Skeleton King")){
      console.setImage("skeleton.jpg");
    }
    Monster monster = new Monster(healthBonus,attackBonus);
    //setting monster name
    if (mNameRand == 1){
      mName = "Wolf";
      console.setImage("wolf.jpg");
    }
    else if (mNameRand == 2){
      mName = "Pumpkin";
      console.setImage("pumpkintrio.png");
    }
    else if (mNameRand == 3){
      mName = "Ghost";
      console.setImage("ghost.jpg");
    }
    //action
    if (boss){
      System.out.println("what will you do?\nYour minimum attack power is: " + hMinAttack() + "\nYour health is " + hHealth() + "\n" + mName + " attack power is: " + monster.getAttack() + "\n" + mName + " health is: " + monster.getHealth() + "\nattack: \tDeal a minimum of " + hMinAttack() +  " damage\nrun: \tYou may loose some health\n" + hName()+ ": ");
    }
    else{
      System.out.println("You have been attacked by a " + mName + ". what will you do?\nYour minimum attack power is: " + ourHero.attack + "\nYour health is " + hHealth() + "\n" + mName + " attack power is: " + monster.getAttack() + "\n" + mName + " health is: " + monster.getHealth() + "\nattack: \tDeal a minimum of " + hMinAttack() +  " damage\nrun: \tYou may loose some health\n" + hName()+ ": ");
    }
    String input = inScanner.nextLine();
    //option run
    if (input.equals("run")){
      if (boss){
        hHealthRand = (int)(Math.random()*11+90);
      }
      else{
        hHealthRand = (int)(Math.random()*20);
      }
      if (damageRed>hHealthRand){
        actDamageRed = hHealthRand;
      }
      else{
        actDamageRed = damageRed;
      }
      ourHero.setHealth(ourHero.getHealth() - hHealthRand + actDamageRed);
      System.out.println("The " + mName + " dealt " + hHealthRand + " damage while you were running away");
      System.out.println("Your health is now: " + hHealth());
      if (ourHero.getHealth()<0){
        dead = true;
      }
    }
    //option attack
    else{
      mDead = false;
      monster.attacked(hActAttack());
      System.out.println("You attacked the " + mName + " for " + hActAttack() + " damage.");
      System.out.println("The " + mName +" health is now " + monster.getHealth());
      //if monster is still alive
      if (monster.getHealth()>0){
        if (damageRed>monster.getAttack()){
          actDamageRed = hHealthRand;
        }
        else{
          actDamageRed = damageRed;
        }
        ourHero.setHealth(hHealth()-monster.getAttack() + actDamageRed);
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
        if (ourHero.getMonstersDefeated() >= mCounter+5){
          mCounter = ourHero.getMonstersDefeated();
          System.out.println("You have defeated " + ourHero.getMonstersDefeated() +"monsters. You gain +5 attack and +100 health ");
          ourHero.bonus(100,5);
        }
        if (boss){
          System.out.println("You have defeated a boss. You gain +10 attack and + 150 health");
          ourHero.bonus(150,10);
        }
        mDead = true;
      }
      if (dead == false && mDead == false){
        while (true){
          System.out.println("What would you like to do?\nYour minimum attack power is: " + hMinAttack() + "\nYour health is " + hHealth() + "\n" + mName + " attack power is: " + monster.getAttack() + "\n" + mName + " health is: " + monster.getHealth() + "\nattack: \tDeal a minimum of " + hMinAttack() +  " damage\nrun: \tYou may loose some health\n" + hName()+ ": ");
          input = inScanner.nextLine();
          //option run
          if (input.equals("run")){
            int hHealthRand = (int)(Math.random()*20);
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
            monster.attacked(hActAttack());
            System.out.println("You attacked the " + mName + " for " + hActAttack() + " damage.");
            System.out.println("The " + mName + "health is now: " + monster.getHealth());
            //if monster is still alive
            if (monster.getHealth()>0){
              if (damageRed>monster.getAttack()){
                actDamageRed = hHealthRand;
              }
              else{
                actDamageRed = damageRed;
              }
              ourHero.setHealth(hHealth()-monster.getAttack() + actDamageRed);
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
              ourHero.defeatMonster();
              if (ourHero.getMonstersDefeated() >= mCounter+5){
                mCounter = ourHero.getMonstersDefeated();
                System.out.println("You have defeated " + ourHero.getMonstersDefeated() +"monsters. You gain +5 attack and +100 health ");
                ourHero.bonus(100,5);
              }
              if (boss){
                System.out.println("You have defeated a boss. You gain +10 attack and + 100 health");
                ourHero.bonus(150,10);
              }
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
        enterZone5();
      }
    }
    else{
      enterZone5();
    }
  }
  private void mChanceZone6(){
    if (rand() ==1){
      monster(25,15,false,"");
      if (dead){
        gameEnd();
      }
      else{
        enterZone6();
      }
    }
    else{
      enterZone6();
    }

  }
  private void mChanceZone7(){
    if (rand() ==1){
      monster(25,20,false,"");
      if (dead){
        gameEnd();
      }
      else{
        enterZone7();
      }
    }
    else{
      enterZone7();
    }
  }
  private void mChanceZone8(){
    if (rand() ==1){
      monster(25,20,false,"");
      if (dead){
        gameEnd();
      }
      else{
        enterZone8();
      }
    }
    else{
      enterZone8();
    }
  }
  private void mChanceZone9(){
    if (rand() ==1){
      monster(30,20,false,"");
      if (dead){
        gameEnd();
      }
      else{
        enterZone9();
      }
    }
    else{
      enterZone9();
    }
  }
  private void mChanceZone10(){
    if (rand() ==1){
      monster(30,20,false,"");
      if (dead){
        gameEnd();
      }
      else{
        enterZone10();
      }
    }
    else{
      enterZone10();
    }
  }
  private void mChanceZone11(){
    if (rand() ==1){
      monster(30,20,false,"");
      if (dead){
        gameEnd();
      }
      else{
        enterZone11();
      }
    }
    else{
      enterZone11();
    }
  }
  private int rand(){
    return (int)(Math.random()*2);
  }
  private int hHealth(){
    return ourHero.getHealth();
  }
  private int hMinAttack(){
    return ourHero.attack;
  }
  private int hActAttack(){
    return ourHero.randAttack();
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
      System.out.println("***You must nap before traveling, Energy is too low***");
      ourHero.nap();
      return false;
    }
  }
  
  

  private void gameEnd()
  {
    // ADD CODE HERE
    if (win){
      System.out.println("You win, you've arrive at the bunker in one piece and now are safe");
      console.setImage("bunker2.jpg");
      inScanner.close();
      while (true){
        System.out.print("");
      }
    }
    else if (fallingDeath){
      System.out.println("You jumped off a building, great. Now your dead, wise decision");
      console.setImage("gameOver.jpg");
      inScanner.close();
      while(true){
        System.out.print("");
      }
    }
    else{
      System.out.println("You are dead, i guess the monsters are too scary");
      console.setImage("gameOver.jpg");
      inScanner.close();
      while(true){
        System.out.print("");
      }
    }

    
  }
}