package hw_02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);

        susan.setMother(mary);
        susan.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);

        FileOperations fileOps = new FileOperationsImpl();

        try {
            fileOps.saveToFile(familyTree,  "src/hw_02/tree/familyTree.txt");
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree =
                    fileOps.loadFromFile("src/hw_02/tree/familyTree.txt");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (loadedFamilyTree != null) {
            for (Person person : loadedFamilyTree.getPeople()) {
                System.out.println("Loaded person: " +
                        person.getName() + ", born in " + person.getBirthYear());
            }
        }
    }
}
