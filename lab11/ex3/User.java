package ex3;

public abstract class User {
    protected ChatRoomMediator mediator;
    protected String name;

    public User(ChatRoomMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        System.out.println(name + " SENDS: " + message);
        mediator.sendMessage(this, message);
    }

    public abstract void receive(String message);
}
