package game;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
public class Pistol extends BackpackItem{
    public Pistol(Zombie zombie) {
        super(zombie);
    }

    @Override
    public String getType() {
        return "Pistol";
    }

    @Override
    public void operate() {
        zombie.shoot();

    }
}
