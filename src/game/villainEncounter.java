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
/** Encounter for villain
 */
public class villainEncounter extends Encounters {

    private final GameLevel level;
    private final Game game;
    private Zombie zombie;
    private static SoundClip villainSound;

    static {
        try {
            villainSound = new SoundClip("data/sound1.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    private static SoundClip villainSound2;
    // sound for the villain
    static {
        try {
            villainSound = new SoundClip("data/sound1.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

    /** villain encounter constructor
     *
     * @param level
     * @param game
     * @param zombie
     */
    public villainEncounter(GameLevel level, Game game, Zombie zombie) {
        this.level = level;
        this.game = game;
        this.zombie = zombie;
    }

    /** collide to decrease points
     *
     * @param e
     */
    public void collide(CollisionEvent e) {
        // if you touch the villain the zombie loses a point
        if (e.getOtherBody() instanceof Villain) {
            zombie.setCredits(zombie.getCredits()- 1);
        }
    }
}