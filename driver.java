import java.util.*;

/**
 * 
 */
public class driver
{
    protected static classes cl =  new  classes();
    protected static Scanner scan =  new  Scanner(System.in);
    protected static Random rand =  new  Random();
    protected static dice die =  new  dice();
    public static String playerName;
    public static int playerhp;
    public static int maxhp;
    public static int maxmana;
    public static int mana;
    public static int playermeleedmg;
    public static int xp;
    public static int enemyhp;
    public static int enemymeleedmg;
    public static int Level;
    public static String charclass;
    public static boolean fighting = false;
    /* globals for player stats & enemy stats*/
    public static int stunned;
    public static int incammo;
    public static int stunammo;
    public static int onfire;

    /**
     * 
     */
    static private void printStats()
    {
        if (charclass.equals("god")) {
            System.out.println(playerName + "\nhp: " + playerhp + "\nmana: " + mana + "\ndamage: " + playermeleedmg + "\nxp: " + xp + "\n");
        }
        else if (charclass.equals("RifleMan")) {
            System.out.println(playerName + "\nhp: " + playerhp + "\ndamage: " + playermeleedmg + "\nxp: " + xp + "\nIncinidiary ammo" + incammo + "\nStun ammo" + stunammo);
        }
        else {
            System.out.println(playerName + "\nhp: " + playerhp + "\ndamage: " + playermeleedmg + "\nxp: " + xp + "\n");
        }
    }

    /**
     * 
     */
    static private void printEnemyStats()
    {
        System.out.println("Enemy " + "\nhp: " + enemyhp + "\ndmg: " + enemymeleedmg + "\n");
    }

    /**
     * 
     */
    static private void buildEnemy()
    {
        switch (Level) {
            case 1 : {
                enemyhp = 9;
                enemymeleedmg = 1;
                break;
            }
            case 2 : {
                enemyhp = 19;
                enemymeleedmg = 4;
                break;
            }
            case 3 : {
                enemyhp = 24;
                enemymeleedmg = 6;
                break;
            }
            case 4 : {
                enemyhp = 32;
                enemymeleedmg = 7;
                break;
            }
            case 5 : {
                enemyhp = 99999;
                enemymeleedmg = 9;
                break;
                /* initializes enemy stats based on player level*/
            }
        }
    }

    /**
     * 
     */
    static private void fight()
    {
        String action;
        String spellAction = null;
        String bulletAction = null;
        Random rand =  new  Random();
        int n = rand.nextInt(11);
        if (n == 7) {
            System.out.println("A boss aproaches!");
        }
        else {
            System.out.println("An enemy approaches");
        }
        buildEnemy();
        fighting = true;
        /* Unsupported feature in Stride : = in expression*/
        while (fighting = true) {
            System.out.println("Press 'a' to attack\nPress 'i' for info");
            if (charclass.equals("god")) {
                System.out.print("Press 's' for spells\n");
            }
            else if (charclass.equals("RifleMan")) {
                System.out.print("Press 'b' for special bullets\n");
            }
            action = scan.nextLine();
            if (action.charAt(0) == 'a') {
                fighting = attack();
                if (fighting == false) {
                    switch (Level) {
                        case 1 : {
                            xp = xp + 4;
                            break;
                        }
                        case 2 : {
                            xp = xp + 6;
                            break;
                        }
                        case 3 : {
                            xp = xp + 9;
                            break;
                        }
                        case 4 : {
                            xp = xp + 12;
                            break;
                        }
                    }
                    System.out.println("You earned :" + xp + " xp");
                    checkLevelUp();
                    return;
                }
                enemyattack();
            }
            if (action.charAt(0) == 'i') {
                printStats();
                printEnemyStats();
            }
            if (action.charAt(0) == 'b') {
                System.out.println("Press 'k' for incindeary ammo\nPress 'h' for Stun bullet");
                bulletAction = scan.nextLine();
                if (bulletAction.charAt(0) == 'k' || bulletAction.charAt(0) == 'h') {
                    if (bulletAction.charAt(0) == 'k') {
                        if (incammo > 0) {
                            incammo = incammo - 1;
                            System.out.println("You blew him up and did a ton of damage");
                            if (die.roll10() > 2) {
                                enemyhp = enemyhp - 100;
                            }
                            else {
                                enemyhp = enemyhp - 200;
                            }
                            if (enemyhp <= 0) {
                                System.out.println("You Won!");
                                switch (Level) {
                                    case 1 : {
                                        xp = xp + 4;
                                        break;
                                    }
                                    case 2 : {
                                        xp = xp + 6;
                                        break;
                                    }
                                    case 3 : {
                                        xp = xp + 9;
                                        break;
                                    }
                                    case 4 : {
                                        xp = xp + 12;
                                        break;
                                    }
                                }
                                System.out.println("You earned :" + xp + " xp");
                                checkLevelUp();
                                return;
                            }
                            enemyattack();
                        }
                        else {
                            System.out.println("You miss!");
                            enemyattack();
                        }
                    }
                    else {
                        System.out.println("Not enough incendiary ammo!");
                    }
                }
                else if (bulletAction.charAt(0) == 'h') {
                    if (stunammo > 0) {
                        stunammo = stunammo - 1;
                        System.out.println("hes stunned");
                        int k = die.roll10() + 20;
                        /* randomly hurts 1-10*/
                        stunned = die.roll2();
                        /* 1-2 turns stunned bruh*/
                        System.out.println("You hit for " + k + " of shocking damage, and shocked the enemy for " + stunned + " turns");
                        enemyhp = enemyhp - k;
                        if (enemyhp <= 0) {
                            System.out.println("You Won!");
                            switch (Level) {
                                case 1 : {
                                    xp = xp + 4;
                                    break;
                                }
                                case 2 : {
                                    xp = xp + 6;
                                    break;
                                }
                                case 3 : {
                                    xp = xp + 9;
                                    break;
                                }
                                case 4 : {
                                    xp = xp + 12;
                                    break;
                                }
                            }
                            System.out.println("You earned :" + xp + " xp");
                            checkLevelUp();
                            return;
                        }
                        enemyattack();
                    }
                    else {
                        System.out.println("You miss!");
                        enemyattack();
                    }
                }
                else {
                    System.out.println("Not enough stun ammo!");
                }
                if (action.charAt(0) == 's') {
                    System.out.println("Press 'p' for Hell Fire special god class ability\nPress 'h' to heal\nPress 'l' for lightning\n");
                    spellAction = scan.nextLine();
                    if (spellAction.charAt(0) == 'p' || spellAction.charAt(0) == 'l') {
                        if (die.roll10() > 2) {
                            mana = mana - 10;
                            if (mana < 0) {
                                System.out.println("You don't have enough mana...");
                                mana = mana + 10;
                            }
                            else {
                                int k = die.roll10();
                                /* randomly hurts 1-10*/
                                if (spellAction.charAt(0) == 'l') {
                                    System.out.println("You hit for 9999999 damage and also because it is lightning you do " + k + " of shocking extra damage, so in total " + 9999999 + k + " total damage.");
                                }
                                enemyhp = enemyhp - k - 9999999;
                            }
                        }
                        else if (spellAction.charAt(0) == 'h') {
                            mana = mana - 8;
                            if (mana < 0) {
                                System.out.println("You don't have enough mana...");
                                mana = mana + 8;
                            }
                            else {
                                int x = die.roll10();
                                /* randomly heals 1-8*/
                                System.out.println("You heal your wounds...");
                                System.out.println("+ " + x + 999999999 + " hp");
                                playerhp = playerhp + x + 999999999;
                                if (playerhp > maxhp) {
                                    playerhp = maxhp;
                                }
                                enemyattack();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     */
    static private void checkLevelUp()
    {
        if (xp >= 100 && Level == 4) {
            System.out.println("Level 5!");
            Level = Level + 1;
            maxhp = maxhp * maxhp;
            playerhp = maxhp;
            if (charclass.equals("god")) {
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 3;
            printStats();
        }
        else if (xp >= 50 && Level == 3) {
            System.out.println("Level 4!");
            Level = Level + 1;
            maxhp = maxhp + 20;
            playerhp = maxhp;
            if (charclass.equals("god")) {
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 2;
            printStats();
        }
        else if (xp >= 25 && Level == 2) {
            System.out.println("Level 3!");
            Level = Level + 1;
            maxhp = maxhp + 10;
            playerhp = maxhp;
            if (charclass.equals("god")) {
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 2;
            printStats();
        }
        else if (xp >= 10 && Level == 1) {
            System.out.println("Level 2!");
            Level = Level + 1;
            maxhp = maxhp + 5;
            playerhp = maxhp;
            if (charclass.equals("god")) {
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playermeleedmg = playermeleedmg + 1;
            printStats();
        }
        /* increments player level and adds to stats with xp*/
    }

    /**
     * 
     */
    static private void enemyattack()
    {
        boolean stun = false;
        if (stunned > 0) {
            stunned = stunned - 1;
            stun = true;
        }
        if (die.roll6() > 2 && stun == false) {
            System.out.println("Enemy hits!");
            playerhp = playerhp - enemymeleedmg;
            if (playerhp <= 0) {
                gameover();
                System.exit(0);
                /* game over if player health < 0*/
            }
        }
        else {
            System.out.println("Enemy Misses!");
        }
    }

    /**
     * 
     */
    static private boolean attack()
    {
        if (die.roll6() > 2) {
            System.out.println("You hit!");
            enemyhp = enemyhp - playermeleedmg;
            if (enemyhp <= 0) {
                System.out.println("You Won!");
                /* prints if enemy health < 0*/
                return false;
            }
        }
        else {
            System.out.println("You miss!");
        }
        return true;
    }

    /**
     * 
     */
    static private void gameover()
    {
        System.out.println(playerName + " Died!");
        System.out.println("GAME OVER!");
        System.exit(0);
        /* terminates if lost*/
        return;
    }

    /**
     * 
     */
    static public void main(String[] args)
    {
        String charclass;
        int num = 2;
        while (num > 1) {
            System.out.println("Enter your Name: ");
            playerName = scan.nextLine();
            System.out.println("Choose your class: ");
            System.out.println("'w' for Warrior (just your average old warrior)");
            System.out.println("'a' for Archer (i mean he's got a bow so.....)");
            System.out.println("'m' for Rifleman (has big bullets)");
            System.out.println("'g' for God (i mean do i really need a description literally god?");
            charclass = scan.nextLine();
            while (charclass.charAt(0) != 'w' && charclass.charAt(0) != 'a' && charclass.charAt(0) != 'g' && charclass.charAt(0) != 'm') {
                System.out.println("Choose your class: ");
                System.out.println("'w' for Warrior (just your average old warrior)");
                System.out.println("'a' for Archer (i mean he's got a bow so.....)");
                System.out.println("'m' for Rifleman (has big bullets)");
                System.out.println("'g' for God (i mean do i really need a description, literally god?");
                charclass = scan.nextLine();
            }
            if (charclass.charAt(0) == 'w') {
                cl.buildWarrior();
            }
            if (charclass.charAt(0) == 'a') {
                cl.buildArcher();
            }
            if (charclass.charAt(0) == 'm') {
                cl.buildRifleMan();
            }
            if (charclass.charAt(0) == 'g') {
                cl.buildgod();
            }
            printStats();
            while (Level == 1) {
                fight();
            }
            System.out.println("This area is clear... time to move on\n");
            while (Level == 2) {
                fight();
            }
            System.out.println("This area is clear... time to move on\n");
            while (Level == 3) {
                fight();
            }
            System.out.println("This area is clear... time to move on\n");
            while (Level == 4) {
                fight();
            }
            System.out.println("This area is clear... time to move on\n");
            while (Level == 5) {
                fight();
            }
        }
    }
}
