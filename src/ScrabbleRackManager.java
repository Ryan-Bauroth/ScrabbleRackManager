import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Scrabble Rack Manager
 * @version March 26 2022
 * @author Ryfi
 * @extra has a blank tile option
 */
public class ScrabbleRackManager {
    private ArrayList<ArrayList<String>> database;
    private final String alpha = "abcdefghijklmnopqrstuvwxyz ";
    private final int[] occurrences = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
    private static final int[] values = {
            1, 3, 3, 2, 1, 4, 2, 4, 1, 8,
            5, 1, 3, 1, 1, 3, 10, 1, 1, 1,
            1, 4, 4, 8, 4, 10
    };
    private ArrayList<String> bag;
    private ArrayList<String> rack;

    /** class constructor */
    public ScrabbleRackManager(){
        database = new ArrayList<>();
        bag = new ArrayList<>();
        rack = new ArrayList<>();
        for(int i = 0; i < occurrences.length; i++){
            for(int t = 0; t < occurrences[i]; t++){
                bag.add(alpha.substring(i, i+1));
            }
        }
        for(int i = 0; i < 26; i++){
            database.add(new ArrayList<>());
        }
        generateRack();
        try{
            Scanner in = new Scanner(new File("new_scrabble.txt"));
            while(in.hasNext()){
                String temp = in.nextLine();
                database.get(alpha.indexOf(temp.substring(0,1))).add(temp);
            }
            in.close();
            for(int i = 0; i < 26; i++){
                Collections.sort(database.get(i));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void generateRack(){
        for(int i = 0; i < 7; i++){
            Collections.shuffle(bag);
            int rand = (int) (Math.random() * bag.size());
            rack.add(bag.get((rand)));
            bag.remove(rand);
        }
    }
    /** displays the contents of the player's tile rack */
    public void printRack(){
        System.out.println("Letters in the tile rack: " + rack);
    }

    /** builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack */
    public ArrayList<String> getPlaylist(){
        ArrayList<String> playlist = new ArrayList<>();
        for(ArrayList<String> bucket : database){
            if(rack.contains(bucket.get(0).substring(0, 1)) || rack.contains(" ")){
                for (String s : bucket) {
                    if (isPlayable(s))
                        playlist.add(s);
                }
            }
        }
        return playlist;
    }
    private boolean isPlayable(String word){
        ArrayList<String> r = new ArrayList<>(rack);
        for(int i = 0; i < word.length(); i++){
            if(!r.remove(word.substring(i, i+1)) && !r.remove(" "))
                return false;
        }
        return true;
    }

    /** print all the playable words based on the letters in the tile rack */
    public void printMatches(){
        ArrayList<String> matches = getPlaylist();
        System.out.print("You can play the following words from the letters in your rack:");
        if(matches.size() == 0)
            System.out.println(" Sorry, NO words can be played from those tiles.");
        else{
            for (int i = 0; i < matches.size(); i++) {
                int score = 0;
                for (int x = 0; x < matches.get(i).length(); x++) {
                    score += values[alpha.indexOf(matches.get(i).substring(x, x + 1))];
                }
                if ((i) % 10 == 0)
                    System.out.println();
                System.out.printf("%-14s", matches.get(i) + " (" + score + ")" + (matches.get(i).length() == 7 ? "*" : ""));
            }
            System.out.println("\n* denotes BINGO");
        }
    }
    /** main method for the class; use only 3 command lines in main */
    public static void main(String[] args){
          ScrabbleRackManager app = new ScrabbleRackManager();
          app.printRack();
          app.printMatches();
    }
}