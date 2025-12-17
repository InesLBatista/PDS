package Praticas.lab08.TodosFazem;
import java.util.*;

public class BaseEmployee implements Employee {
    private final String name;

    public BaseEmployee (String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }   

    @Override
    public void start(Date d) {
        System.out.println(name + " started working on " + d);
    }

    @Override
    public void terminate(Date d) {
        System.out.println(name + " finished working on " + d);
    }

    @Override
    public void work() {
        System.out.println(name + " is working");
    }
}
