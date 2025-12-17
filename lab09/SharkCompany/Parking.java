package lab09.SharkCompany;

public class Parking {
    public void allow(Person person) {
        System.out.println("-> [Parking]: Autorização de parque automóvel CONCEDIDA para " + person.getName() + ".");
    }

    public void deny(Person person) {
        System.out.println("-> [Parking]: Autorização de parque automóvel NEGADA para " + person.getName() + ".");
    }
}