package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/**
 Villain class for adding image and walking on its own
 */
public class Villain extends Characters {
    private  float  left;
    private  float right;
    private  final int SPEED = 2;
    private final int RANGE = 3;
    private final String direction;
    // the shape of the villain
    private static final Shape villainShape = new PolygonShape(
            -0.14f,2.49f, 0.94f,2.54f, 2.22f,-0.84f, 0.38f,-2.53f, -0.78f,-2.33f, -2.41f,1.25f, -0.25f,2.47f);
    private static final BodyImage leftImage =
            new BodyImage("data/wierd.png", 6f);
    private static final BodyImage rightImage =
            new BodyImage("data/wierd.png", 6f);
    // villain constructor
    public Villain(World world) {
        // calling parent class
        super(world,villainShape);
        // add image
        addImage(leftImage);
        direction = "left";
        world.addStepListener(this);
        // start walking
        startWalking(SPEED);
    }

    public void preStep(StepEvent stepEvent) {
     super.walk(leftImage,rightImage);
    }

    public void postStep(StepEvent stepEvent) {

    }
}
