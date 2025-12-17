package Praticas.lab08.TodosFazem;
import java.util.*;

public abstract class EmployeeDecorator implements Employee {
    protected final Employee employee;

    protected EmployeeDecorator(Employee employee) {
        this.employee=employee;
    }

    @Override
    public void start(Date d) {
        employee.start(d);
    }

    @Override
    public void terminate(Date d) {
        employee.terminate(d);
    }

    @Override
    public void work() {
        employee.work();
    }
}
