package hw_06.presenter;

import hw_06.model.FamilyTree;
import hw_06.model.Person;
import hw_06.service.FileOperations;
import hw_06.view.InputView;
import hw_06.view.MessageView;
import hw_06.view.PersonView;

import java.io.IOException;

public class TreePresenter {

    private FamilyTree<Person> familyTree;
    private MessageView messageView;
    private PersonView personView;
    private InputView inputView;
    private FileOperations<Person> fileOperations;
    public TreePresenter(FamilyTree<Person> familyTree, MessageView messageView, PersonView personView,
                         InputView inputView, FileOperations<Person> fileOperations) {
        this.familyTree = familyTree;
        this.messageView = messageView;
        this.personView = personView;
        this.inputView = inputView;
        this.fileOperations = fileOperations;
    }
    public void addPerson(String name, int birthYear) {
        Person person = new Person(name, birthYear);
        familyTree.addMember(person);
        messageView.displayMessage("Person added: " + name);
    }
    public void showAllPersons() {
        personView.displayPersons(familyTree.getMembers());
    }
    public void sortPersonsByName() {
        familyTree.sortByName();
        messageView.displayMessage("Persons sorted by name:");
        showAllPersons();
    }
    public void sortPersonsByBirthYear() {
        familyTree.sortByBirthYear();
        messageView.displayMessage("Persons sorted by birth year:");
        showAllPersons();
    }
    public void saveTree(String fileName) {
        try {
            fileOperations.saveToFile(familyTree, fileName);
            messageView.displayMessage("Family tree saved to " + fileName);
        } catch (IOException e) {
            messageView.displayMessage("Error saving family tree: " + e.getMessage());
        }
    }
    public void loadTree(String fileName) {
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            messageView.displayMessage("Family tree loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            messageView.displayMessage("Error loading family tree: " + e.getMessage());
        }
    }
    public void handleCommand(String command) {
        switch (command) {
            case "1":
                messageView.displayMessage("Enter name:");
                String name = inputView.getUserInput();
                messageView.displayMessage("Enter birth year:");
                int birthYear = Integer.parseInt(inputView.getUserInput());
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
                messageView.displayMessage("Enter file name:");
                saveTree(inputView.getUserInput());
                break;
            case "6":
                messageView.displayMessage("Enter file name:");
                loadTree(inputView.getUserInput());
                break;
            case "0":
                System.exit(0);
            default:
                messageView.displayMessage("Unknown command");
        }
    }

}
