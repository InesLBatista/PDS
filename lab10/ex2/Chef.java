
package ex2; 
public abstract class Chef {
    
    protected Chef nextChef; 
    protected String name;

    public Chef(String name) {
        this.name = name;
    }

    public void setNextChef(Chef nextChef) {
        this.nextChef = nextChef;
    }

    public abstract void handleRequest(String request);

    protected void passToNext(String request) {
        System.out.println(name + ": I can't cook that.");
        
        if (nextChef != null) {
            nextChef.handleRequest(request);
        } else {
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }

    protected void cook(String request, int minutes) {
        System.out.println(name + ": Starting to cook " + request + ". Out in " + minutes + " minutes!");
    }
}