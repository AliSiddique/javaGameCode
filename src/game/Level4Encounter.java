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
/** Encounter for the level 4 villain
 */
public class Level4Encounter extends Encounters {
    private final GameLevel level;
    private final Game game;
    private Zombie zombie;
    private static SoundClip level4Sound;
    static{
        try{
            level4Sound = new SoundClip("data/welldone.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }
    private static SoundClip villainSound2;
    static{
        try{
            level4Sound = new SoundClip("data/welldone.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    /** Level 4 constructor
     *
     * @param level
     * @param game
     */
    public  Level4Encounter(GameLevel level, Game game,Zombie zombie){
        this.level = level;
        this.game = game;
        this.zombie = zombie;
    }
    public void collide(CollisionEvent e) {
        // if the zombie interacts with level 4 villain the credits will descrease by 1
        if (e.getOtherBody() instanceof Level4Villain) {
            zombie.setCredits(zombie.getCredits()-1);
        }

    }
}
