package semestr2;

public class Group {
    private int id;
    private int[] arrayData;

    public Group(int id, int... arrayData) {
        this.id = id;
        this.arrayData = arrayData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getArrayData() {
        return arrayData;
    }

    public void setArrayData(int[] arrayData) {
        this.arrayData = arrayData;
    }

    public int getLength(){
        return arrayData.length;
    }

}
