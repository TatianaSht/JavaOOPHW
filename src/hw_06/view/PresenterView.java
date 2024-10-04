package hw_06.view;

import hw_06.model.Person;
import hw_06.presenter.TreePresenter;

import java.util.List;
import java.util.Scanner;

public class PresenterView implements TreeView {

    private TreePresenter presenter;
    private Scanner scanner;
    public PresenterView() {
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    @Override
    public void displayPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person.getName() + ", born in " + person.getBirthYear());
        }
    }
    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }
    @Override
    public void setPresenter(TreePresenter presenter) {
        this.presenter = presenter;
    }


}
