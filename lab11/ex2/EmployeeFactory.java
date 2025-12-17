package ex2;
public class EmployeeFactory {
    public static final String[] names = { "Mac", "Linux", "Win" };
    
    public static Employee getEmployee (String name) {
        for (String validName : names) {
            if (validName.equalsIgnoreCase(name)) {
                return new Programmer (name); 
            }
        }
        return new NullEmployee();
    }
}