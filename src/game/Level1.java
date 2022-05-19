package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/**
 Level 1 containing everything in level 1
 */
public class Level1  extends GameLevel {
    Image background;
    String levelName;
    String levelsNames;
    private final int credits;
    public SoundClip gameMusic;
    private String name;
    /** Level 1 constuctor
     *
     * @param game
     */
    public Level1(Game game){
        super(game);
        // Sound for level 1
        try {
            gameMusic = new SoundClip("data/spiderman.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        // get the current credits for the zombie
        credits = getZombie().getCredits();
        // the current level number
        levelsNames = "1";
        // background image for level 1
        background = new ImageIcon("data/fire.png").getImage();
        getVillain().setPosition(new Vec2(1000, 335f));
        getVillain2().setPosition(new Vec2(1000,333f));
        Shape shape = new BoxShape(30, 0.5f);
        // Set the ground level 1
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.setFillColor(Color.red);
        getLevel4().setPosition(new Vec2(1000,-10f));
        // The second platform
        Shape firstPlatform = new BoxShape(6, 1);
        StaticBody grn = new StaticBody(this,firstPlatform);
        grn.setPosition(new Vec2(9f, 7.5f));
        grn.setFillColor(Color.red);
        // Set soldier position
        getSoldier().setPosition(new Vec2(9, 9f));
        // Third platform
        Shape secondPlatform = new BoxShape(6, 1);
        StaticBody grn1 = new StaticBody(this,secondPlatform);
        grn1.setPosition(new Vec2(-1f, -2.5f));
        grn1.setFillColor(Color.red);
       // Set soldier position
        getSoldier2().setPosition(new Vec2(-1f, 4f));
        //3rd platform left one
        Shape fourthPlatform = new BoxShape(4, 0.5f);
        StaticBody grn3 = new StaticBody(this,fourthPlatform);
        grn3.setPosition(new Vec2(-12f, 7.5f));
        grn3.setFillColor(Color.red);
        getZombie().setPosition(new Vec2(-10,-6));
        // Allow zombie to pick up the brains
        PickupBrain pickup = new PickupBrain(getZombie());
        getZombie().addCollisionListener(pickup);
        // Allow zombie to interact with the soldier
        SoldierCollision coll = new SoldierCollision(this,game,getZombie());
        getZombie().addCollisionListener(coll);
        //set credits to 0
        getZombie().setCredits(0);
        // Set new brain collectibles in the level
        new Brain(this).setPosition(new Vec2(-4.5f,8));
        new Brain(this).setPosition(new Vec2(6f,8f));
        new Brain(this).setPosition(new Vec2(-15.5f,9f));

        // set soldier position
        getSoldier().setPosition(new Vec2(-12f, 9f));
        // set door position
        getDoor().setPosition(new Vec2(20f, -9f));
        // allow zombie to interact with the door
        DoorEncounter encounter = new DoorEncounter(this,game);
        getZombie().addCollisionListener(encounter);
       // getZombie().getBackpack().addItem(new Pistol(getZombie()));

    }
    /** Allow the level to be complete once the zombie has more than one point*/
    @Override
    public boolean isComplete () {
        return getZombie().getCredits() > 0;
    }

    /** method for getting the level name
     */
    @Override
    public String getLevelName() {
        return "Level 1";
    }

    public SoundClip getGameMusic(){return gameMusic;}

    /** getter for the background for this level*/
    @Override
    public Image getBackground(){
        return background;
    }
    /** method for getting the level name
     */
    @Override
    public String getLevelsNames() {
        return levelsNames;
    }
}
