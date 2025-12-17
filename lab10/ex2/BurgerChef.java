package ex2;

public class BurgerChef extends Chef {
    public BurgerChef() {
        super("BurgerChef");
    }

    @Override
    public void handleRequest(String request) {
        String lowerRequest = request.toLowerCase();
        
        if (lowerRequest.contains("burger") || lowerRequest.contains("hambúrguer")) {
            cook(request, 19); 
        } else {
            passToNext(request);
        }
    }
}