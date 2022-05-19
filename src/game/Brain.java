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
/** Brain class used for the image and outline of the brain
 */
public class Brain extends DynamicBody {
    //circle shape for the brain
    private static final Shape brainShape = new CircleShape(1);
    //Image for brain
    private static final BodyImage image =
            new BodyImage("data/brain.png", 2f);

    /**Brain constructor
     *
     * @param w
     */
    public Brain(World w) {
        // calling parent class
        super(w,brainShape);
        // adding an image to the brain shape
        addImage(image);
    }
}
