package game;

import city.cs.engine.BodyImage;
/** Backpack abstract class
 */
public abstract class BackpackItem {
    protected Zombie zombie;
    private BodyImage image;
    public BackpackItem(Zombie zombie){
        this.zombie = zombie;
    }

    public abstract String getType();
    public abstract void operate();

}
