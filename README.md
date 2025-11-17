# 🎮 Simulador de Batalha RPG — Projeto Final de POO

Este projeto consiste no desenvolvimento de um **simulador de batalhas RPG**, criado como parte da disciplina **Programação Orientada a Objetos**.  
O sistema permite criar personagens de diferentes classes, iniciar batalhas por turnos e registrar um histórico das partidas realizadas.  
O foco do projeto é aplicar conceitos fundamentais de POO e boas práticas de organização e modularidade.

---

## 📌 Objetivos do Projeto
- Implementar um sistema completo seguindo princípios de **POO**.
- Utilizar **herança, polimorfismo, encapsulamento e abstração**.
- Aplicar interfaces, classes abstratas e padrão de projeto (Factory).
- Trabalhar com **coleções (ArrayList)**.
- Implementar **manipulação de arquivos (I/O)**.
- Criar um **menu interativo (CLI)** para o usuário.
- Registrar histórico de batalhas e permitir carregamento posterior.

---

## 📂 Estrutura do Projeto

A organização segue o padrão de arquitetura **MVC + Service + Utilities**, dividindo as responsabilidades de forma clara.

src/
├── controller/
│ └── BatalhaController.java
├── model/
│ ├── AcaoPersonagem.java
│ ├── Personagem.java
│ ├── Guerreiro.java
│ ├── Mago.java
│ └── Arqueiro.java
├── service/
│ └── JogoService.java
├── util/
│ ├── CharacterFactory.java
│ └── LogManager.java
├── view/
│ └── JogoView.java
└── Main.java

---

# 🧱 **Descrição dos Pacotes e Classes**

## 📦 **model/**
Concentra toda a camada de entidades e lógica de personagens.

### **AcaoPersonagem.java**
Interface que define ações básicas:
- atacar()
- defender()
- especial()
- tipoEspecial()

### **Personagem.java**
Classe abstrata base para todas as classes do jogo.  
Contém:
- nome  
- vida  
- ataque  
- defesa  
- métodos padrão de ataque/defesa  
- controle de dano  

### **Guerreiro, Mago, Arqueiro**
Classes concretas que:
- herdam `Personagem`
- implementam golpes especiais únicos
- definem atributos (vida/ataque/defesa)

---

## 📦 **controller/**
### **BatalhaController.java**
Gerencia a lógica das batalhas.  
Funções:
- executar turno
- calcular dano
- aplicar especial
- pequenas pausas com thread para simulação (*Thread.sleep*)

---

## 📦 **service/**
### **JogoService.java**
Responsável por:
- armazenar personagens (ArrayList)
- registrar histórico
- salvar em arquivos `.txt`
- carregar dados ao iniciar o programa  

Aqui se encontram as operações principais de dados e persistência.

---

## 📦 **util/**
### **CharacterFactory.java**
Padrão de projeto **Factory Method**  
Cria personagens de forma padronizada sem expor lógica de construção.

### **LogManager.java**
Registra cada ação de batalha em `battle_log.txt`.

---

## 📦 **view/**
### **JogoView.java**
É a interface CLI do sistema.  
Responsável por:
- exibir menus  
- ler entradas do usuário  
- chamar JogoService e BatalhaController  
- gerenciar fluxo geral do jogo  

---

## 📦 Main.java
Ponto de entrada do sistema.  
Apenas inicia `JogoView`.

---

# ▶️ **Como Executar o Projeto**

### ✔ Pré-requisitos:
- VS Code ou terminal local

---

## 📌 **Passo a passo (terminal)**

1. Acesse a pasta `src`:

---

## 📌 **Executar pelo VS Code (Run Button)**
1. Abra o arquivo `Main.java`  
2. Clique em **Run** (ícone verde no canto superior direito)
---

# 🧪 Funcionalidades Implementadas

### ✔ Criar personagens  
### ✔ Listar personagens  
### ✔ Sistema completo de turnos  
### ✔ Habilidades especiais por classe  
### ✔ Histórico de batalhas  
### ✔ Sistema de logs  
### ✔ Salvamento e carregamento de dados  
### ✔ Tratamento de exceções  
### ✔ Uso de Threads  
### ✔ Uso de Factories  

---

# 🎓 Conclusão

O projeto atinge todos os requisitos da disciplina e apresenta uma arquitetura modular, expansível e de fácil manutenção.

---
## Evidências de execução:


https://github.com/user-attachments/assets/6b1c869c-f689-4d3a-911e-6ad06354f91a


---
# 📘 Aluno;
Projeto desenvolvido para a disciplina **Programação Orientada a Objetos**.
Pelo Aluno:Kilber Fernando Guimarães Alves Filho


