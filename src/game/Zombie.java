package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Zombie class for zombie methods and images
 */
public class Zombie extends Walker  {
    private static final Shape studentShape = new PolygonShape(
            -0.14f,2.49f, 0.94f,2.54f, 2.22f,-0.84f, 0.38f,-2.53f, -0.78f,-2.33f, -2.41f,1.25f, -0.25f,2.47f


    );
    // overlaying zombie character
    private static final BodyImage leftImage =
            new BodyImage("data/zom.png", 6.2f);
    private static final BodyImage rightImage =
            new BodyImage("data/zom.png", 6.2f);
    private static final BodyImage initial =
            new BodyImage("data/first.gif", 6.2f);
    private int credits;

    private String direction;
    private final Backpack backpack;


    /** zombie constructor
     *
     * @param world
     */
    public Zombie(World world) {
        super(world, studentShape);
        addImage(initial);
        // setAlwaysOutline(true);
        backpack =  new Backpack();
        direction = "left";
        credits = 0;

    }


    /**
     Zombie credits setter
     */
    public void setCredits(int credits){
        this.credits = credits;
    }
    /**
     Zombie credits getter which return the zombie credits
     */
    public int getCredits(){
        return credits;
    }
    /**
     Zombie start walking method which allows the zombie to walk and changes image based on direction of walking
     */

    @Override
    public void startWalking(float speed){
        super.startWalking(speed);
        if(speed < 0){
            this.removeAllImages();
            this.addImage(new BodyImage("data/zo.gif",  6));
            direction = "left";
        } else {
            this.removeAllImages();
            this.addImage(new BodyImage("data/zom.png", 6));
            direction = "right";
        }
    }

    /**
     Zombie jumping method which allows zombie to jump
     */
    public void jump(float speed){
        super.jump(speed);
    }
    /**
     Zombie shooting method which allows zombie to shoot
     */
    public void shoot(){
        // make instance of projectile class
        Projectile projectile  = new Projectile(this.getWorld());
        // set projectile position
        projectile.setPosition(this.getPosition());
        // add collision listener
        projectile.addCollisionListener(new ProjectileCollision(this));
        // if zombie is walking left make bullets go left
        if(direction.equals("left")){
            projectile.setPosition(new Vec2(this.getPosition().x-2, this.getPosition().y));
            projectile.setLinearVelocity(new Vec2(-20,4));
        } else {
            // if zombie is walking right make bullets go right
            projectile.setPosition(new Vec2(this.getPosition().x+5, this.getPosition().y));
            projectile.setLinearVelocity(new Vec2(20,3));
        }
    }
    public void shoot(Vec2 t){

    }
}

