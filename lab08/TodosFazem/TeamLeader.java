package Praticas.lab08.TodosFazem;

public class TeamLeader extends EmployeeDecorator {
    public TeamLeader(Employee employee) {
        super(employee);
    }

    @Override
    public void work() {
        super.work();
        System.out.println("as TeamLeader");
    }

    public void plan() {
        System.out.println("TeamLeader: planning the teams activities");
    }
}
