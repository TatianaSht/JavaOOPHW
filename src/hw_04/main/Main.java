package hw_04.main;

import hw_04.model.FamilyTree;
import hw_04.model.Person;
import hw_04.service.FileOperations;
import hw_04.service.FileOperationsImpl;

import java.io.IOException;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();

        Person semen = new Person("Semen", 1970);
        Person maria = new Person("Maria", 1975);
        Person elena = new Person("Elena", 1999);

        elena.setMother(maria);
        elena.setFather(semen);
        semen.addChild(elena);
        maria.addChild(elena);

        familyTree.addMember(semen);
        familyTree.addMember(maria);
        familyTree.addMember(elena);

        System.out.println("Сортировка по имени:");
        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " +
                    person.getBirthYear());
        }

        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthYear();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " +
                    person.getBirthYear());
        }

        FileOperations<Person> fileOps = new FileOperationsImpl<>();
        try {
            fileOps.saveToFile(familyTree, "src/hw_04/tree/familyTree.txt");
            System.out.println("\nFamily tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FamilyTree<Person> loadedFamilyTree = null;
        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("src/hw_04/tree/familyTree.txt");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (loadedFamilyTree != null) {
            System.out.println("\nLoaded persons:");
            for (Person person : loadedFamilyTree) {
                System.out.println(person.getName() + ", born in " +
                        person.getBirthYear());
            }
        }
    }

}
