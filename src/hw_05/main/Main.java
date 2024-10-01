package hw_05.main;

import hw_05.model.FamilyTree;
import hw_05.model.Person;
import hw_05.presenter.TreePresenter;
import hw_05.view.ConsoleTreeView;
import hw_05.view.FileOperationsImpl;

public class Main {

    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        ConsoleTreeView view = new ConsoleTreeView();
        FileOperationsImpl<Person> fileOperations = new
                FileOperationsImpl<>();
        TreePresenter presenter = new TreePresenter(familyTree,
                view, fileOperations);
        presenter.handleUserInput();
    }
}
