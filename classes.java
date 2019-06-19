   
public class classes{
    static driver dr = new driver();
 public static void buildGod() {
        dr.charclass = "warrior";
        dr.maxhp = 20;
        dr.playerhp = 20;
        dr.playermeleedmg = 4;
        dr.xp = 0;
        dr.Level = 1; 
    }

    public static void buildRifleMan() {
        dr.charclass = "RifleMan";
        dr.maxhp = 5;
        dr.playerhp = 5;
        dr.playermeleedmg = 200;
        dr.xp = 0;
        dr.Level = 1; 
        dr.incammo = 3;
        dr.stunammo = 3;
    }

    public static void buildWarrior() {
        dr.charclass = "warrior";
        dr.maxhp = 20;
        dr.playerhp = 20;
        dr.playermeleedmg = 4;
        dr.xp = 0;
        dr.Level = 1; 
    }

    public static void buildArcher() {
        dr.charclass = "archer";
        dr.maxhp = 14;
        dr.playerhp = 14;
        dr.playermeleedmg = 6;
        dr.xp = 0;
        dr.Level = 1;
    }

    public static void buildgod() {
        dr.charclass = "god";
        dr.maxhp = 999999999;
        dr.playerhp = 999999999;
        dr.mana = 999999999;
        dr.maxmana = 999999999;
        dr.playermeleedmg = 9999999;
        dr.xp = 0;
        dr.Level = 1; // initializes globals according to class
    }
}