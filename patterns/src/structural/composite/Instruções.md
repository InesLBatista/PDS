# Desenvolver um sistema de gerenciamento de arquivos e pastas
A aplicação precisa gerenciar arquivos e pastas em uma estrutura hierárquica, permitindo que pastas contenham arquivos e outras pastas.

## Contexto
Existem diferentes itens no sistema:
* Arquivo;
* Pasta;

Cada item deve:
* poder ser exibido com seu nome;
* permitir operações uniformes mesmo que seja um arquivo ou uma pasta;
* permitir que pastas contenham outros itens de forma recursiva;

## Requisitos
- Criar uma interface `Item` com um método: `void mostrar(int nivel);`
- Criar classes concretas para os itens folha: `Arquivo`;
- Criar classes concretas para itens compostos: `Pasta`;
    * pastas podem conter arquivos ou outras pastas;
    * permitir adicionar e remover itens filhos;
- A aplicação principal não pode diferenciar arquivos de pastas ao exibir ou manipular os itens;
- O sistema deve permitir a fácil adição de novos tipos de itens sem alterar o código cliente.
