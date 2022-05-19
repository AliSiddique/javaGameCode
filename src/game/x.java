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
/** X class for adding the image
 */
public class x extends DynamicBody {
    // shape for x
    private static final Shape booksShape = new CircleShape(1);
    // image for the outline
    private static final BodyImage image =
            new BodyImage("data/x.png", 1f);

    /** x constructor
     *
     * @param w
     */
    public x(World w) {
        // calling parent class
        super(w,booksShape);
        addImage(image);
    }
}
