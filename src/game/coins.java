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
/** Coins class used for the image and outline of the coins
 */
public class coins extends DynamicBody {
    // shape for the coins
    /** shape for the coins
     *
     */
    private static final Shape coinShape = new CircleShape(1);
    // add image to the coins
    /** adding image to the coin
     *
     */
    private static final BodyImage image =
            new BodyImage("data/coins.png", 2f);


    /** Coin constructor
     *
     * @param w
     */
    public coins(World w) {
        // calling parent class
        super(w,coinShape);
        // adding shape to the coin shape
        addImage(image);
    }
}
