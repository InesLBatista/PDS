package Praticas.lab08.TodosFazem;

public class TeamMember extends EmployeeDecorator {
    public TeamMember(Employee employee) {
        super(employee);
    }

    @Override
    public void work() {
        super.work();
        System.out.println("as TeamMember");
    }

    public void colaborate() {
        System.out.println("TeamMember: working with the team");
    }
}
