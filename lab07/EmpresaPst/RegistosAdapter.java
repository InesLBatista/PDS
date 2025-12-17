package Praticas.lab07.EmpresaPst;
import Praticas.lab07.EmpresaPst.Petiscos.*;

// RegistosAdapter é o segundo 'Adapter', permitindo que o sistema 'Petiscos' use a interface 'ICompany'.
public class RegistosAdapter implements ICompany {
    private Registos reg; // O Adapter armazena o objeto 'Registos', o seu 'Adaptee'.
    public RegistosAdapter(Registos reg) {
        this.reg = reg;
    }

    @Override
    public void addEmployee(long id, String nome, String apelido, double salario) {
        // O Adapter traduz a interface unificada (long id) para o tipo esperado pelo Adaptee (int codigo).
        reg.insere(new Empregado(nome, apelido, (int)id, salario));
    }

    @Override
    public void removeEmployee(long id) {
        // O método unificado 'removeEmployee' é adaptado para o método do Adaptee 'remove'.
        reg.remove((int)id);
    }

    @Override
    public boolean existsEmployee(long id) {
        // O Adapter converte o método 'isEmpregado' do Adaptee para o método 'existsEmployee' da interface.
        return reg.isEmpregado((int)id);
    }

    @Override
    public void printAllEmployees() {
        // O Adapter itera sobre a lista do Adaptee e usa o seu método toString para impressão.
        for (Empregado e : reg.listaDeEmpregados()) {
            System.out.println(e);
        }
    }
}