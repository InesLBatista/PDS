# Desenvolver um sistema de relatórios flexível
A aplicação precisa gerar relatórios em diferentes formatos e com diferentes tipos de dados, de forma que seja possível combinar qualquer formato com qualquer tipo de dado sem criar classes duplicadas.

## Contexto
Existem diferentes tipos de dados para os relatórios:
* Vendas;
* Estoque;
* Financeiro;

Existem diferentes formatos de saída:
* PDF;
* Excel;
* HTML;

Cada relatório deve:
* combinar um tipo de dado com um formato de saída;
* implementar uma interface comum de relatório;

## Requisitos
- Criar uma interface `Relatorio` com um método: `void gerar()`;
- Criar uma interface `Formato` com um método: `void exportar(String conteudo)`;
- Criar classes concretas para cada tipo de dado: `RelatorioVendas`, `RelatorioEstoque`, `RelatorioFinanceiro`;
- Criar classes concretas para cada formato de saída: `PDF`, `Excel`, `HTML`;
- Cada relatório deve manter uma referência a um objeto `Formato` e usar esse objeto para exportar os dados;
- A aplicação principal não pode depender de combinações concretas de relatório e formato. Ela deve instanciar qualquer combinação através da interface abstrata `Relatorio` e da interface `Formato`;
- O sistema deve permitir a fácil adição de novos tipos de dados ou novos formatos sem alterar o código cliente.
