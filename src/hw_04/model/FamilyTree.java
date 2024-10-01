package hw_04.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T> implements Serializable, Iterable<T>{

    private static final long serialVersionUID = 1L;
    private final List<T> members;
    public FamilyTree() {
        this.members = new ArrayList<>();
    }
    public void addMember(T member) {
        this.members.add(member);
    }
    public List<T> getMembers() {
        return members;
    }
    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        if (members.get(0) instanceof Person) {
            Collections.sort(members, (p1, p2) ->
                    p2.toString().compareTo(p1.toString()));
        }
    }


    public void sortByBirthYear() {
        if (members.get(0) instanceof Person) {
            Collections.sort(members, (p1, p2) ->
                    Integer.compare(((Person) p2).getBirthYear(), ((Person)
                            p1).getBirthYear()));
        }
    }

}
