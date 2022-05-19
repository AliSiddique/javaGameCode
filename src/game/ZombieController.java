package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Zombie controller for allowing keys to move the zombie
 */
public class ZombieController implements KeyListener {

    private static final float WALKING_SPEED = 4;
    private final HashMap<Body, BodyImage> hiddenImages = null;
    private static final float WALK = 7;
    Zombie zombieField;
    private final Game game;
    private SoundClip gameMusic;

    /** zombie controller constructor
     *
     * @param zombieParam
     * @param game
     */
    public ZombieController(Zombie zombieParam,Game game) {
        zombieField = zombieParam;
        this.game=game;
    }
    // depending on the key presses call a function
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            zombieField.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT) {
            zombieField.startWalking(WALKING_SPEED);
        } else if(code == KeyEvent.VK_Q){
            zombieField.shoot();
        }
        else if(code == KeyEvent.VK_W){
            //zombieField.getBackpack().getCurrentItem().operate();
        }
        else if(code == KeyEvent.VK_UP){
            zombieField.jump(20);
        }
        else if(code == KeyEvent.VK_D){
            zombieField.startWalking(WALKING_SPEED+6);
        } else if(code == KeyEvent.VK_0){
        } else if(code == KeyEvent.VK_E){
            game.toggleMenu();
        } else if(code == KeyEvent.VK_A){
            zombieField.startWalking(-10);}
    }
    // if key is released stop function
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            zombieField.stopWalking();
            // remove image
            zombieField.removeAllImages();
            // add another image
            zombieField.addImage(new BodyImage("data/left.png",  6));
            zombieField.setLinearVelocity(new Vec2(0f,0f));

        } else if (code == KeyEvent.VK_RIGHT) {
            zombieField.stopWalking();
            zombieField.removeAllImages();
            zombieField.addImage(new BodyImage("data/first.gif",  6));
            zombieField.setLinearVelocity(new Vec2(0f,0f));
        }
        else if(code == KeyEvent.VK_A){
            zombieField.stopWalking();
        }
        else if(code == KeyEvent.VK_B){
            zombieField.stopWalking();
        }  else if(code == KeyEvent.VK_D){
            zombieField.stopWalking();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void updateZombie(Zombie zombie){
        this.zombieField = zombie;
    }


}