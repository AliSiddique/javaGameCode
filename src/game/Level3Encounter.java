package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Encounter for the level 3 villain
 */
public class Level3Encounter extends Encounters {

    private final GameLevel level;
    private Zombie zombie;
    private final Game game;
    private static SoundClip level3Sound;
    static{
        try{
            level3Sound = new SoundClip("data/jumping.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }
    private static SoundClip villainSound2;
    static{
        try{
            level3Sound = new SoundClip("data/jumping.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    /** Level 3 encounter constructor
     *
     * @param level
     * @param game
     */
    public  Level3Encounter(GameLevel level, Game game,Zombie zombie){
        this.level = level;
        this.game = game;
        this.zombie = zombie;
    }

    /** Method for colliding with the level 3 villains
     *
     * @param e
     */
    public void collide(CollisionEvent e) {
        // if the zombie interacts with level 3 villain the credits will descrease by 1
        if (e.getOtherBody() instanceof Level3Villain) {
            zombie.setCredits(zombie.getCredits()-1);
        }
    }
}

