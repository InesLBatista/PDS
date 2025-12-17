package ex2;

public class DessertChef extends Chef {
    public DessertChef() {
        super("DessertChef");
    }

    @Override
    public void handleRequest(String request) {
        String lowerRequest = request.toLowerCase();
        
        if (lowerRequest.contains("ice cream") || lowerRequest.contains("waffles") || lowerRequest.contains("dessert") || lowerRequest.contains("sobremesa")) {
            cook(request, 17); 
        } else {
            passToNext(request);
        }
    }
}
