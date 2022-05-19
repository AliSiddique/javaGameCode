package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Pick up for brains
 */
public class PickupBrain extends Encounters {

    private final Zombie zombie;
    public PickupBrain(Zombie z){
        this.zombie = z;
    }
    private static SoundClip brainSound;

    static {
        try {
            brainSound = new SoundClip("data/sound1.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /** Method for colliding with the banana
     *
     * @param e
     */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Brain) {
            // increment credits
            zombie.setCredits(zombie.getCredits()+1);
            // increase walking speed
            zombie.startWalking(15);
            brainSound.play();
            // destroy banana
            e.getOtherBody().destroy();
        }
    }
}