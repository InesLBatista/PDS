package ex2;

public class PizzaChef extends Chef {
    public PizzaChef() {
        super("PizzaChef");
    }

    @Override
    public void handleRequest(String request) {
        String lowerRequest = request.toLowerCase();

        if (lowerRequest.contains("pizza")) {
            cook(request, 7); 
        } else {
            passToNext(request);
        }
    }
}
