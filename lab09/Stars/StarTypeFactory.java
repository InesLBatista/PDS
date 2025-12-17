package lab09.Stars;

import java.util.HashMap;
import java.util.Map;

public class StarTypeFactory {
    private static final Map<Character, StarType> typesCache = new HashMap<>();

    public static StarType getStarType(char type) {
        if (!typesCache.containsKey(type)) {
            StarType starType = null;
            switch (type) {
                case 'O' : starType = new OStar(); break;
                case 'A' : starType = new AStar(); break;
                case 'B' : starType = new BStar(); break;
                case 'F' : starType = new FStar(); break;
                case 'G' : starType = new GStar(); break;
                case 'K' : starType = new KStar(); break;
                case 'M' : starType = new MStar(); break;
            }
            typesCache.put(type, starType);
        }
        return typesCache.get(type); 
    }
    
    public static int getCreatedTypesCount() {
        return typesCache.size();
    }
}