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
 Level 2 containing everything in level 2
 */
public class Level2 extends GameLevel implements ActionListener {
    private final Box box;
    private Villain villain;
    Image background;
    String levelsNames;
    private Level3Villain level3;
    private final int credits;
    private SoundClip gameMusic;
    private SoundClip gameSound;


    /** Level 2 constructor
     *
     * @param game
     */
    public Level2(Game game){
        super(game);
        try {
            gameMusic = new SoundClip("data/game.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        //Set new credits for the current level
        credits =  getZombie().getCredits();
        levelsNames = "2";
        // New background for level 2
        background = new ImageIcon("data/stock.jpeg").getImage();
        // Initialising the box
        box = new Box(this);
        // Set villain position in level
        getVillain().setPosition(new Vec2(9f, 11.5f));
        // Allow zombie to interact with the villain
        villainEncounter encounters = new villainEncounter(this,game,getZombie());
        getZombie().addCollisionListener(encounters);
        // Set box position
        box.setPosition(new Vec2(11, 4 ));
        getLevel4().setPosition(new Vec2(1000,-10f));
        getVillain2().setPosition(new Vec2(-4.5f,10f));
        // Allow zombie to interact with cake
        cakeEncounter something = new cakeEncounter(this,game,getZombie(),game.view,game.controller);
        getZombie().addCollisionListener(something);
        // ground for level 2
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.setFillColor(Color.GREEN);

        //top platform
        Shape newShape = new BoxShape(6, 1);
        StaticBody grn = new StaticBody(this,newShape);
        grn.setPosition(new Vec2(9f, 10.5f));
        grn.setFillColor(Color.GREEN);
        getSoldier().setPosition(new Vec2(1000f, 7f));
        getSoldier2().setPosition(new Vec2(1000f, 7f));
        // set coins in the level
        new coins(this).setPosition(new Vec2(-4.5f,8));
        new coins(this).setPosition(new Vec2(6f,8f));
        new coins(this).setPosition(new Vec2(-15.5f,9f));
        // set zombie position
        getZombie().setPosition(new Vec2(-12f,-6));
        // allow zombie to pickup coins
        pickupCoin pickup = new pickupCoin(getZombie());
        getZombie().addCollisionListener(pickup);
        // allow collisions with the zombie
        SoldierCollision coll = new SoldierCollision(this,game,getZombie());
        getZombie().addCollisionListener(coll);
        // set credits to 0
        getZombie().setCredits(0);
        // set door position
        getDoor().setPosition(new Vec2(17f, -9f));
        // allow interaction with door
        DoorEncounter encounter = new DoorEncounter(this,game);
        getZombie().addCollisionListener(encounter);
       // getZombie().getBackpack().addItem(new Pistol(getZombie()));
        // timer to spawn coins
        Timer t = new Timer(5000,this);
        t.start();

    }

    /** is complete method for the level2
     *
     * @return
     */
    @Override
    public boolean isComplete () {
        return getZombie().getCredits() > 0;
    }
    // New coin is dropped after the timer has counted
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("1 more point ");
        coins c = new coins(this);
        c.setPosition(new Vec2(7, -1f));
        try {
            gameSound = new SoundClip("data/eat.wav");
            gameSound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
            System.out.println(e);
        }
    }
    /** get level name */
    @Override
    public String getLevelName() {
        return "Level 2";
    }
    /** get background  */
    @Override
    public Image getBackground() {
        return background;
    }
    /** get music  */
    public SoundClip getGameMusic(){return gameMusic;}
    /** get level name */
    @Override
    public String getLevelsNames() {
        return levelsNames;
    }

}
