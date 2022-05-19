package game;
import city.cs.engine.*;


import java.awt.*;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/**
 GameLevel class which is the basis of all the other level
 */
public abstract class GameLevel extends World {
    // Allow variables to be used in any funtion
    private static Zombie zombie;
    private final Soldier soldier;
    private Zombie credits;
    private final Villain villain;
    public SoundClip gameMusic;
    private Level3Villain level3;
    private final Level4Villain level4;
    private final Soldier soldier2;
    private final Door door;
    private final Villain villain2;

    /** GameLevel constructor
     *
     * @param game
     */
    public GameLevel(Game game) {
        // Initialising the zombie
        zombie = new Zombie(this);
        // Initialising the soldier
        soldier = new Soldier(this);
        // Initialising the second soldier
        soldier2 = new Soldier(this);
        // Initialising the villain
        villain = new Villain(this);
        // Initialising the second villain
        villain2 = new Villain(this);
        // Initialising the level 4 villain
        level4 = new Level4Villain(this);
        // Initialising the soldier collision
        SoldierCollision encounter = new SoldierCollision(this, game,getZombie());
        zombie.addCollisionListener(encounter);
        //allow villain bullets to interact with zombie
        VillainProjectileEncounter en = new VillainProjectileEncounter(getZombie());
        zombie.addCollisionListener(en);
        // initialise new door
        door = new Door(this);
    }
    /**
     Zombie getter which returns the zombie
     */
    public Zombie getZombie(){
        return zombie;
    }
    /**
     Soldier getter which returns the soldier
     */
    public Soldier getSoldier() {return soldier;}
    /**
     Soldier2 getter which returns the soldier2
     */
    public Soldier getSoldier2() {return soldier2;}
    /**
     Zombie credits getter which returns the amount of zombie credits
     */
    public Zombie getCredits(){return credits;}
    /**
     Villain getter which returns the villain
     */
    public Villain getVillain(){return villain; }
    /**
     Villain2 getter which returns the zombie
     */
    public Villain getVillain2(){return villain2; }
    /**
     Level4 villain getter which return the level4 villain
     */
    public Level4Villain getLevel4(){return level4; }
    /**
     Door method for return the door
     */
    public Door getDoor(){
        return door;
    }

    /** Method which checks if the game is complete method
     */
    public abstract boolean isComplete();

    /** Gets current level name
     */
    public abstract String getLevelName();

    /** Get each level background
     */
    public abstract  Image getBackground();
    /**
     Gets current level number
     */
    public abstract String getLevelsNames();

}
