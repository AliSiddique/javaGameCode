package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Class for soldier enabling it to walk
 */
public class Soldier extends Characters implements ActionListener {
    private static final Shape studentShape = new PolygonShape(
            -0.14f,2.49f, 0.94f,2.54f, 2.22f,-0.84f, 0.38f,-2.53f, -0.78f,-2.33f, -2.41f,1.25f, -0.25f,2.47f);
    private float  left,right;
    private final int SPEED = 2;
    private final int RANGE = 2;
    private final String direction;
    private Zombie zombie;
    // left image for soldier
    private static final BodyImage leftImage =
            new BodyImage("data/soldier.gif", 6.2f);
    // right image for soldier
    private static final BodyImage rightImage =
            new BodyImage("data/soldier.gif", 6.2f);

    /** soldier constructor
     *
     * @param world
     */
    public Soldier(World world) {
        super(world, studentShape);
        addImage(leftImage);
        direction = "left";
        world.addStepListener(this);
        startWalking(SPEED);
        // timer for shooting
        Timer t = new Timer(5000,this);
        t.start();
    }
    // shooting method
    public void fire(){
        // initialising the projectile
        VillainProjectile projectile  = new VillainProjectile(this.getWorld());
        projectile.setPosition(this.getPosition());
        projectile.addCollisionListener(new VillainProjectileEncounter(zombie));
        // shooting depending on position
        if(direction.equals("left")){
            projectile.setPosition(new Vec2(this.getPosition().x-3, this.getPosition().y+2));
            projectile.setLinearVelocity(new Vec2(-50,4));
        } else {
            // set projectile position

            projectile.setPosition(new Vec2(this.getPosition().x+3, this.getPosition().y+2));
            projectile.setLinearVelocity(new Vec2(50,6));
        }
    }

    /** walking method from parent class
     *
     * @param stepEvent
     */
    @Override
    public void preStep(StepEvent stepEvent) {
      super.walk(leftImage,rightImage);
    }
    @Override
    public void postStep(StepEvent stepEvent) {
    }
    // after timer is fired call fire method
    @Override
    public void actionPerformed(ActionEvent e) {
        fire();
    }
}
