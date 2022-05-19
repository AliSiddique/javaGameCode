package game;
import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;
/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/**
 GameView  class which shows background, points and username
 */
public class GameView extends UserView {
    private final Zombie zombie;
    private Image cred;
    private Game game;
    private GameLevel level;
    private Level2 level2;
    private Image back;
    private String levelsNames;
    Timer t;
    /** Game view
     *
     * @param level
     * @param z
     * @param width
     * @param height
     */
    public GameView(GameLevel level, Zombie z, int width, int height) {
        super(level, width, height);
        zombie = z;
        this.level = level;
    }
    // Option to decide username
   String name = JOptionPane.showInputDialog("Choose your username: ");
   @Override
    public void setWorld(World w){
        super.setWorld(w);
        level = (GameLevel)w;
   }
    /** background image
     */
   @Override
    protected void paintBackground(Graphics2D g) {
       // Get background for each level and fit it to frame
        g.drawImage(level.getBackground(),0,0,1000,1000,this);
    }

    /** showing username, level name and points
     *
     * @param g
     */
    @Override
    protected void paintForeground(Graphics2D g){
        Font font  = new Font("Arial", Font.BOLD, 25);
       super.paintForeground(g);
        g.drawString("You must be in the previous level to click to the next", 20,20);
        // if zombie credits are below 1 stop the level and destroy the zombie
        if(zombie.getCredits() < 0){
            g.setColor(Color.red);
            g.drawString("Game Over", 20,15);
            level.stop();
            zombie.destroy();
            g.setFont(font);

        }
            // display level number
            g.drawString("Level: " + level.getLevelsNames()  + "\n",20,60);
            g.setColor(Color.red);
            g.setFont(font);

            // display user points
            g.drawString("Points: " + level.getZombie().getCredits(), 20,40);
            g.setColor(Color.red);
            g.setFont(font);

            //display username
            g.drawString("Username: " +name,20,80);
            // set color to red
            g.setColor(Color.red);
            g.setFont(font);


        }
    }
