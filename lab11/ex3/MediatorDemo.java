package ex3;
public class MediatorDemo {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User joana = new ChatUser(chatRoom, "Joana");
        User pedro = new ChatUser(chatRoom, "Pedro");
        User ana = new ChatUser(chatRoom, "Ana");

        chatRoom.addUser(joana);
        chatRoom.addUser(pedro);
        chatRoom.addUser(ana);

        joana.send("Olá a todos! Começamos o trabalho?");

        pedro.send("Sim, Joana. Já estou pronto.");
    }
}