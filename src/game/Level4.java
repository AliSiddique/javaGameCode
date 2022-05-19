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
 Level 4 containing everything in level 4
 */
public class Level4 extends GameLevel implements ActionListener {
    private final Box box;
    private Villain villain;
    Image background;
    private SoundClip gameMusic;
    private SoundClip gameSound;

    String levelsNames;
    private Level4 level4;

    /** Level 4 villain
     *
     * @param game
     */
    public Level4(Game game){
        super(game);
        try {
            gameMusic = new SoundClip("data/game.wav");   // Open an audio input stream
            gameMusic.loop();                                      // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        // level name
        levelsNames = "4";
        // background for level 4
        background = new ImageIcon("data/ground.jpeg").getImage();
        getVillain().setPosition(new Vec2(1000, 335f));
        // initialise the  box
        box = new Box(this);
        // set villain position
        getVillain().setPosition(new Vec2(29, -15f));
        // interact with villain
        villainEncounter encounters = new villainEncounter(this,game,getZombie());
        getZombie().addCollisionListener(encounters);
        getLevel4().setPosition(new Vec2(29,-10f));
        // set box position
        box.setPosition(new Vec2(11, 4 ));
        getZombie().setPosition(new Vec2(-8,-6));
        getSoldier().setPosition(new Vec2(1000f, 7f));
        getSoldier2().setPosition(new Vec2(1000f, 7f));
        getVillain2().setPosition(new Vec2(1000,333f));
        // cake encounter
        cakeEncounter another = new cakeEncounter(this,game,getZombie(),game.view,game.controller);
        getZombie().addCollisionListener(another);
        // ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.setFillColor(Color.blue);

        // encounter level 4 villain
        Level4Encounter collide = new Level4Encounter(this,game,getZombie());
        getZombie().addCollisionListener(collide);
        // set position for level 4
        getLevel4().setPosition(new Vec2(9f,10f));
        // platform 2
        Shape newShape = new BoxShape(6, 1);
        StaticBody grn = new StaticBody(this,newShape);
        grn.setPosition(new Vec2(9f, 8.5f));
        grn.setFillColor(Color.blue);
        // balls for level 4
        new Balls(this).setPosition(new Vec2(-4.5f,8));
        new Balls(this).setPosition(new Vec2(9f,10f));
        new Balls(this).setPosition(new Vec2(-15.5f,9f));
        getZombie().setPosition(new Vec2(-4,-6));
        // allow interaction with ball
        pickupBall pickup = new pickupBall(getZombie());
        getZombie().addCollisionListener(pickup);
        SoldierCollision coll = new SoldierCollision(this,game,getZombie());
        getZombie().addCollisionListener(coll);
        // set door position
        getDoor().setPosition(new Vec2(17f, -9f));
        // allow character to interact with the door
        DoorEncounter encounter = new DoorEncounter(this,game);
        getZombie().addCollisionListener(encounter);
        getZombie().setCredits(0);
        //getZombie().getBackpack().addItem(new Pistol(getZombie()));
        // timer for spawning cakes
        Timer t = new Timer(5000,this);
        t.start();
    }

    /** is complete method for level 4
     */
    @Override
    public boolean isComplete () {
        return getZombie().getCredits() > 0;
    }
    /** action perform method for cakes*/
    public void actionPerformed(ActionEvent e) {
        System.out.println("HIT! ");
        Cake x = new Cake(this);
        Cake y = new Cake(this);
        x.setPosition(new Vec2(-4, 10f));
        y.setPosition(new Vec2(-7, 10f));
        // play music when cake appears
        try {
            gameSound = new SoundClip("data/eat.wav");
            gameSound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException a) {
            System.out.println(e);
        }
    }

    /** get level name*/
    @Override
    public String getLevelName() {
        return "Level 4";
    }
    /** get background */
    @Override
    public Image getBackground() {
        return background;
    }
    /** get music name*/

    public SoundClip getGameMusic(){return gameMusic;}
    /** get level name*/

    @Override
    public String getLevelsNames() {
        return levelsNames;
    }



}
