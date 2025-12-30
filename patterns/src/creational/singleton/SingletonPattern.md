# Padrão Singleton - Sistema de Logger Global

## Objetivo
Implementar o padrão Singleton para criar um sistema de logging centralizado, cujo objetivo é:
* Garantir que apenas uma instância do Logger exista em todo o sistema;
* Fornecer um ponto de acesso global à instância única;
* Evitar inconsistências e duplicação de mensagens de log;

## Características principais:
* O cliente não instancia diretamente a classe Logger usando `new`;
* A classe controla sua própria instanciação;
* O padrão promove controle centralizado: todas as partes do sistema usam a mesma instância;
* Thread-safe para uso em ambientes concorrentes;

## Sistema de Logger Global
* Classe Logger: `public class Logger { ... }`
    * Construtor privado para prevenir instanciação externa
    * Método estático `getInstancia()` para acesso global
    * Métodos de log: `log()`, `info()`, `warning()`, `error()`
* Implementação Singleton
    * Instância estática privada (`private static Logger instancia`)
    * Lazy initialization (criada apenas quando necessária)
    * Sincronização para thread-safety
* Clientes (Main, ClienteLogger, Cliente)
    * Todos acessam o Logger via `Logger.getInstancia()`
    * Trabalham com a mesma instância em todo o sistema
    * Garantia de consistência nas mensagens de log