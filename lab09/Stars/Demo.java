package lab09.Stars; 

import java.awt.Color; 

public class Demo {
    static int CANVAS_SIZE = 1200;
    static int STARS_TO_DRAW = 1000000;
    
    public static void main(String[] args) {
        Sky sky = new Sky();

        char[] starTypes = {'O', 'B', 'A', 'F', 'G', 'K', 'M'};
        char typeChar;

        Runtime runtime = Runtime.getRuntime();
        long before = runtime.totalMemory() - runtime.freeMemory();

        for (int i = 0; i < STARS_TO_DRAW; i++) {
            typeChar = starTypes[random(0, starTypes.length-1)];
            
            StarType flyweightType = StarTypeFactory.getStarType(typeChar);

            int x = random(0, CANVAS_SIZE);
            int y = random(0, CANVAS_SIZE);
            Star star = new Star(x, y, flyweightType);
            
            sky.placeStar(star); 
        }

        sky.setSize(CANVAS_SIZE, CANVAS_SIZE);
        sky.setBackground(Color.BLACK);
        sky.setVisible(true);

        long after = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory: " + (after - before) / 1024 / 1024 + " MB");
        System.out.println("Flyweights criados (de 7 esperados): " + StarTypeFactory.getCreatedTypesCount());

    }

	private static int random(int min, int max) { 
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}