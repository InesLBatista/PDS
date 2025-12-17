package Praticas.lab08.TodosFazem;

public class Manager extends EmployeeDecorator {
    public Manager(Employee employee) {
        super(employee);
    }

    @Override
    public void work() {
        super.work();
        System.out.println("as Manager");
    }

    public void manage() {
        System.out.println("Manager: manages the teams resources and members");
    }
}
