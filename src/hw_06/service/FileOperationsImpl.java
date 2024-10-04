package hw_06.service;

import hw_06.model.FamilyTree;
import hw_06.model.Person;

import java.io.*;

public class FileOperationsImpl<T extends Person> implements FileOperations<T> {

    @Override
    public void saveToFile(FamilyTree<T> familyTree, String
            fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }
    @Override
    public FamilyTree<T> loadFromFile(String fileName) throws
            IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new
                FileInputStream(fileName))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }

}
