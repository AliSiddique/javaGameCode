package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author      Ali Siddique, ali.siddique@city.ac.uk
 * @version     3.0
 * @since       May 2022
 */
/** Class for saving game
 */
public class SaveGame {
    // Save game constructor
    public static void save(GameLevel level, String fileName)
            throws IOException
    {
        boolean append = false;
        // Allow to write in a file
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            // Write the level name and the current points in the file
            writer.write("Your level is : "  +level.getLevelName() + "," + " Your Points: "+ level.getZombie().getCredits() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }


}
