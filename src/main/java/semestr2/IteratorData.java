package semestr2;

import java.util.Iterator;

public class IteratorData implements Iterator<Integer> {
    public static void iterate(Data data){
        for(Group group: data.getSetGroup()){
            for(int number: group.getArrayData()){

            }
        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
