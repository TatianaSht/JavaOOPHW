package hw_06.main;

import hw_06.model.FamilyTree;
import hw_06.model.Person;
import hw_06.presenter.CommandHandler;
import hw_06.presenter.TreePresenter;
import hw_06.service.FileOperationsImpl;
import hw_06.view.PresenterView;

public class Main {

    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        PresenterView view = new PresenterView();
        FileOperationsImpl<Person> fileOperations = new FileOperationsImpl<>();
        TreePresenter presenter = new TreePresenter(familyTree,view, view, view, fileOperations);
        CommandHandler commandHandler = new CommandHandler(presenter, view);
        commandHandler.handleUserInput();
    }

}
