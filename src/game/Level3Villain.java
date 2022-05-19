package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */

/** level 3 villain class containing all related method to the villain
 *
 */
public class Level3Villain extends Characters {
    private float  left,right;
    private final int SPEED = 2;
    private final int RANGE = 6;
    private final String direction;
    private static final Shape villainShape = new PolygonShape(
            -0.14f,2.49f, 0.94f,2.54f, 2.22f,-0.84f, 0.38f,-2.53f, -0.78f,-2.33f, -2.41f,1.25f, -0.25f,2.47f);
    private static final BodyImage leftImage =
            new BodyImage("data/badguy.png", 6f);

    private static final BodyImage rightImage =
            new BodyImage("data/badguy.png", 6f);


    /** Level 3 villain constructor
     *
     * @param world
     */
    public Level3Villain(World world) {
        super(world, villainShape);
        addImage(leftImage);
        // set initial direction to left
        direction = "left";
        world.addStepListener(this);
        startWalking(SPEED);
    }

    /** Setting position for the level 3 villains
     *
     * @param position
     */
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

    /** making level 3 villain walk  back and forth
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
}
