package Praticas.lab07.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsManager implements ContactsInterface {
    private List<Contact> contacts;
    private ContactsStorageInterface currentStore;

    public ContactsManager() {
        this.contacts = new ArrayList<>();
        this.currentStore = null;
    }

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        this.currentStore = store;
        this.contacts = store.loadContacts();
        System.out.println("Loaded " + contacts.size() + " contacts.");
    }

    @Override
    public void saveAndClose() {
        if (currentStore != null) {
            saveContacts(currentStore);
        } else {
            System.err.println("No storage interface set for saving.");
        }
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        saveContacts(store);
    }

    private void saveContacts(ContactsStorageInterface store) {
        if (store.saveContacts(contacts)) {
            System.out.println("Saved " + contacts.size() + " contacts successfully.");
        } else {
            System.err.println("Failed to save contacts.");
        }
    }

    @Override
    public Contact exist(String contactName) {
        return getByName(contactName);
    }

    @Override
    public Contact getByName(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact) {
        if (exist(contact.getName()) == null) {
            contacts.add(contact);
            System.out.println("Contact added: " + contact.getName());
            return true;
        }
        System.out.println("Contact already exists: " + contact.getName());
        return false;
    }

    @Override
    public boolean remove(Contact contact) {
        boolean removed = contacts.remove(contact);
        if (removed) {
            System.out.println("Contact removed: " + contact.getName());
        } else {
            System.out.println("Contact not found for removal: " + contact.getName());
        }
        return removed;
    }
    public void listAllContacts() {
        System.out.println("\n--- Current Contact List (" + contacts.size() + " total) ---");
        if (contacts.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
        System.out.println("----------------------------------------");
    }
}
