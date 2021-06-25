package semestr2;

import java.util.ArrayList;

public class CollectionsDemo {
    public int numberRowsWithCharacter(ArrayList<String> list, char a){
        int sum = 0;
        for (String str: list){
            if(str.startsWith(String.valueOf(a))){
                sum++;
            }
        }
        return sum;
    }
}
