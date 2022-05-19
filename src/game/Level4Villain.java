package game;

import city.cs.engine.*;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Level 4 villain class
 */
public class Level4Villain extends Characters {
    private float  left,right;
    private final int SPEED = 2;
    private final int RANGE = 6;
    private final String direction;
    // shape of the villain
    private static final Shape villainShape = new PolygonShape(
            -0.14f,2.49f, 0.94f,2.54f, 2.22f,-0.84f, 0.38f,-2.53f, -0.78f,-2.33f, -2.41f,1.25f, -0.25f,2.47f);
    private static final BodyImage leftImage =
            new BodyImage("data/kicking.png", 6f);

    private static final BodyImage rightImage =
            new BodyImage("data/kickingRight.png", 6f);
    /** Level 4 villain constructor
     *
     * @param world
     */
    public Level4Villain(World world) {
        super(world, villainShape);
        addImage(leftImage);
        // initialises direction to left
        direction = "left";
        world.addStepListener(this);
        startWalking(SPEED);
    }

    /** Setting position for the level 4 villain
     *
     * @param position
     */


    /** Making level 4 villain walk back and forth
     *
     * @param stepEvent
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        // calls parent class and passes in images as parameters
     super.walk(leftImage,rightImage);

    };

    @Override
    public void postStep(StepEvent stepEvent) {

    };
}
