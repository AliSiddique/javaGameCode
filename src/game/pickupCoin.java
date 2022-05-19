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
/** Pick up for coins
 */
public class pickupCoin extends Encounters {

    private final Zombie zombie;
    public pickupCoin(Zombie z){
        this.zombie = z;
    }
    private static SoundClip coinSound;

    static {
        try {
            coinSound = new SoundClip("data/eat.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /** Method for colliding with the banana
     *
     * @param e
     */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof coins) {
            // increment credits
            zombie.setCredits(zombie.getCredits()+1);
            // increase walking speed
            zombie.startWalking(15);
            coinSound.play();
            // destroy banana
            e.getOtherBody().destroy();
        }
    }
}