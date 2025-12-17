package lab09.SharkCompany;

public class CardService {
    public void createCard(Person person) {
        System.out.println("-> [CardService]: Cartão de funcionário criado para " + person.getName() + ".");
    }
}