package Praticas.lab07.Contact;


public interface ContactsInterface {
    public void openAndLoad(ContactsStorageInterface store);
    public void saveAndClose();
    public void saveAndClose(ContactsStorageInterface store);
    public Contact exist(String contactName);
    public Contact getByName(String name);
    public boolean add(Contact contact);
    public boolean remove(Contact contact);
}