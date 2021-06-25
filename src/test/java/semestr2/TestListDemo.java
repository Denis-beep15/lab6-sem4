package semestr2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static semestr2.ListDemo.listAgeCharHuman;

import java.util.*;

public class TestListDemo {
    private ListDemo listDemo = new ListDemo();
    private ArrayList<Human> listOfPeople = new ArrayList<>();
    private Human people = new Human("Ivanov", "Ivan", "Ivanovich", 45);
    private Human people1 = new Human("Ivanov", "Dmitry", "Alexandrovich", 40);
    private Human people2 = new Human("Ivanov", "Vasiliy", "Pavlovich", 10);
    private Human people3 = new Human("Petrov", "Ivan", "Viktorovich", 45);
    private Human people4 = new Human("Sidorov", "Ivan", "Ivanovich", 18);
    private Human people5 = new Human("Ivanov", "Vitaliy", "Ivanovich", 45);
    private Human people6 = new Human("Ivanov", "Ivan", "Ivanovich", 10);

    @Test
    public void testListOfNamesakes() {
        ArrayList<Human> expected = new ArrayList<>();
        Collections.addAll(listOfPeople, people, people1, people2, people3, people4, people5);
        Collections.addAll(expected, people, people1, people2, people5);
        assertEquals(expected, listDemo.listOfNamesakes(listOfPeople, people6));
    }

    @Test
    public void testListWithoutAPeople() {
        ArrayList<Human> expected = new ArrayList<>();
        Collections.addAll(listOfPeople, people, people1, people2, people3, people4);
        Collections.addAll(expected, people, people1, people2, people3);
        assertEquals(expected, listDemo.listWithoutAPeople(listOfPeople, people4));
    }

    @Test
    public void testDisjointSets() {
        ArrayList<Set<Integer>> disjointSets = new ArrayList<>();
        ArrayList<Set<Integer>> expected = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set4 = new HashSet<>();
        Collections.addAll(set,1,2,3,4,5);
        Collections.addAll(set1, 2,3,4);
        Collections.addAll(set2,9,8,7);
        Collections.addAll(set3, 0,7);
        Collections.addAll(set4,2,3,4);
        Collections.addAll(disjointSets,set,set1,set2,set3);
        Collections.addAll(expected,set2,set3);
        assertEquals(expected, listDemo.disjointSets(disjointSets,set4));
    }

    @Test
    public void testListMaxAge(){
        Set<Human> expected = new HashSet<>();
        Collections.addAll(listOfPeople, people, people1, people2, people3, people4, people5, people6);
        Collections.addAll(expected,people,people3,people5);
        assertEquals(expected,listDemo.listMaxAge(listOfPeople));
    }

    @Test
    public void testListIdPeople(){
        Map<Integer, Human> idPeople = new HashMap<>();
        Set<Integer> id = new HashSet<>();
        Set<Human> expected = new HashSet<>();
        Collections.addAll(id, 1,3,5);
        idPeople.put(1,people1);
        idPeople.put(2,people2);
        idPeople.put(3,people3);
        idPeople.put(4,people4);
        idPeople.put(5,people5);
        Collections.addAll(expected,people1,people3,people5);
        assertEquals(expected,listDemo.listIdPeople(idPeople,id));
    }

    @Test
    public void testListOfAdults(){
        Map<Integer, Human> idPeople = new HashMap<>();
        ArrayList<Integer> expected = new ArrayList<>();
        idPeople.put(1,people1);
        idPeople.put(2,people2);
        idPeople.put(3,people3);
        idPeople.put(4,people4);
        idPeople.put(5,people5);
        idPeople.put(6,people6);
        Collections.addAll(expected,1,3,4,5);
        assertEquals(expected, listDemo.listOfAdults(idPeople));
    }

    @Test
    public void testListIdAge(){
        Map<Integer, Human> idPeople = new HashMap<>();
        Map<Integer, Integer> expected = new HashMap<>();
        idPeople.put(1,people1);
        idPeople.put(2,people2);
        idPeople.put(3,people3);
        idPeople.put(4,people4);
        idPeople.put(5,people5);
        idPeople.put(6,people6);
        expected.put(1,45);
        expected.put(2,40);
        expected.put(3,10);
        expected.put(4,45);
        expected.put(5,18);
        expected.put(6,5);
    }

    @Test
    public void testListAgeHuman(){
        Set<Human> humans = new HashSet<>();
        Map<Integer, ArrayList<Human>> expected = new HashMap<>();
        ArrayList<Human> list1 = new ArrayList<>();
        ArrayList<Human> list2 = new ArrayList<>();
        ArrayList<Human> list3 = new ArrayList<>();
        ArrayList<Human> list4 = new ArrayList<>();
        Collections.addAll(humans,people,people1,people2,people3,people4,people5,people6);
        Collections.addAll(list1,people3,people5,people);
        Collections.addAll(list2,people1);
        Collections.addAll(list3,people6,people2);
        Collections.addAll(list4,people4);
        expected.put(45,list1);
        expected.put(40,list2);
        expected.put(10,list3);
        expected.put(18,list4);
        assertEquals(expected, ListDemo.listAgeHuman(humans));
    }

    @Test
    public void testListAgeCharHuman(){
        Set<Human> humans = new HashSet<>();
        Map<Integer, Map<Character, ArrayList<Human>>> expected = new HashMap<>();
        Map<Character, ArrayList<Human>>  charAndHuman1 = new HashMap<>();
        Map<Character, ArrayList<Human>>  charAndHuman2 = new HashMap<>();
        Map<Character, ArrayList<Human>>  charAndHuman3 = new HashMap<>();
        Map<Character, ArrayList<Human>>  charAndHuman4 = new HashMap<>();
        ArrayList<Human> list1 = new ArrayList<>();
        ArrayList<Human> list2 = new ArrayList<>();
        ArrayList<Human> list3 = new ArrayList<>();
        ArrayList<Human> list4 = new ArrayList<>();
        ArrayList<Human> list5 = new ArrayList<>();
        Collections.addAll(humans,people,people1,people2,people3,people4,people5,people6);
        Collections.addAll(list1,people3);
        Collections.addAll(list2,people5,people);
        Collections.addAll(list3,people1);
        Collections.addAll(list4,people6,people2);
        Collections.addAll(list5,people4);
        charAndHuman1.put('P',list1);
        charAndHuman1.put('I',list2);
        charAndHuman2.put('I',list3);
        charAndHuman3.put('I',list4);
        charAndHuman4.put('S',list5);
        expected.put(45,charAndHuman1);
        expected.put(40,charAndHuman2);
        expected.put(10,charAndHuman3);
        expected.put(18,charAndHuman4);

        assertEquals(expected, listAgeCharHuman(humans));
    }
}