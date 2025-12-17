package Praticas.lab07.Contact;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextStorage implements ContactsStorageInterface {
    private final String filename;

    public TextStorage(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t"); 
                if (parts.length == 3) {
                    contacts.add(new Contact(parts[0], parts[1], parts[2]));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found, starting with empty list: " + filename);
        } catch (Exception e) {
            System.err.println("Error reading contacts from text file: " + e.getMessage());
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Contact contact : list) {
                writer.println(contact.toString()); 
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing contacts to text file: " + e.getMessage());
            return false;
        }
    }
}