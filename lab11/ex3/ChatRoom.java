package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ChatRoom implements ChatRoomMediator {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(User sender, String message) {
        String time = new Date().toString();
        String fullMessage = "(" + time + ") [" + sender.getName() + "]: " + message;

        for (User user : users) {
            if (user != sender) { 
                user.receive(fullMessage);
            }
        }
    }
}
