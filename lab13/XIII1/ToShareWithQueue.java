package Praticas.lab13.XIII1;


import java.util.*;

public class ToShareWithQueue extends ToShare {
    private Map<String, Queue<Client>> waitingQueues;
    
    public ToShareWithQueue() {
        super();
        waitingQueues = new HashMap<>();
    }
    
    @Override
    public boolean share(String code, Client user) {
        boolean shared = super.share(code, user);
        
        if (!shared) {
            Queue<Client> queue = waitingQueues.get(code);
            if (queue == null) {
                queue = new LinkedList<>();
                waitingQueues.put(code, queue);
            }
            queue.add(user);
        }
        return shared;
    }
    
    @Override
    public boolean giveBack(String code) {
        boolean givenBack = super.giveBack(code);
        
        if (givenBack) {
            Queue<Client> queue = waitingQueues.get(code);
            if (queue != null && !queue.isEmpty()) {
                Client nextClient = queue.poll();
                if (nextClient != null) {
                    super.share(code, nextClient);
                }
            }
            
            if (queue == null || queue.isEmpty()) {
                waitingQueues.remove(code);
            }
        }
        
        return givenBack;
    }
}