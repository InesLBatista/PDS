# Padrão Bridge - Sistema de Relatórios Flexível

## Objetivo
Implementar o padrão Bridge para criar um sistema de geração de relatórios flexível, cujo objetivo é:
* Separar a abstração (Relatório) da implementação (Formato de saída);
* Permitir combinar qualquer tipo de relatório com qualquer formato de saída;
* Evitar a criação de múltiplas classes duplicadas para cada combinação possível;

## Características principais
* O cliente não depende de classes concretas específicas;
* Cada relatório mantém uma referência a um objeto de formato e delega a exportação a ele;
* Promove flexibilidade e extensibilidade na geração de relatórios;
* Facilita a adição de novos tipos de relatório ou novos formatos sem alterar o código cliente;

## Interfaces e Abstrações
* Abstraction: `Relatorio` com método `gerar()`;
* Implementor: `Formato` com método `exportar(String conteudo)`;
* Ambos permitem combinações flexíveis entre tipos de relatório e formatos de saída;

## Implementações Concretas
* Relatórios: `RelatorioVendas`, `RelatorioEstoque`, `RelatorioFinanceiro`;
* Formatos: `PDF`, `Excel`, `HTML`;
* Cada relatório usa um objeto de formato para exportar seus dados;

## Cliente (Aplicação Principal)
* Cria combinações de relatórios e formatos através das interfaces;
* Pode gerar qualquer combinação sem depender de classes concretas específicas;
* Demonstra a flexibilidade do padrão Bridge no uso real;

## Benefícios do Padrão Bridge
* Separa abstração e implementação para maior flexibilidade;
* Evita classes duplicadas para cada combinação possível;
* Facilita manutenção e expansão do sistema;
* Mantém o cliente desacoplado das implementações concretas.
