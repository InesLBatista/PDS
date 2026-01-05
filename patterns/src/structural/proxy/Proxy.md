# Padrão Proxy - Sistema de Acesso a Documentos Sensíveis

## Objetivo
Implementar o padrão Proxy para controlar o acesso a documentos confidenciais, cujo objetivo é:
- Adicionar uma camada de controlo entre o cliente e o objeto real;
- Gerir o acesso, cache ou lazy loading de forma transparente;
- Proporcionar funcionalidades adicionais sem modificar o objeto original;

## Características principais
- O cliente trabalha com uma interface comum, não sabendo se está a lidar com o objeto real ou com um proxy;
- Cada proxy adiciona funcionalidades específicas de forma independente;
- Os proxies podem ser combinados (decorator pattern) para funcionalidades múltiplas;
- O objecto real permanece inalterado e focado na sua responsabilidade principal;

## Componentes do sistema

### Interface comum
- Documento: Interface que define as operações disponíveis
  - `mostrar()`: Exibe o conteúdo do documento
  - `getTitulo()`: Retorna o título
  - `getConteudo()`: Retorna o conteúdo completo

### Objecto real
- DocumentoReal: Implementação concreta que:
  - Carrega documentos do sistema (operação pesada)
  - Processa conteúdo (descriptografia, formatação)
  - Implementa lazy loading interno para o conteúdo

### Proxies especializados
- ProxySegurança: Controla acesso baseado em permissões
- ProxyCache: Optimiza performance através de cache
- ProxyLogging: Regista operações para auditoria
- ProxyVirtual: Implementa lazy loading a nível de objeto

### Cliente (sistema)
- Interage apenas com a interface `Documento`
- Não conhece a implementação subjacente
- Pode usar diferentes proxies sem alterar o código