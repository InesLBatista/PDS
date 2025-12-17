package Praticas.lab08.TodosFazem;
import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Date now = new Date();

        Employee e=new BaseEmployee("Maria");
        e.start(now);
        e.work();
        System.out.println();

        e=new TeamMember(e);
        e.work();
        ((TeamMember) e).colaborate();
        System.out.println();

        e=new TeamLeader(e);
        e.work();
        ((TeamLeader) e).plan();
        System.out.println();

        e=new Manager(e);
        e.work();
        ((Manager) e).manage();
        System.out.println();

        e.terminate(new Date());
    }
}
