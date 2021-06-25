package semestr2;

public class Data {
    private String nameSet;
    private Group[] setGroup;

    public Data(String nameSet, Group... setGroup) {
        this.nameSet = nameSet;
        this.setGroup = setGroup;
    }

    public String getNameSet() {
        return nameSet;
    }

    public void setNameSet(String nameSet) {
        this.nameSet = nameSet;
    }

    public Group[] getSetGroup() {
        return setGroup;
    }

    public void setSetGroup(Group[] setGroup) {
        this.setGroup = setGroup;
    }

    public int getLength(){
        return setGroup.length;
    }


}
