# Sistema de Acesso a Documentos Sensíveis

## Objectivo
Implementar o padrão Proxy para controlar o acesso a documentos confidenciais, cujo objetivo é:
* Adicionar uma camada de controlo entre o cliente e o objecto real;
* Gerir o acesso, cache ou lazy loading de forma transparente;
* Proporcionar funcionalidades adicionais sem modificar o objecto original;

## Contexto
Um sistema corporativo precisa de controlar o acesso a documentos confidenciais. Alguns documentos são públicos, outros requerem autenticação, e alguns são restritos apenas a administradores. Em vez de modificar a classe DocumentoReal, deve-se criar um proxy que:
1. Verifica permissões antes de permitir o acesso
2. Faz cache do conteúdo para melhorar performance
3. Regista todas as operações de acesso para auditoria
4. Implementa lazy loading (carrega apenas quando necessário)

## Requisitos

### 1. Interface Comum:
* Documento: com métodos:
  * `void mostrar()` - exibe o conteúdo do documento
  * `String getTitulo()` - retorna o título do documento
  * `String getConteudo()` - retorna o conteúdo (após verificação)

### 2. Objecto Real:
* DocumentoReal: implementação concreta que:
  * Carrega o documento do sistema de ficheiros/database
  * Processa o conteúdo (descriptografa, formata, etc.)
  * É uma operação pesada e lenta

### 3. Proxies (Diferentes tipos):
* ProxySegurança: verifica permissões do utilizador
* ProxyCache: faz cache do conteúdo para evitar carregamentos repetidos
* ProxyLogging: regista todas as operações de acesso
* ProxyVirtual (Lazy Loading): carrega o documento apenas quando necessário

### 4. Cliente (Sistema Corporativo):
* Interage apenas com a interface Documento
* Não sabe se está a lidar com o objecto real ou com um proxy
* Pode combinar múltiplos proxies (decorator pattern com proxies)

## Restrições
* O cliente não deve modificar a classe DocumentoReal
* O acesso a documentos restritos deve ser negado sem autenticação apropriada
* O cache deve ser transparente para o cliente
* Todas as operações devem ser registadas para auditoria
* O lazy loading deve optimizar a performance