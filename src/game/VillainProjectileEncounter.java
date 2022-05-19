package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.SoundClip;

import javax.security.auth.Destroyable;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** projectile collision class for killing the main character
 */
public class VillainProjectileEncounter extends Encounters{
    private Zombie zombie;
    private Soldier soldier;
    private Villain villain;

    public VillainProjectileEncounter(Zombie zombie){
        this.zombie = zombie;
    }

    /** Method for colliding with the banana
     *
     * @param e
     */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Zombie) {
            // destroy zombie if interacted with
           e.getOtherBody().destroy();
        }
    }
}
