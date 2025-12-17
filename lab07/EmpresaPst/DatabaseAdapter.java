package Praticas.lab07.EmpresaPst;
import Praticas.lab07.EmpresaPst.Sweets.*;

// DatabaseAdapter é o 'Adapter' que implementa a interface comum.
public class DatabaseAdapter implements ICompany {
    private DataBase db; // O Adapter contém uma referência à classe Adaptee (DataBase).
    public DatabaseAdapter (DataBase db) {
        this.db = db;
    }

    @Override
    public void addEmployee(long id, String nome, String apelido, double salario) {
        // O método 'addEmployee' do Adapter traduz a chamada para o método do Adaptee.
        db.addEmployee(new Employee(nome, id, salario));
    }

    @Override
    public void removeEmployee(long id) {
        // O Adapter mapeia a interface unificada para a funcionalidade específica do Adaptee.
        db.deleteEmployee(id);
    }

    @Override
    public boolean existsEmployee(long id) {
        // O Adapter implementa a lógica necessária para preencher a lacuna da interface.
        for (Employee e : db.getAllEmployees()) {
            if (e.getEmpNum() == id) return true;
        }
        return false;
    }

    @Override
    public void printAllEmployees() {
        // O Adapter utiliza a funcionalidade existente do Adaptee para completar a tarefa.
        for (Employee e : db.getAllEmployees()) {
            System.out.println(e);
        }
    }
}