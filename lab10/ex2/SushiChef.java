package ex2;

public class SushiChef extends Chef {
    public SushiChef() {
        super("SushiChef");
    }

    @Override
    public void handleRequest(String request) {
        String lowerRequest = request.toLowerCase();

        if (lowerRequest.contains("sushi") || lowerRequest.contains("nigiri") || lowerRequest.contains("sashimi")) {
            cook(request, 14); 
        } else {
            passToNext(request);
        }
    }
}