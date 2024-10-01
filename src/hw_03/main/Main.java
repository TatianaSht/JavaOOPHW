package hw_03.main;

import hw_03.model.FamilyTree;
import hw_03.model.Person;
import hw_03.service.FileOperations;
import hw_03.service.FileOperationsImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person ivan = new Person("Ivan", 1970);
        Person maria = new Person("Maria", 1975);
        Person elena = new Person("Elena", 1999);

        elena.setMother(maria);
        elena.setFather(ivan);
        ivan.addChild(elena);
        maria.addChild(elena);

        familyTree.addPerson(ivan);
        familyTree.addPerson(maria);
        familyTree.addPerson(elena);

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

        FileOperations fileOps = new FileOperationsImpl();
        try {
            fileOps.saveToFile(familyTree, "src/hw_03/tree/familyTree.txt");
            System.out.println("\nFamily tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("src/hw_03/tree/familyTree.txt");
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
