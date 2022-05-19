package game;

import org.jbox2d.common.Vec2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Direction implements MouseListener {
    private final Zombie zombie;
    private final GameView view ;

    public Direction(Zombie z, GameView v){
        zombie = z;
        view = v;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Vec2 worldPoint = view.viewToWorld(e.getPoint());
        zombie.shoot(worldPoint);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}