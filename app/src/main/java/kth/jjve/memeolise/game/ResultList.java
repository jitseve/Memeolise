package kth.jjve.memeolise.game;
/*

Jitse van Esch & Elisa Perini
2.12.21
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultList implements Serializable {
    private static List<Results> theResults;

    public ResultList(){

    }

    public static List<Results> getInstance(){
        if (theResults == null)
            theResults = new ArrayList<>();
        return theResults;
    }
}