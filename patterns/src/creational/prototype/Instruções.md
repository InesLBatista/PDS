# Sistema de clonagem de documentos
A aplicação deve ser capaz de criar cópias de documentos complexos, permitindo criar novas instâncias a partir de um protótipo existente, sem depender de construtores complexos.

## Contexto
Existem diferentes tipos de documentos:
* Documento de Texto (TextDocument)
* Documento de Planilha (SpreadsheetDocument)
* Documento de Apresentação (PresentationDocument)

Cada documento possui propriedades e conteúdos que podem variar, mas a estrutura base é a mesma. Clonar documentos permite criar rapidamente novas instâncias idênticas a um protótipo, podendo alterar apenas partes específicas após a cópia.

## Requisitos
- Interface Document com método clone() que retorna uma cópia do objeto;
- Classes concretas:
  * TextDocument
  * SpreadsheetDocument
  * PresentationDocument
- Cada classe concreta deve implementar o método clone() e garantir que a cópia é independente do original (deep copy, se necessário);
- Cliente que:
  * Possui um protótipo de documento
  * Cria novas instâncias clonando o protótipo
  * Pode modificar o conteúdo da cópia sem alterar o protótipo

## Objetivo
Implementar o Prototype Pattern para:
* Evitar a criação de objetos complexos usando construtores diretamente;
* Permitir a duplicação rápida de objetos;
* Garantir que as cópias são independentes do protótipo original;
* Facilitar a criação de novas instâncias a partir de exemplos existentes.

## Notas importantes
- O cliente não deve instanciar diretamente classes concretas com new;
- O método clone() deve retornar uma nova instância do mesmo tipo;