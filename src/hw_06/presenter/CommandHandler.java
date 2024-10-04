package hw_06.presenter;

import hw_06.view.PresenterView;

public class CommandHandler {

    private TreePresenter presenter;
    private PresenterView view;
    public CommandHandler(TreePresenter presenter, PresenterView view) {
        this.presenter = presenter;
        this.view = view;
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
            presenter.handleCommand(command);
        }
    }



}
