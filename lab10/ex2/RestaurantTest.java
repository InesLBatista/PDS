package ex2;

public class RestaurantTest {
    
    public static void main(String[] args) {

        Chef sushiChef = new SushiChef();
        Chef pastaChef = new PastaChef();
        Chef burgerChef = new BurgerChef();
        Chef pizzaChef = new PizzaChef();
        Chef dessertChef = new DessertChef();
        
        sushiChef.setNextChef(pastaChef);
        pastaChef.setNextChef(burgerChef);
        burgerChef.setNextChef(pizzaChef);
        pizzaChef.setNextChef(dessertChef); 

        String req1 = "veggie burger";
        System.out.println("Can I please get a " + req1 + "?");
        sushiChef.handleRequest(req1);
        System.out.println("---");

        String req2 = "Pasta Carbonara";
        System.out.println("Can I please get a " + req2 + "?");
        sushiChef.handleRequest(req2);
        System.out.println("---");

        String req3 = "PLAIN pizza, no toppings!";
        System.out.println("Can I please get a " + req3 + "?");
        sushiChef.handleRequest(req3);
        System.out.println("---");
        
        String req4 = "sushi nigiri and sashimi";
        System.out.println("Can I please get a " + req4 + "?");
        sushiChef.handleRequest(req4);
        System.out.println("---");

        String req5 = "salad with tuna";
        System.out.println("Can I please get a " + req5 + "?");
        sushiChef.handleRequest(req5);
        System.out.println("---");

        String req6 = "strawberry ice cream and waffles dessert";
        System.out.println("Can I please get a " + req6 + "?");
        sushiChef.handleRequest(req6);
    }
}