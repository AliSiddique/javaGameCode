package game;

import city.cs.engine.CollisionEvent;

/** Door encounter class
 *
 */
public class DoorEncounter extends Encounters{
    private  GameLevel level;
    private  Game game;

    /** constructor for door encounter
     *
     * @param level
     * @param game
     */
    public DoorEncounter(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }
    /** collision for the door
     *
     * @param e
     */
    public void collide(CollisionEvent e) {
        // if is complete is true and you interact with the door go to the next level
        if (e.getOtherBody() instanceof Door
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}
