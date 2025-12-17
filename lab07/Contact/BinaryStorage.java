package Praticas.lab07.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryStorage implements ContactsStorageInterface {
    private final String filename;

    public BinaryStorage(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Contact> loadContacts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            List<Contact> contacts = (List<Contact>) ois.readObject();
            return contacts;
        } catch (FileNotFoundException e) {
            System.err.println("Binary file not found, starting with empty list: " + filename);
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading contacts from binary file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            return true;
        } catch (IOException e) {
            System.err.println("Error writing contacts to binary file: " + e.getMessage());
            return false;
        }
    }
}