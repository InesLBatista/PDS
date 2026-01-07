# Padrao Visitor - Sistema de Processamento de Documentos

## Objetivo
Implementar o padrao Visitor para separar algoritmos dos objetos sobre os quais operam, permitindo adicionar novas operacoes sem modificar as classes dos elementos, cujo objetivo e:
- Separar algoritmos das estruturas de objetos sobre as quais operam;
- Permitir adicionar novas operacoes sem modificar as classes dos elementos;
- Agrupar operacoes relacionadas num unico lugar (visitor);
- Facultar a adicao de operacoes que dependem de tipos concretos;

## Caracteristicas principais
- Separa algoritmos da estrutura de objetos;
- Permite adicionar novas operacoes sem alterar classes existentes;
- Agrupa operacoes relacionadas numa classe visitor;
- Facilita a adicao de operacoes que dependem de tipos concretos;
- Permite operacoes sobre hierarquias de objetos complexas;

## Componentes do sistema

### Interface elemento
- Documento: Interface comum a todos os elementos visitaveis
  - aceitar(Visitor visitor): Metodo que permite ao visitor visitar o elemento
  - getTipo(): Retorna o tipo do documento
  - getTamanho(): Retorna o tamanho do documento
  - getFormato(): Retorna o formato do documento
  - getNome(): Retorna o nome do documento
  - setNome(String nome): Define o nome do documento

### Elementos concretos
- DocumentoTexto: Representa documentos de texto
- DocumentoPDF: Representa documentos PDF
- DocumentoImagem: Representa documentos de imagem
- DocumentoPlanilha: Representa documentos de planilha
- DocumentoApresentacao: Representa documentos de apresentacao

### Interface visitor
- Visitor: Interface para todos os visitors
  - visitar(DocumentoTexto documento): Visita documento de texto
  - visitar(DocumentoPDF documento): Visita documento PDF
  - visitar(DocumentoImagem documento): Visita documento de imagem
  - visitar(DocumentoPlanilha documento): Visita documento de planilha
  - visitar(DocumentoApresentacao documento): Visita documento de apresentacao

### Visitors concretos
- VisitorExportacao: Realiza operacoes de exportacao de documentos
- VisitorValidacao: Realiza operacoes de validacao de documentos
- VisitorCompressao: Realiza operacoes de compressao de documentos
- VisitorConversao: Realiza operacoes de conversao de formatos
- VisitorRelatorio: Gera relatorios sobre os documentos

### Estrutura de objetos
- ColecaoDocumentos: Mantem colecao de documentos
  - adicionarDocumento(Documento documento): Adiciona documento a colecao
  - removerDocumento(Documento documento): Remove documento da colecao
  - aceitarVisitor(Visitor visitor): Aplica visitor a todos os documentos

## Pontos chave do padrao
- Dupla despacho: O elemento aceita o visitor e o visitor visita o elemento
- Separacao de preocupacoes: Operacoes separadas da estrutura de dados
- Extensibilidade: Novas operacoes sem modificar elementos existentes
- Acoplamento reduzido: Visitors conhecem tipos concretos, elementos nao conhecem visitors
- Operacoes agregadas: Operacoes relacionadas ficam juntas no visitor

## Vantagens
- Adiciona novas operacoes sem modificar classes de elementos
- Agrupa operacoes relacionadas numa unica classe
- Permite operacoes que dependem de tipos concretos
- Facilita a adicao de operacoes a hierarquias complexas
- Separa algoritmos da estrutura de dados

## Aplicabilidade
- Quando uma estrutura de objetos contem muitas classes com interfaces diferentes
- Quando muitas operacoes distintas e nao relacionadas precisam ser realizadas sobre objetos
- Quando as classes da estrutura raramente mudam, mas novas operacoes sao frequentemente adicionadas
- Quando se quer evitar "poluicao" das classes com muitos metodos nao relacionados