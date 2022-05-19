package game;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
/** Main menu which contains main buttons and allows switching to settings menu
 */
public class ControlPanel {
    private final GameLevel level;
    private final Game game;
    public  JPanel mainPanel;
    private JButton stopButton;
    private JButton quitButton;
    private JButton settingsButton;
    private JButton startButton;
    private Level1 level1;
    private final GameView view;


    /** controler panel constructor
     *
     * @param level
     * @param game
     * @param view
     */
    public ControlPanel(GameLevel level,Game game,GameView view){
        this.game = game;
        this.level = level;
        this.view = view;
        // stop button
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get current level and stop
                game.getLevel().stop();
            }
        });
        // quit button displaying goodbye message and exiting program
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You quit the game you loser");
                JOptionPane.showMessageDialog(null,"See you next time: "+ view.name ," Mindunter", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        // call transition to sttitngs method
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionToSettings();
            }
        });
        // start the level
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getLevel().start();
            }
        });
    }


}
