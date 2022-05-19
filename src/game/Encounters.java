package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Encounter abstract class
 *
 */
public abstract class Encounters implements CollisionListener {
    public abstract void collide(CollisionEvent e);
}
