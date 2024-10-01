package hw_05.presenter;

import hw_05.model.FamilyTree;
import hw_05.model.Person;
import hw_05.view.FileOperations;
import hw_05.view.TreeView;

import java.io.IOException;

public class TreePresenter {

    private FamilyTree<Person> familyTree;
    private final TreeView view;
    private final FileOperations<Person> fileOperations;
    public TreePresenter(FamilyTree<Person> familyTree, TreeView
            view, FileOperations<Person> fileOperations) {
        this.familyTree = familyTree;
        this.view = view;
        this.fileOperations = fileOperations;
        this.view.setPresenter(this);
    }
    public void addPerson(String name, int birthYear) {
        Person person = new Person(name, birthYear);
        familyTree.addMember(person);
        view.displayMessage("Person added: " + name);
    }
    public void showAllPersons() {
        view.displayPersons(familyTree.getMembers());
    }
    public void sortPersonsByName() {
        familyTree.sortByName();
        view.displayMessage("Persons sorted by name:");
        showAllPersons();
    }
    public void sortPersonsByBirthYear() {
        familyTree.sortByBirthYear();
        view.displayMessage("Persons sorted by birth year:");
        showAllPersons();
    }
    public void saveTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTree, fileName);
            view.displayMessage("Family tree saved to " + fileName);
        } catch (IOException e) {
            view.displayMessage("Error saving family tree: " +
                    e.getMessage());
        }
    }
    public void loadTree(String fileName) {
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            view.displayMessage("Family tree loaded from " +
                    fileName);
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Error loading family tree: " +
                    e.getMessage());
        }

        if (familyTree != null) {
            System.out.println("\nLoaded persons:");
            for (Person person : familyTree) {
                System.out.println(person.getName() + ", born in " +
                        person.getBirthYear());
            }
        }
    }
    public void handleUserInput() {
        while (true) {
            view.displayMessage("""
                    Enter command:
                    1 - add
                    2 - list
                    3 - sortByName
                    4 - sortByBirthYear
                    5 - save
                    6 - load
                    0 - exit
                    """);
            String command = view.getUserInput();
            switch (command) {
                case "1":
                    view.displayMessage("Enter name:");
                    String name = view.getUserInput();
                    view.displayMessage("Enter birth year:");
                    int birthYear =
                            Integer.parseInt(view.getUserInput());
                    addPerson(name, birthYear);
                    break;
                case "2":
                    showAllPersons();
                    break;
                case "3":
                    sortPersonsByName();
                    break;
                case "4":
                    sortPersonsByBirthYear();
                    break;
                case "5":
                    view.displayMessage("Enter file name:");
                    saveTree(view.getUserInput());
                    break;
                case "6":
                    view.displayMessage("Enter file name:");
                    loadTree(view.getUserInput());
                    break;
                case "0":
                    return;
                default:
                    view.displayMessage("Unknown command");
            }
        }
    }

}
