package hw_06.service;

import hw_06.model.FamilyTree;
import hw_06.model.Person;

import java.io.IOException;

public interface FileOperations<T extends Person> {

    void saveToFile(FamilyTree<T> familyTree, String fileName)
            throws IOException;
    FamilyTree<T> loadFromFile(String fileName) throws IOException,
            ClassNotFoundException;

}
