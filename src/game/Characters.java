package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**  Abstract class for making the characters and making them move by themselves
 *
 */
public abstract class Characters extends Walker implements StepListener {
    /** field for the left direction
     *
     */
    private  float  left;
    /** field for the right direction
     *
     */
    private  float right;
    /** field for the speed of the character
     *
     */
    private  final int SPEED = 2;
    /** field for the range that the character can walk
     *
     */
    private final int RANGE = 3;
    private String direction;

    /** setPosition for all the characters
     *
     * @param position
     */
    public void setPosition(Vec2 position){
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }
    /** Walking method
     *
     * @param leftImage
     * @param rightImage
     */
    public void walk(BodyImage leftImage,BodyImage rightImage){
        // if character is on the left change walking speed to left side
        if(getPosition().x > right)
        {
            startWalking(-SPEED);
            this.removeAllImages();
            addImage(leftImage);
        }
        // walking to the right side
        if(getPosition().x < left){
            direction = "right";
            startWalking(SPEED);
            this.removeAllImages();
            addImage(rightImage);

        }
    }
    // shape for all the character
    /** shape for the charcaters
     *
     */
    private static final Shape characterShape = new PolygonShape(
            -0.14f,2.49f, 0.94f,2.54f, 2.22f,-0.84f, 0.38f,-2.53f, -0.78f,-2.33f, -2.41f,1.25f, -0.25f,2.47f);

    /** constructor for characters
     *
     * @param world
     * @param characterShape
     */
    public Characters(World world, Shape characterShape) {
        super(world,characterShape);
    }
    // abstract method for step listener methods

    /** abstarct method for the step listener methods
     *
     * @param stepEvent
     */
    @Override
    public abstract void preStep(StepEvent stepEvent);
    /** abstarct method for the step listener methods
     *
     * @param stepEvent
     */

    @Override
    public abstract void postStep(StepEvent stepEvent);
}
