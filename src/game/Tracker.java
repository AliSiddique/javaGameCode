package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;


public class Tracker  implements StepListener {
    private final GameView view;
    private final Zombie zombie;
    public Tracker(GameView view, Zombie student) {
        this.zombie = student;
        this.view = view;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(zombie.getPosition());
    }
}