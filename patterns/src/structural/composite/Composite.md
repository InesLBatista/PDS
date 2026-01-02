# Padrão Composite - Sistema de Gerenciamento de Arquivos

## Objetivo
Implementar o padrão Composite para criar um sistema de gerenciamento de arquivos e pastas, cujo objetivo é:
* Tratar arquivos e pastas de forma uniforme;
* Permitir criar hierarquias arbitrárias de pastas e arquivos;
* Facilitar operações em grupos de objetos de forma transparente;

## Características principais
* O cliente não precisa diferenciar entre arquivos e pastas ao realizar operações;
* Cada pasta pode conter arquivos e outras pastas de forma recursiva;
* Promove simplicidade e flexibilidade no tratamento de estruturas hierárquicas;
* Facilita a manutenção e expansão do sistema sem alterar o código cliente;

## Interfaces e Abstrações
* Component: `Item` com método `mostrar(int nivel)`;
* Leaf: `Arquivo`, representa os objetos finais sem filhos;
* Composite: `Pasta`, representa objetos que podem ter filhos e delegam operações a eles;

## Implementações Concretas
* Arquivo: representa um arquivo individual no sistema;
* Pasta: representa uma pasta que pode conter arquivos e outras pastas;
* Ambas implementam a interface `Item`, permitindo tratamento uniforme;

## Cliente (Aplicação Principal)
* Cria arquivos e pastas e os organiza em hierarquias;
* Pode chamar operações (como `mostrar`) em qualquer objeto `Item` sem diferenciar tipos;
* Demonstra a flexibilidade do padrão Composite em estruturas recursivas;

## Cenário de Uso
O sistema deve permitir:
1. Criar arquivos individuais;
2. Criar pastas contendo arquivos e outras pastas;
3. Exibir toda a hierarquia de arquivos e pastas;
4. Adicionar ou remover arquivos e pastas de qualquer nível da hierarquia;

## Benefícios do Padrão Composite
* Permite tratar objetos individuais e composições de forma uniforme;
* Facilita operações em estruturas complexas sem duplicar código;
* Mantém o cliente desacoplado das implementações concretas;
* Suporta facilmente a expansão futura de tipos de itens.
