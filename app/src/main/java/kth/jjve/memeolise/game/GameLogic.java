package kth.jjve.memeolise.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameLogic {
    private final List<String> letterList = Arrays.asList("a", "b"); //Todo: decide how many letters we want to have
    private final List<Integer> positionList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private List<String> usedLetters = new ArrayList<>();
    private List<Integer> usedPositions = new ArrayList<>();

    public void reset(){
        List<String> usedLetters = new ArrayList<>();
        List<Integer> usedPositions = new ArrayList<>();
    }

    public String returnRandomLetter(){
        // Function that takes a random letter from the letter list
        // Returns the letter and appends it to usedLetters
//        Random rand = new Random();
//        String letter = letterList.get(rand.nextInt(letterList.size()));
//        usedLetters.add(letter);
        String letter = "a";
        usedLetters = Arrays.asList("a", "a", "b", "a", "a");

        return letter;
    }

    public int returnRandomPosition(){
        // Function that takes a random position from the position list
        // Returns the position and appends it to usedPositions
        Random rand = new Random();
        int position = positionList.get(rand.nextInt(positionList.size()));
        usedPositions.add(position);

        return position;
    }

    public int checkVisualScored(int n, int eventNo, boolean buttonPress){
        //Function to check if the user has scored on the visual
        int a = usedPositions.get(eventNo-1);
        int b = usedPositions.get(eventNo - n - 1);
        boolean shouldPress = a==b;

        if (shouldPress == buttonPress){
            return 0;
        }
        else{
            return -1;
        }
    }

    public int checkAudioScored(int n, int eventNo, boolean buttonPress){
        //Function to check if the user has scored on the audio
        //Todo: save a maximum score somewhere
        String a = usedLetters.get(eventNo-1);
        String b = usedLetters.get(eventNo - n - 1);
        boolean shouldPress = a.equals(b);

        if (shouldPress == buttonPress){
            return 0;
        }
        else{
            return -1;
        }
    }

    public int checkCombinedScored(int n, int eventNo, boolean buttonPress1, boolean buttonPress2){
        //Function to check if the user has scored on both audio and visual
        String a = usedLetters.get(eventNo-1);
        String b = usedLetters.get(eventNo - n - 1);
        boolean shouldPress1 = a.equals(b);
        int c = usedPositions.get(eventNo-1);
        int d = usedPositions.get(eventNo - n - 1);
        boolean shouldPress2 = c==d;

        if (shouldPress2 == buttonPress2 && shouldPress1 == buttonPress1){
            return 1;
        } else if (shouldPress1 == buttonPress1){
            return 0;
        } else if (shouldPress2 == buttonPress2){
            return 0;
        } else {
            return -1;
        }


    }

    public static GameLogic getInstance() {
        if (gameLogic == null){
            gameLogic = new GameLogic();
        }
        return gameLogic;
    }

    private static GameLogic gameLogic=null;

    private GameLogic(){
        reset();
    }

}
