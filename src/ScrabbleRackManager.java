import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Scrabble Rack Manager
 * @version March 26 2022
 * @author Ryfi
 */
public class ScrabbleRackManager {
    private ArrayList<String> database;
    private final String alpha = "abcdefghijklmnopqrstuvwxyz";
    private final int[] occurrences = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1};
    private ArrayList<String> bag;
    private ArrayList<String> myTiles;

    public ScrabbleRackManager(){
        database = new ArrayList<>();
        //adds the correct numbers of letters to the bag
        for(int i = 0; i < 100; i++){
            for(int x = 0; x < occurrences[i]; x++){
                bag.add(alpha.substring(i, i+1));
            }
        }
        //draws from the bag
        for(int i = 0; i < 7; i++){
            myTiles.add(bag.get((int)(Math.random() * bag.size())));
        }
        try{
            Scanner in = new Scanner(new File("new_scrabble.txt"));
            while(in.hasNext()){
                database.add(in.nextLine());
            }
        }
        catch(Exception e){

        }
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