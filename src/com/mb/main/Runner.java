package com.mb.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Runner {

    private List<Person> list;

    public void run() {
        list = createListOfPeople();

        printOutEachPersonsAge();
        sortListAge();
        printOutEachPersonsAge();
        removePeopleOlderThan(3);
        printOutEachPersonsAge();
        removePeopleWhere(ageIsEvenNumber());
        printOutEachPersonsAge();

    }

    private Predicate<Person> ageIsEvenNumber() {
        return (x) -> x.getAge() % 2 == 0;
    }

    private void removePeopleWhere(Predicate<Person> predicate) {
        list.removeIf(predicate);
    }

    private void removePeopleOlderThan(int age) {
        list.removeIf((x) -> x.getAge() <= age);
    }

    private List<Person> sortListAge() {

        list.sort((x,y) -> (x.getAge() < y.getAge()) ? -1 : ((x.getAge() > y.getAge()) ? 1 : 0));
        return list;
    }

    private void printOutEachPersonsAge() {
        list.forEach((p) -> System.out.print(p.getAge()));
        System.out.println("");
    }

    private List<Person> createListOfPeople() {
        return new ArrayList<Person>() {{
                this.add(new Person(1));
                this.add(new Person(2));
                this.add(new Person(6));
                this.add(new Person(4));
                this.add(new Person(3));
                this.add(new Person(5));
            }};
    }
}
