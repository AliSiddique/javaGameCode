package game;

import city.cs.engine.SoundClip;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */

/** Game class which contains all the methods need to go to the next level and menus
 */
public class Game {
    private boolean gameOver;
    private GameLevel level;
    public GameView view;
    public ZombieController controller;
    private boolean menuVisible;
    private final ControlPanel mainMenu;
    private final SettingsPanel settingsMenu;
    public JFrame frame;
    private String s;
    private JProgressBar bar;
    private JProgressBar bars;
    private JProgressBar thirdBar;
    private JProgressBar fourthBar;
    private SoundClip booksSound;
    public JPanel buttonPanels;
    /** Game constructor
     */
    public Game() {
        //variable for menu opening
        menuVisible = false;
        // the starting level is level1
        level = new Level1(this);
        //initialising the zombie in the particular level
        Zombie z = level.getZombie();
        //the current game view
        view = new GameView (level,z, 800, 700);
        //adding the view when the mouse is pressed
        view.addMouseListener(new GiveFocus(view));
        // Initialising the zombie controller
        controller = new ZombieController(level.getZombie(),this);
        //adding key controls to the view
        view.addKeyListener(controller);
        // adding step listener to the level
        // setting zoom to the view
        view.setZoom(12);
        // Initialising the j frame
        frame = new JFrame("MindHunter");
        // adding the game view to the frame so it is present
        frame.add(view, BorderLayout.CENTER);
        //initialising game buttons
        mainMenu = new ControlPanel(level,this,view);
        settingsMenu = new SettingsPanel(level,view,this);
        //button that will show instruction
       JButton button1 = new JButton("Instructions");
        //the event listener will listen for a click and show the instructions
       button1.addActionListener(e -> {
           // stop the level to read
           level.stop();
           // show instructions
           JOptionPane.showMessageDialog(null, "1:You will have to collect Coins,Brains, Bananas and Balls throughout the game " +
                   "\n 2: Avoid objects like cake and landmines. " +
                   "\n 3: Do not collide with the villain or you will lose a point" +
                   "\n 4: Get to level 4 and Win the game!" +
                   "\n 5: You have to click the load level1 button to progress to the next" +
                   "\n If you get hit by an enemy bullet you will die");

       });
        //Restart button
        JButton button  = new JButton("Restart");
        button.setBounds(100,160, 200, 50);
        // restart game from level 1 no matter which level the player is currently on
        button.addActionListener(e -> {
            if(level instanceof Level1){
                //stop the current level
                level.stop();
                //STOP Level 1 music
                ((Level1) level).getGameMusic().stop();
                // set view to zoom 12
                view.setZoom(12);
                // start a new instance of level 1
                level = new Level1(this);
                // make the world the current level
                view.setWorld(level);
                // update controller so same key controls can be used
                controller.updateZombie(level.getZombie());
                //start the new level
                level.start();
            }
           else  if (level instanceof Level2){
                //stop the current level
                level.stop();
                // set view to zoom 12
                view.setZoom(12);
                // start a new instance of level 1
                level = new Level1(this);
                // make the world the current level
                view.setWorld(level);
                // update controller so same key controls can be used
                controller.updateZombie(level.getZombie());
                //start the new level
                level.start();

            }
           else  if (level instanceof Level3){
                //stop the current level
                level.stop();
                // set view to zoom 12
                view.setZoom(12);
                // start a new instance of level 1
                level = new Level1(this);
                // make the world the current level
                view.setWorld(level);
                // update controller so same key controls can be used
                controller.updateZombie(level.getZombie());
                //start the new level
                level.start();
            }
            else if (level instanceof Level4){
                //stop the current level
                level.stop();
                // set view to zoom 12
                view.setZoom(12);
                // start a new instance of level 1
                level = new Level1(this);
                // make the world the current level
                view.setWorld(level);
                // update controller so same key controls can be used
                controller.updateZombie(level.getZombie());
                //start the new level
                level.start();
            }
        });
        //load level 1 button
        JButton loadLevel1button = new JButton("Load level 1");
        loadLevel1button.addActionListener(e -> {
            // stop current level
            level.stop();
            // stop current level music
            ((Level1) level).getGameMusic().stop();
            view.setZoom(12);
            // start new level
            level = new Level1(this);
            view.setWorld(level);
            // update controller
            controller.updateZombie(level.getZombie());
            // adding a progress bar depending on the level
            bar = new JProgressBar();
            // setting progess bar value to 25
            bar.setValue(25);
            bar.setStringPainted(true);
            bar.setVisible(true);
            bar.setForeground(Color.GREEN);
            // add progress bar to top
            frame.add(bar,BorderLayout.NORTH);
            frame.pack();
            level.start();

        });
        //Load level 2 button
        JButton loadLevel2button = new JButton("Load level 2");
        loadLevel2button.addActionListener(e -> {
            // remove previous progress bar
            frame.remove(bar);
            level.stop();
            //STOP Level 2 music
            view.setZoom(12);
            level = new Level2(this);
            view.setWorld(level);
            controller.updateZombie(level.getZombie());
            bars= new JProgressBar();
            bars.setValue(50);
            bars.setStringPainted(true);
            bars.setVisible(true);
            bars.setForeground(Color.GREEN);
            frame.add(bars,BorderLayout.NORTH);
            frame.pack();
            level.start();

        });
        //Load level 3 button
        JButton loadLevel3button = new JButton("Load level 3");
        loadLevel3button.setToolTipText("Click this button to make something happen.");
        loadLevel3button.addActionListener(e -> {
            frame.remove(bars);
            level.stop();
            view.setZoom(12);
            level = new Level3(this);
            view.setWorld(level);
            controller.updateZombie(level.getZombie());
            thirdBar = new JProgressBar();
            thirdBar.setValue(75);
            thirdBar.setStringPainted(true);
            thirdBar.setVisible(true);
            thirdBar.setForeground(Color.GREEN);
            frame.add(thirdBar,BorderLayout.NORTH);
            frame.pack();
            level.start();
        });

        // Load level 4 button
        JButton loadLevel4button = new JButton("Load level 4");
        loadLevel4button.addActionListener(e -> {
            frame.remove(thirdBar);
            level.stop();
            view.setZoom(12);
            level = new Level4(this);
            view.setWorld(level);
            controller.updateZombie(level.getZombie());
            fourthBar = new JProgressBar();
            fourthBar.setValue(100);
            fourthBar.setStringPainted(true);
            fourthBar.setVisible(true);
            fourthBar.setForeground(Color.GREEN);
            frame.add(fourthBar,BorderLayout.NORTH);
            frame.pack();
            level.start();

        });
        // Initialising the JPanel
        buttonPanels = new JPanel();
        // Adding button to JPanel
        buttonPanels.add(button);
        buttonPanels.add(loadLevel1button);
        buttonPanels.add(loadLevel2button);
        buttonPanels.add(loadLevel3button);
        buttonPanels.add(loadLevel4button);
        buttonPanels.add(button1);
        // Adding JPanel to JFrame
        frame.add(buttonPanels, BorderLayout.SOUTH);
        // Close JFrame when close button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);
        // Start the current level
        level.start();
    }

    /** Gets the current level
     */
    public GameLevel getLevel() {return level;}

    /** set level method
     *
     * @param level
     */
    public void setLevel(GameLevel level){
        this.level.stop();
        this.level = level;
        view.setWorld(level);
        //start the simulation in the new level
        this.level.start();

    }

    /** Method to go to the next level
     */
    public  void goToNextLevel(){
        if (level instanceof Level1){
            // stops current level
            level.stop();
            view.setZoom(12);
            //stops the current level music
            ((Level1) level).getGameMusic().stop();
            // makes new level 2
            level = new Level2(this);
            view.setZoom(5);
            view.setWorld(level);
            // update controller for the new level
            controller.updateZombie(level.getZombie());
           // start new level
            level.start();
        }
        else if (level instanceof Level2){
            level.stop();
            ((Level2) level).getGameMusic().stop();
            level = new Level3(this);
            view.setZoom(12);
            view.setWorld(level);
            controller.updateZombie(level.getZombie());
            level.start();
        }
        else if (level instanceof Level3){
            level.stop();
            ((Level3) level).getGameMusic().stop();
            view.setZoom(12);
            level = new Level4(this);
            view.setWorld(level);
            controller.updateZombie(level.getZombie());
            level.start();

        }  else if (level instanceof Level4){
            System.out.println("Well done! Game complete.");
            level.stop();
            // show success message
           JOptionPane.showMessageDialog(null, "Well Done! You have completed all the levels", "Mindhunter", JOptionPane.INFORMATION_MESSAGE);
           // quits the program
            System.exit(0);
        }
    }

    /** Main game class which runs the game
     */
    public static void main(String[] args) {
        new Game();
    }

    /** Open and close main menu
     */
    public void toggleMenu(){
        if(menuVisible){
            // remove the main menu
            frame.remove(mainMenu.mainPanel);
            menuVisible = false;
            // adjust the frame to fit
            frame.pack();
        } else {
            // add the main menu
            frame.add(mainMenu.mainPanel,BorderLayout.WEST);
            menuVisible = true;
            frame.pack();
        }
    }

    /** Switch to settings menu
     */
    public void transitionToSettings(){
        // remove main menu
        frame.remove(mainMenu.mainPanel);
        // add settings menu
        frame.add(settingsMenu.mainPanel, BorderLayout.WEST );
        frame.pack();
    }

    /** Switch to main menu
     */
    public void transitionToMain(){
        // remove settings menu
        frame.remove(settingsMenu.mainPanel);
        // add main menu
        frame.add(mainMenu.mainPanel, BorderLayout.WEST );
        frame.pack();

    }


}
