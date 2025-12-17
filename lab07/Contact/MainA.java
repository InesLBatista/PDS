package Praticas.lab07.Contact;
public class MainA{
    public static void main(String[] args) {
        Contact c1 = new Contact("Zorlak Paulino", "910101010", "zorlak@mail.pt");
        Contact c2 = new Contact("Kesha Fan", "960202020", "kesha@mail.pt");
        Contact c3 = new Contact("Perry Neri", "930203022", "Perry@mail.pt");
        
        ContactsStorageInterface textStore = new TextStorage("contacts.txt");
        ContactsStorageInterface binaryStore = new BinaryStorage("contacts.bin");

        ContactsManager manager = new ContactsManager();

        System.out.println("--- Testing Text Storage ---");
        
        manager.openAndLoad(textStore); 
        manager.listAllContacts();


        manager.add(c1); 
        manager.add(c2); 

// Onde a mensagem de verificação é impressa:
System.out.println("Check existence of Perry: " + (manager.exist("Perry Neri") != null));

// Mude para o nome do seu novo c2 ou c1 (Zorlak ou Kesha):
System.out.println("Check existence of Kesha: " + (manager.exist("Kesha Fan") != null));

        System.out.println("Check existence of Zorlak: " + (manager.exist("Zorlak Paulino") != null));

        manager.saveAndClose();

        System.out.println("\n--- Testing Binary Storage ---");
        
        ContactsManager managerBinary = new ContactsManager();
 
        managerBinary.openAndLoad(binaryStore);
        managerBinary.listAllContacts();

        managerBinary.add(c3);

        managerBinary.remove(c1);

        managerBinary.saveAndClose();

        System.out.println("\n--- Final Verification (Reload from Binary) ---");
        ContactsManager finalManager = new ContactsManager();
        finalManager.openAndLoad(binaryStore);
        finalManager.listAllContacts();

        System.out.println("\n--- Saving Binary List to Text File ---");
        finalManager.add(new Contact("New Contact", "111111111", "new@mail.pt"));
        finalManager.saveAndClose(textStore); 
        
        System.out.println("Test complete. Check contacts.txt and contacts.bin files.");
    }
}

