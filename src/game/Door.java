package game;

import city.cs.engine.*;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Door class for moving to the next level
 *
 */
public class Door extends StaticBody {
    // shape for the door
    /** door shape
     *
     */
    private static final Shape doorShape = new PolygonShape(
            -0.14f,2.49f, 0.94f,2.54f, 2.22f,-0.84f, 0.38f,-2.53f, -0.78f,-2.33f, -2.41f,1.25f, -0.25f,2.47f);
    // image for the door
    /** image for overlaying the shape
     *
     */
    private static final BodyImage doorImage =
            new BodyImage("data/door.png", 6f);
    /** Level 3 villain constructor
     *
     * @param world
     */
    public Door(World world) {
        // calling parent class
        super(world, doorShape);
        // adding image
        addImage(doorImage);

    }

}
