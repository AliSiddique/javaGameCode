package game;

import city.cs.engine.*;

/** Projectile class which makes the shape of the projectile
 *
 */
public class VillainProjectile extends DynamicBody {
    //circle shape for the brain
    private static final Shape booksShape = new CircleShape(0.3f);
    //Image for brain
    /**Projectile constructor
     *
     * @param w
     */
    public VillainProjectile(World w) {
        super(w,booksShape);
    }
}
