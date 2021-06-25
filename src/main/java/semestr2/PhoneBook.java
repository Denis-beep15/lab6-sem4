package semestr2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneBook {
    private Map<Human, ArrayList<String>> phoneBook;

    public PhoneBook(Map<Human, ArrayList<String>> phoneBook) {
        setPhoneBook(phoneBook);
    }

    public Map<Human, ArrayList<String>> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(Map<Human, ArrayList<String>> phoneBook) {
        if (phoneBook == null) { throw new IllegalArgumentException();}
        this.phoneBook = new HashMap<>();
        this.phoneBook.putAll(phoneBook);
    }

    public void addPhone(Human human, String newPhoneNumber) {
        ArrayList<String> phones = new ArrayList<>();
        if (phoneBook.containsKey(human)) {
            phones = phoneBook.get(human);
        }
        phones.add(newPhoneNumber);
        phoneBook.put(human, phones);
    }

    public boolean deletePhone(Human human, String delPhone) {
        ArrayList<String> listPhones = phoneBook.get(human);
        if (listPhones == null) {
            return false;
        }
        listPhones.remove(delPhone);
        phoneBook.put(human, listPhones);
        return true;
    }

    public ArrayList<String> listPhonesHuman(Human human) {
        if (phoneBook.containsKey(human)) {
            return phoneBook.get(human);
        }
        throw new IllegalArgumentException("Такого человека нет в телефонной книге");
    }

    public Human getHuman(String phone){
        for(Human human: phoneBook.keySet()){
            if(phoneBook.get(human).contains(phone)){
                return human;
            }
        }
        throw new IllegalArgumentException("Человека с таким номером не существует");
    }

    public Map<Human, ArrayList<String>> humanWithPrefix(String str){
        Map<Human, ArrayList<String>> humanWithPrefix = new HashMap<>();
        for (Human human: phoneBook.keySet()){
            if(human.getSurname().startsWith(str)){
                humanWithPrefix.put(human,phoneBook.get(human));
            }
        }
        return humanWithPrefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook1 = (PhoneBook) o;
        return Objects.equals(phoneBook, phoneBook1.phoneBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneBook);
    }
}
