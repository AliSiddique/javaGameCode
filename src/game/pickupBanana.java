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
/** Pick up for banana
 */
public class pickupBanana implements CollisionListener {

    private final Zombie zombie;

    /** pick up banana constructor
     *
     * @param z
     */
    public pickupBanana(Zombie z){
        this.zombie = z;
    }
    private static SoundClip bananaSound;
    // banana pick up sound
    static {
        try {
            bananaSound = new SoundClip("data/coins.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /** Method for colliding with the banana
     *
     * @param e
     */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Banana) {
            // increase credits by 1
            zombie.setCredits(zombie.getCredits()+1);
            // start walking faster
            zombie.startWalking(15);
            bananaSound.play();
            // destroy banana
            e.getOtherBody().destroy();
            
        }
    }
}