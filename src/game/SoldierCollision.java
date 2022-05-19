package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Encounter for colliding with the soldier colliding
 */
public class SoldierCollision extends Encounters {
    private Zombie zombie;
    private final GameLevel level;
    private final Game game;

    /** soldier constructor
     *
     * @param level
     * @param game
     * @param zombie
     */
   public SoldierCollision(GameLevel level, Game game,Zombie zombie) {
       this.level = level;
       this.game = game;
       this.zombie = zombie;
    }


    /** collisiong with soldier decrease points
     *
     * @param e
     */
    public void collide(CollisionEvent e ) {
        // if zombie collides with soldier zombie loses one point
        if (e.getOtherBody() instanceof Soldier) {
            zombie.setCredits(zombie.getCredits()-1);
        }
    }


}
