package ex2;

public class PastaChef extends Chef {
    public PastaChef() {
        super("PastaChef");
    }

    @Override
    public void handleRequest(String request) {
        String lowerRequest = request.toLowerCase();

        if (lowerRequest.contains("pasta") || lowerRequest.contains("carbonara") || lowerRequest.contains("spaghetti")) {
            cook(request, 14); 
        } else {
            passToNext(request);
        }
    }
}
