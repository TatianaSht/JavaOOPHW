package hw_06.view;

import hw_06.model.Person;
import hw_06.presenter.TreePresenter;

import java.util.List;

public interface TreeView extends MessageView, PersonView, InputView{

    void displayPersons(List<Person> persons);

    void setPresenter(TreePresenter presenter);
}
