package ex3;

public class ChatUser extends User {
    public ChatUser(ChatRoomMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receive(String message) {
        System.out.println("[" + name + " RECEIVES]: " + message);
    }
}