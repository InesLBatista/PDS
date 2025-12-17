package Praticas.lab07.EmpresaPst.Sweets;

import java.util.Vector;

public class DataBase {
    private Vector<Employee> employees;

    public DataBase() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        for (Employee e : employees) {
            if (e.getEmpNum() == employee.getEmpNum())
                return false;
        }
        employees.add(employee);
        return true;
    }

    public void deleteEmployee(long emp_num) {
        employees.removeIf(e -> e.getEmpNum() == emp_num);
    }

    public Employee[] getAllEmployees() {
        return employees.toArray(new Employee[0]);
    }
}
