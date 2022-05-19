package game;

import city.cs.engine.*;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */

/** Balls class used for the image and outline of the balls
 */
public class Balls extends DynamicBody {
    //Setting the book shape
    private static final Shape ballShape = new CircleShape(1);
    // adding image to the outline
   private static final BodyImage image =
            new BodyImage("data/bowl.png", 2f);
    /** Ball constructor
     *
     * @param w
     */
    public Balls(World w) {
        // calling parent class
        super(w,ballShape);
        // adding an image to the ball shape
        addImage(image);
    }
}
