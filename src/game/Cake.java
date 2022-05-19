package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Cake class used for the image and outline of the cake
 */
public class Cake extends DynamicBody {
    // Cake outline shape
    /** outline of the cake shape
     *
     */
    private static final Shape cakeShape = new CircleShape(1);
    // image for the cake
    /** image to overlay the cake
     *
     */
    private static final BodyImage image =
            new BodyImage("data/cake.png", 1f);

    /** Cake constructor
     *
     * @param w
     */
    public Cake(World w) {
        // calling parent class
        /** calling parent class
         *
         */
        super(w,cakeShape);
        // adding image to cake shape
        /** adding image to the shape
         *
         */
        addImage(image);
    }
}
