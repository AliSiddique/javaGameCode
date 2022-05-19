package game;

import city.cs.engine.*;

/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Box class which makes puts the box image on the outlin
 */
public class Box extends Walker {
    // the outline of the box
    private static final Shape boxShape = new PolygonShape(
            -2.71f,2.59f, 2.6f,2.71f, 2.57f,-2.62f, -2.67f,-2.58f
    );
    //box image for overlaying the ploygon shape
    private static final BodyImage image =
            new BodyImage("data/Box.png", 5.5f);

    /**Box constructor
     *
     * @param world
     */
    public Box(World world) {
        // calling parent class
        super(world, boxShape);
        // adding an image to the box shape
        addImage(image);
    }
}