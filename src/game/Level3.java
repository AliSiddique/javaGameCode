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
 Level 3 containing everything in level 3
 */
public class Level3 extends GameLevel implements ActionListener {
    private SoundClip gameMusic;
    private SoundClip gameSound;

    Image background;
    String levelsNames;
    private final Level3Villain level3;
    private Level4Villain level4;

    /** Level 3 constructor
     *
     * @param game
     */
    public Level3(Game game){
        //the base class will create the student, professor
        super(game);
        try {
            gameMusic = new SoundClip("data/spiderman.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
        // set level 3 villain
        level3 = new Level3Villain(this);
        level3.setPosition(new Vec2(-3f,7f));
        // set level 3 name
        levelsNames = "3";
        // set background image to the level
        background = new ImageIcon("data/cool.jpeg").getImage();
        // set zombie position
        getZombie().setPosition(new Vec2(-4,-6));
        getVillain().setPosition(new Vec2(1000, 335f));
        getSoldier().setPosition(new Vec2(1000f, 7f));
        getSoldier2().setPosition(new Vec2(1000f, 7f));
        // ground for level
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        getLevel4().setPosition(new Vec2(1000,-10f));
        ground.setFillColor(Color.red);

        // platform 1
        Shape newShape = new BoxShape(6, 1);
        StaticBody grn = new StaticBody(this,newShape);
        grn.setPosition(new Vec2(9f, 7.5f));
        grn.setFillColor(Color.magenta);
        // platform 2
        Shape firstGround = new BoxShape(6, 1);
        StaticBody grn1 = new StaticBody(this,firstGround);
        grn1.setPosition(new Vec2(-1f, -2.5f));
        grn1.setFillColor(Color.magenta);
        //3rd platform left
        Shape thirdGrn = new BoxShape(4, 0.5f);
        StaticBody grn3 = new StaticBody(this,thirdGrn);
        grn3.setPosition(new Vec2(-12f, 7.5f));
        grn3.setFillColor(Color.magenta);
        // allowing interaction with the x
        xEncounter something = new xEncounter(this,game,getZombie(),game.view,game.controller);
        getZombie().addCollisionListener(something);
        // set zombie for position
        getZombie().setPosition(new Vec2(-4,-6));
        // allow banana pickup
        pickupBanana pickup = new pickupBanana(getZombie());
        getZombie().addCollisionListener(pickup);
        SoldierCollision coll = new SoldierCollision(this,game,getZombie());
        getZombie().addCollisionListener(coll);
        getVillain2().setPosition(new Vec2(1000,333f));
        // set door position
        getDoor().setPosition(new Vec2(17f, -9f));
        // allow encounter with door
        DoorEncounter encounter = new DoorEncounter(this,game);
        getZombie().addCollisionListener(encounter);
        // zombie credits to 0
        getZombie().setCredits(0);
        // banana in the level
        new Banana(this).setPosition(new Vec2(-4.5f,8));
        new Banana(this).setPosition(new Vec2(6f,8f));
        new Banana(this).setPosition(new Vec2(-15.5f,9f));
        // allow collision with level 3 villain
        Level3Encounter collide = new Level3Encounter(this,game,getZombie());
        getZombie().addCollisionListener(collide);
       // getZombie().getBackpack().addItem(new Pistol(getZombie()));
        // time to spawn x
        Timer t = new Timer(5000,this);
        t.start();
    }

    /** is complete method
     */
    @Override
    public boolean isComplete () {
        return getZombie().getCredits() > 0;
    }
    /** get level name */
    @Override
    public String getLevelName() {
        return "Level 3";
    }
    /** get background for the level*/
    @Override
    public Image getBackground() {
        return background;
    }
    /** get level name */
    @Override
    public String getLevelsNames() {
        return levelsNames;
    }
    /** get music  */
    public SoundClip getGameMusic(){return gameMusic;}

    /** action perform method for Xs*/
    public void actionPerformed(ActionEvent e) {
        System.out.println("HIT! ");
        x x = new x(this);
        x y = new x(this);
        x.setPosition(new Vec2(7, 10f));
        y.setPosition(new Vec2(-7, 10f));
        // play music every time the x appears
        try {
            gameSound = new SoundClip("data/eat.wav");
            gameSound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
            System.out.println(e);
        }
    }
}


