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

/** encounter class for interacting with the cake
 *
 */
public class cakeEncounter extends Encounters {
    // game level field
    private GameLevel level;
    // zombie field
    private final Zombie zombie;
    // game field
    private final Game game;
    // game view field
    private final GameView view;
    // zombie controller field
    private final ZombieController controller;
    private static SoundClip cakeSound;
    // sound for the cake

    static{
        try{
            cakeSound = new SoundClip("data/coins.wav");
            cakeSound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    /** Cake encounter constructor
     *
     * @param level
     * @param game
     * @param zombie
     * @param view
     * @param controller
     */
    public  cakeEncounter(GameLevel level, Game game,Zombie zombie,GameView view,ZombieController controller){
        this.level = level;
        this.game = game;
        this.zombie= zombie;
        this.view = view;
        this.controller = controller;
    }

    /** Method for colliding with the cake
     *
     * @param e
     */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Cake){
            // play sound for interacting with the cake
            cakeSound.play();
            zombie.setCredits(zombie.getCredits()-1);
            e.getOtherBody().destroy();
            // show message that you have been hit with cake
            JOptionPane.showMessageDialog(null,"You have been hit by a Cake, \n you have to start over");
            if(level instanceof Level1){
                level.stop();
              //  view.setZoom(12);
                level = new Level1(game);
                view.setWorld(level);
                //start the simulation in the new level
                controller.updateZombie(level.getZombie());
                level.start();
            }
            else  if (level instanceof Level2){
                level.stop();
              //  view.setZoom(12);
                level = new Level2(game);
                view.setWorld(level);
                //start the simulation in the new level
                controller.updateZombie(level.getZombie());
                level.start();

            }
            else  if (level instanceof Level3){
                level.stop();
              //  view.setZoom(12);
                level = new Level3(game);
                view.setWorld(level);
                //start the simulation in the new level
                controller.updateZombie(level.getZombie());
                level.start();
            }
            else if (level instanceof Level4){
                level.stop();
               // view.setZoom(12);
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