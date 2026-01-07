# Sistema de Processamento de Documentos

## Objetivo
Implementar o padrao Visitor para separar algoritmos dos objetos sobre os quais operam, permitindo adicionar novas operacoes sem modificar as classes dos elementos, cujo objetivo e:
- Separar algoritmos das estruturas de objetos sobre as quais operam;
- Permitir adicionar novas operacoes sem modificar as classes dos elementos;
- Agrupar operacoes relacionadas num unico lugar (visitor);
- Facultar a adicao de operacoes que dependem de tipos concretos;

## Contexto
Um sistema de gestao de documentos precisa processar diferentes tipos de documentos (texto, PDF, imagem, planilha, apresentacao). Cada tipo de documento requer operacoes especificas de exportacao, validacao, compressao e conversao. Em vez de adicionar metodos a cada classe de documento, deve-se:
1. Separar as operacoes das classes dos documentos
2. Criar visitors para cada tipo de operacao
3. Permitir adicionar novas operacoes sem modificar documentos existentes
4. Facilitar a aplicacao de operacoes a colecoes de documentos

## Requisitos

### Interface elemento
- Documento: com metodos:
  - void aceitar(Visitor visitor)
  - String getTipo()
  - long getTamanho()
  - String getFormato()
  - String getNome()
  - void setNome(String nome)

### Elementos concretos
- DocumentoTexto: representa documentos de texto
- DocumentoPDF: representa documentos PDF
- DocumentoImagem: representa documentos de imagem
- DocumentoPlanilha: representa documentos de planilha
- DocumentoApresentacao: representa documentos de apresentacao

### Interface visitor
- Visitor: com metodos:
  - void visitar(DocumentoTexto documento)
  - void visitar(DocumentoPDF documento)
  - void visitar(DocumentoImagem documento)
  - void visitar(DocumentoPlanilha documento)
  - void visitar(DocumentoApresentacao documento)

### Visitors concretos
- VisitorExportacao: realiza operacoes de exportacao
- VisitorValidacao: realiza operacoes de validacao
- VisitorCompressao: realiza operacoes de compressao
- VisitorConversao: realiza operacoes de conversao
- VisitorRelatorio: gera relatorios sobre documentos

### Estrutura de objetos
- ColecaoDocumentos: mantem colecao de documentos
  - Permite adicionar e remover documentos
  - Aplica visitor a todos os documentos
  - Fornece metodos de gestao da colecao

### Cliente (sistema de gestao)
- Cria documentos especificos
- Aplica visitors as colecoes de documentos
- Pode adicionar novos visitors sem modificar documentos
- Processa documentos usando visitors apropriados

## Restricoes
- As classes de documento nao devem conter logica de processamento
- Novas operacoes devem ser adicionadas apenas criando novos visitors
- Visitors devem poder operar sobre diferentes tipos de documentos
- A estrutura de documentos deve permanecer estavel
- Visitors podem depender dos tipos concretos dos documentos

## Cenario de utilizacao
O sistema deve permitir:
1. Criar uma colecao de documentos de diferentes tipos
2. Aplicar diferentes visitors a colecao (exportacao, validacao, etc.)
3. Processar cada documento de acordo com o seu tipo especifico
4. Adicionar novas operacoes criando novos visitors
5. Manter a estrutura de documentos inalterada ao adicionar funcionalidades
6. Processar documentos de forma polimorfica atraves dos visitors