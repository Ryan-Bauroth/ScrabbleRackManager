import java.util.ArrayList;

/**
 * Scrabble Rack Manager
 * @version March 26 2022
 * @author Ryfi
 */
public class ScrabbleRackManager {
    private ArrayList<String> database;
    private final String alpha = "abcdefghijklmnopqrstuvwxyz";

    public ScrabbleRackManager(){
        database = new ArrayList<>();
    }

    /** displays the contents of the player's tile rack */
    public void printRack(){

    }
    /** builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack */
    public ArrayList<String> getPlaylist(){
        return new ArrayList<>();
    }
    /** print all the playable words based on the letters in the tile rack */
    public void printMatches(){

    }
    /** main method for the class; use only 3 command lines in main */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager(); app.printRack();
        app.printMatches();
    }
}