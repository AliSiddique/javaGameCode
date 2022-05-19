package game;

import city.cs.engine.*;

/** Banana class used for the image and outline of the banana
 */
public class Banana extends DynamicBody {
    // circleShape for banana
    private static final Shape bananaShape = new CircleShape(1);
    //Banana image
    private static final BodyImage image =
            new BodyImage("data/banana.png", 2f);

    /**banana constructor
     */
    public Banana(World w) {
        // calling parent class
        super(w,bananaShape);
        // adding an image to the banana shape
        addImage(image);
    }
}