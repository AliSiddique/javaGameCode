package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Encounter with X
 */
public class xEncounter extends Encounters {
    private GameLevel level;
    private final Zombie zombie;
    private final Game game;
    private final GameView view;
    private final ZombieController controller;
    private static SoundClip xSound;
    static{
        try{
            xSound = new SoundClip("data/sound1.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }
    private static SoundClip villainSound2;


    /** x encounter constructor
     *
     * @param level
     * @param game
     * @param zombie
     * @param view
     * @param controller
     */
    public xEncounter(GameLevel level, Game game, Zombie zombie, GameView view, ZombieController controller){
        this.level = level;
        this.game = game;
        this.zombie= zombie;
        this.view = view;
        this.controller = controller;
    }
    /** Method for colliding with the banana
     *
     * @param e
     */
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() instanceof x){
            // play x sound
            xSound.play();
            // decrease points by 1
            zombie.setCredits(zombie.getCredits()-1);
            // destroy x
            e.getOtherBody().destroy();
            // show message
            JOptionPane.showMessageDialog(null,"You have been hit my a Landmine!");
            if(level instanceof Level1){
                // stop current level
                level.stop();
                view.setZoom(12);
                // start the current level again
                level = new Level1(game);
                view.setWorld(level);
                //start the simulation in the new level
                controller.updateZombie(level.getZombie());
                level.start();
            }
            else  if (level instanceof Level2){
                level.stop();
                view.setZoom(12);
                level = new Level2(game);
                view.setWorld(level);
                //start the simulation in the new level
                controller.updateZombie(level.getZombie());
                level.start();

            }
            else  if (level instanceof Level3){
                level.stop();
                view.setZoom(12);
                level = new Level3(game);
                view.setWorld(level);
                //start the simulation in the new level
                controller.updateZombie(level.getZombie());
                level.start();
            }
            else if (level instanceof Level4){
                level.stop();
                view.setZoom(12);
                level = new Level4(game);
                view.setWorld(level);
                //start the simulation in the new level
                controller.updateZombie(level.getZombie());
                level.start();
            }

            zombie.destroy();
        }
    }
}