package semestr2;

import java.util.*;



public class ListDemo {
    public static ArrayList<Human> listOfNamesakes(ArrayList<Human> listOfPeople, Human people) {
        ArrayList<Human> listOfNamesakes = new ArrayList<>();
        for (Human human : listOfPeople) {
            if (human.getSurname().equals(people.getSurname())) {
                listOfNamesakes.add(human);
            }
        }
        return listOfNamesakes;
    }

    public static ArrayList<Human> listWithoutAPeople(ArrayList<Human> listOfPeople, Human people) {
        ArrayList<Human> listWithoutAPeople = new ArrayList<>(listOfPeople);
        for (Human human : listOfPeople) {
            if (human.equals(people)) {
                listWithoutAPeople.remove(human);
            }
        }
        return listWithoutAPeople;
    }

    public static ArrayList<Set<Integer>> disjointSets(ArrayList<Set<Integer>> listOfSets, Set<Integer> set) {
        ArrayList<Set<Integer>> disjointSets = new ArrayList<>(listOfSets);
        for (Set<Integer> i : listOfSets) {
            if (i.removeAll(set)) {
                disjointSets.remove(i);
            }
        }
        return disjointSets;
    }

    public static Set<Human> listMaxAge(ArrayList<Human> list) {
        int maxAge = 0;
        Set<Human> setMaxAge = new HashSet<Human>();
        for (Human human : list) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
            }
        }
        for (Human human : list) {
            if (human.getAge() == maxAge) {
                setMaxAge.add(human);
            }
        }
        return setMaxAge;
    }

    public static Set<Human> listIdPeople(Map<Integer, Human> idPeople, Set<Integer> id) {
        Set<Human> peopleId = new HashSet<>();
        for (Integer key : id) {
            if (idPeople.containsKey(key)) {
                peopleId.add(idPeople.get(key));
            }
        }
        return peopleId;
    }

    public static ArrayList<Integer> listOfAdults(Map<Integer, Human> idPeople) {
        ArrayList<Integer> id = new ArrayList<>();
        Set<Integer> key = idPeople.keySet();
        for (Integer k : key) {
            if (idPeople.get(k).getAge() >= 18) {
                id.add(k);
            }
        }
        return id;
    }

    public static Map<Integer, Integer> listIdAge(Map<Integer, Human> idPeople) {
        Map<Integer, Integer> idAge = new HashMap<>();
        Set<Integer> keys = idPeople.keySet();
        for (Integer id : keys) {
            idAge.put(id, idPeople.get(id).getAge());
        }
        return idAge;
    }

    public static Map<Integer, ArrayList<Human>> listAgeHuman(Set<Human> humans) {
        Map<Integer, ArrayList<Human>> ageHuman = new HashMap<>();
        for (Human human : humans) {
            ArrayList<Human> people = new ArrayList<>();
            if (ageHuman.containsKey(human.getAge())) {
                people = ageHuman.get(human.getAge());
            }
            people.add(human);
            ageHuman.put(human.getAge(), people);

        }
        return ageHuman;
    }

    public static Map<Integer, Map<Character, ArrayList<Human>>> listAgeCharHuman(Set<Human> humans) {
        Map<Integer, ArrayList<Human>> mapAgeListHuman = listAgeHuman(humans);
        Map<Integer, Map<Character, ArrayList<Human>>> result = new HashMap<>();
      //Map<Character, ArrayList<Human>> mapCharListHuman = new HashMap<>();
        for (int age : mapAgeListHuman.keySet()) {
            Map<Character, ArrayList<Human>> mapCharListHuman = new HashMap<>();
            for (Human human : mapAgeListHuman.get(age)) {
                ArrayList<Human> humanList = new ArrayList<>();
                char firstLetter = human.getSurname().charAt(0);
                if (mapCharListHuman.containsKey(firstLetter)) {
                    humanList = mapCharListHuman.get(firstLetter);
                }
                humanList.add(human);
                mapCharListHuman.put(firstLetter, humanList);
                result.put(human.getAge(), mapCharListHuman);
            }
        }
        return result;
    }
}
