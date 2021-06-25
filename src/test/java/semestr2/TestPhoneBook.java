package semestr2;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestPhoneBook {
    private Map<Human, ArrayList<String>> expected = new HashMap<>();
    private Map<Human, ArrayList<String>> actual = new HashMap<>();
    private PhoneBook phoneBook;
    private Human people1 = new Human("Ivanov", "Dmitry", "Alexandrovich", 40);
    private Human people2 = new Human("Ivanov", "Vasiliy", "Pavlovich", 10);
    private Human people3 = new Human("Petrov", "Ivan", "Viktorovich", 45);
    private String firstPhone1 = "123456";
    private String firstPhone2 = "123456789";
    private String firstPhone3 = "1111111";
    private String secondPhone1 = "1345622";
    private String thirdPhone1 = "10101010";
    private String thirdPhone2 = "222222";
    ArrayList<String> expectedList = new ArrayList<String>();
    ArrayList<String> actualList = new ArrayList<String>();
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    ArrayList<String> list3 = new ArrayList<String>();


    @Test
    public void testAddPhone(){
        Collections.addAll(expectedList,firstPhone1,firstPhone2,firstPhone3);
        expected.put(people1, expectedList);
        PhoneBook expectedPhoneBook = new PhoneBook(expected);
        Collections.addAll(actualList, firstPhone1,firstPhone2);
        actual.put(people1,actualList);
        PhoneBook actualPhoneBook = new PhoneBook(actual);
        actualPhoneBook.addPhone(people1,firstPhone3);
        assertEquals(expectedPhoneBook,actualPhoneBook);
    }
    @Test
    public void testDeletePhone(){
        Collections.addAll(expectedList,firstPhone1,firstPhone2);
        expected.put(people1, expectedList);
        PhoneBook expectedPhoneBook = new PhoneBook(expected);
        Collections.addAll(actualList, firstPhone1,firstPhone2,firstPhone3);
        actual.put(people1,actualList);
        PhoneBook actualPhoneBook = new PhoneBook(actual);
        actualPhoneBook.deletePhone(people1,firstPhone3);
        assertEquals(expectedPhoneBook,actualPhoneBook);
    }


    @Test
  public void testGetHuman(){
        Collections.addAll(actualList, firstPhone1,firstPhone2,firstPhone3);
        Collections.addAll(list3, thirdPhone1,thirdPhone2);
        actual.put(people1,actualList);
        actual.put(people3,list3);
        PhoneBook actualPhoneBook = new PhoneBook(actual);
        assertEquals(people1, actualPhoneBook.getHuman(firstPhone2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetHumanException(){
        Collections.addAll(actualList, firstPhone1,firstPhone2);
        Collections.addAll(list3, thirdPhone1,thirdPhone2);
        actual.put(people1,actualList);
        actual.put(people3,list3);
        PhoneBook actualPhoneBook = new PhoneBook(actual);
        assertEquals(people1, actualPhoneBook.getHuman(firstPhone3));
    }

    @Test
    public void testListPhonesHuman(){
        Collections.addAll(actualList, firstPhone1,firstPhone2);
        Collections.addAll(list3, thirdPhone1,thirdPhone2);
        actual.put(people1,actualList);
        actual.put(people3,list3);
        PhoneBook actualPhoneBook = new PhoneBook(actual);
        assertEquals(list3,actualPhoneBook.listPhonesHuman(people3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListPhonesHumanException(){
        Collections.addAll(actualList, firstPhone1,firstPhone2);
        Collections.addAll(list3, thirdPhone1,thirdPhone2);
        actual.put(people1,actualList);
        actual.put(people3,list3);
        PhoneBook actualPhoneBook = new PhoneBook(actual);
        assertEquals(list3,actualPhoneBook.listPhonesHuman(people2));
    }

    @Test
    public  void testHumanWithPrefix(){
        Collections.addAll(list1,firstPhone1,firstPhone2,firstPhone3);
        Collections.addAll(list2,secondPhone1);
        Collections.addAll(list3,thirdPhone1,thirdPhone2);
        actual.put(people1,list1);
        actual.put(people2,list2);
        actual.put(people3,list3);
        PhoneBook actualPhoneBook = new PhoneBook(actual);
        expected.put(people1,list1);
        expected.put(people2,list2);
        assertEquals(expected,actualPhoneBook.humanWithPrefix("Iva"));
    }






}
