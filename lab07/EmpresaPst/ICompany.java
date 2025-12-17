package Praticas.lab07.EmpresaPst;

public interface ICompany {
    void addEmployee(long id, String nome, String apelido, double salario);
    void removeEmployee(long id);
    boolean existsEmployee(long id);
    void printAllEmployees();
}
