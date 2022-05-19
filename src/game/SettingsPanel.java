package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/** Main menu which contains settings buttons and allows switching to settings menu
 */
public class SettingsPanel {
    private final GameView view;
    private JButton increaseSizeButton;
    public JPanel mainPanel;
    private JButton backButton;
    private JButton decreaseZoomButton;
    private JButton saveButton;
    private final Game game;
    private float gravity;
    private final GameLevel level;
    /** settings menu constructor
     *
     * @param level
     * @param view
     * @param game
     */
    public SettingsPanel(GameLevel level,GameView view,Game game) {
        this.level = level;
        this.view = view;
        this.game =game;
       // view.setZoom(zoomLevel);
        // calls transition to menu method
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            game.transitionToMain();
            }
        });
        // set points to 0 button
        increaseSizeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            game.getLevel().getZombie().setCredits(0);

            }
        });
        // increase gravity button
        decreaseZoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            game.getLevel().setGravity(4f);
            }
        });
        // save point button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SaveGame.save(game.getLevel(), "data/save.txt");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }


}
