# Padrão Observer - Sistema de Notificações Meteorológicas

## Características principais
- Um sujeito mantém uma lista de observadores;
- Observadores registam-se no sujeito para receber actualizações;
- Quando o estado do sujeito muda, todos os observadores são notificados;
- Observadores podem registar-se e remover-se dinamicamente;

## Componentes do sistema

### Interface observador
- Observador: Interface que todos os observadores devem implementar
  - `atualizar()`: Método chamado quando o sujeito muda de estado

### Interface sujeito
- Sujeito: Interface que todos os sujeitos devem implementar
  - `registarObservador()`: Adiciona um observador à lista
  - `removerObservador()`: Remove um observador da lista
  - `notificarObservadores()`: Notifica todos os observadores registados

### Implementação concreta do sujeito
- EstacaoMeteorologica: Gerencia dados meteorológicos e observadores
  - Mantém lista de observadores registados
  - Actualiza dados meteorológicos
  - Notifica observadores quando dados mudam
  - Optimiza notificações (só notifica quando há mudanças)

### Observadores concretos
- DisplayCondicoesAtuais: Exibe condições meteorológicas actuais
- DisplayEstatisticas: Calcula e exibe estatísticas
- DisplayPrevisao: Faz previsões baseadas em tendências
- AlertaTemperatura: Emite alertas quando limites são ultrapassados
