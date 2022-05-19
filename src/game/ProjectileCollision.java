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
/** projectile collision class for interacting with the projectile
 */
public class ProjectileCollision implements CollisionListener {
    private Zombie zombie;
    private Soldier soldier;
    private Villain villain;

    private Projectile projectile;
    public ProjectileCollision(Zombie z){
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
    @Override
    public void collide(CollisionEvent e) {
        // if interaction with soldier kill soldier
        if (e.getOtherBody() instanceof Soldier) {
            e.getOtherBody().destroy();
            // if interaction with villain kill villain
        } else if(e.getOtherBody() instanceof Villain){
            e.getOtherBody().destroy();
            // if interaction with level 3 villain kill level 3 villain
        } else if(e.getOtherBody() instanceof Level3Villain){
            e.getOtherBody().destroy();
        // if interaction with level 4 villain kill level 4 villain
        } else if(e.getOtherBody() instanceof Level4Villain){
            e.getOtherBody().destroy();
        }
    }
}
