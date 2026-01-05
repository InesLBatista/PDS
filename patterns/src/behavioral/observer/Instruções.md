# Padrão Observer - Sistema de Notificações Meteorológicas

## Objetivo
Implementar o padrão Observer para notificar múltiplos objetos sobre mudanças de estado, cujo objetivo é:
- Definir uma dependência um-para-muitos entre objetos;
- Notificar automaticamente todos os objetos dependentes quando um objeto muda de estado;
- Promover baixo acoplamento entre objetos que interagem;

## Contexto
Um sistema de informações meteorológicas precisa notificar diferentes tipos de dispositivos sobre mudanças nas condições do tempo. Em vez de cada dispositivo verificar constantemente as condições, deve-se criar um sistema onde:
1. Uma estação meteorológica (sujeito) recolhe dados do tempo
2. Vários dispositivos (observadores) são registados para receber actualizações
3. Quando as condições mudam, todos os dispositivos são notificados automaticamente
4. Dispositivos podem registar-se e cancelar registo dinamicamente

## Requisitos

### Interface sujeito
- EstacaoMeteorologica: com métodos:
  - `void registarObservador(Observador observador)`
  - `void removerObservador(Observador observador)`
  - `void notificarObservadores()`

### Interface observador
- Observador: com método:
  - `void atualizar(float temperatura, float humidade, float pressao)`

### Observadores concretos
- DisplayCondicoesAtuais: exibe condições actuais
- DisplayEstatisticas: exibe estatísticas (médias, máximos, mínimos)
- DisplayPrevisao: exibe previsão baseada em tendências
- AlertaTemperatura: emite alertas quando temperatura atinge limites

### Dados meteorológicos
- Temperatura (em graus Celsius)
- Humidade (em percentagem)
- Pressão atmosférica (em hPa)

### Cliente (sistema meteorológico)
- Cria estação meteorológica e dispositivos
- Regista dispositivos na estação
- Simula mudanças nas condições do tempo
- Mostra notificações automáticas
- Permite adicionar/remover dispositivos dinamicamente

## Restrições
- Os observadores não devem conhecer outros observadores
- O sujeito não deve conhecer detalhes específicos dos observadores
- Observadores podem registar-se e cancelar a qualquer momento
- Notificações devem ser enviadas apenas quando dados mudam
- Sistema deve suportar diferentes tipos de observadores

## Cenário de utilização
O sistema deve permitir:
1. Estação meteorológica mede novas condições
2. Todos os displays registados são actualizados automaticamente
3. Novo display pode ser adicionado em tempo de execução
4. Display pode ser removido quando não é mais necessário
5. Alertas são emitidos quando condições perigosas são detectadas
6. Cada display mostra informações de forma diferente
