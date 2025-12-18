# Sistema de interface gráfica multi-plataforma
A aplicação deve ser capaz de criar botões e caixas de texto, mas o estilo dos componentes depende da plataforma (por exemplo, Windows, Mac, Linux).

## Contexto
Assim existem diferentes familias de componentes:
* Windows - WindowsButton & WindowsTextBox;
* Mac - MacButton & MacTextBox;
* Linux - LinuxButton & LinuxTextBox;
Todos os botões devem implementar uma interface comum: void render(); 
Todas as caixas de texto devem implementar uma interface comum: void render();

## Requisitos
- Interfaces abstratas para os produtos: interface Button { void render(); } / interface TextBox { void render(); };
- Classes concretas para cada família;
- Abstract Factory, com os métodos Button createButton(); / TextBox createTextBox();
- Fábricas Concretas, cada uma cria a família correspondente de produtos;
- Cliente que cria os botões e caixas de texto apenas através da factory, sendo que não deve reconhecer as classes concretas diretamente;
