# 🧙‍♂️ Simulador de Batalha RPG — Versão Final

## 📌 Descrição Geral
O **Simulador de Batalha RPG** é um jogo de combate em turnos desenvolvido em **Java**, que permite a dois jogadores criarem personagens de diferentes classes e batalharem até que apenas um permaneça de pé.  
Este projeto foi desenvolvido como **trabalho final da disciplina de Programação Orientada a Objetos**, com o objetivo de aplicar os principais conceitos de **POO, estruturas de dados, tratamento de exceções e modularidade.**

---

## 🧩 Conceitos de POO Aplicados

- **Abstração:**  
  Classe `Personagem` define os atributos e comportamentos básicos que são compartilhados entre todas as classes derivadas.

- **Herança:**  
  As classes `Guerreiro`, `Mago` e `Arqueiro` herdam de `Personagem`, especializando seus métodos de ataque e defesa.

- **Polimorfismo:**  
  Cada classe implementa de forma diferente os métodos `atacar()` e `defender()`, de acordo com suas características.

- **Encapsulamento:**  
  Os atributos são privados, acessados apenas através de métodos getters e setters, garantindo segurança e controle de estado.

---

## ⚙️ Recursos e Funcionalidades

- **Interface CLI (linha de comando):**
  Menu interativo para iniciar e encerrar o jogo.
  
- **Sistema de Combate:**
  Batalhas em turnos, com ataques e defesas variáveis por classe.
  
- **Classes Jogáveis:**
  - 🗡️ **Guerreiro** — ataque físico poderoso.  
  - 🔮 **Mago** — uso de feitiços e dano mágico.  
  - 🏹 **Arqueiro** — ataques à distância e maior chance de esquiva.  

- **Coleções:**  
  Uso de `ArrayList` para armazenar logs e histórico de turnos durante a batalha.

- **Tratamento de Exceções:**  
  Controle de entradas inválidas no menu e nas ações durante o jogo.

- **Padrão de Projeto Aplicado:**  
  Implementação baseada no padrão **MVC (Model-View-Controller)**, garantindo **separação de responsabilidades**:
  - **Model:** classes de domínio (`Personagem`, `Guerreiro`, `Mago`, `Arqueiro`).  
  - **View:** interação com o jogador (`JogoView`).  
  - **Controller:** controle da lógica da batalha (`BatalhaController`).  
  - **Service:** processamento e controle auxiliar do fluxo do jogo.  

- **Manipulação de Arquivos (I/O):**  
  Salvamento do **histórico de batalhas** em um arquivo `.txt` no diretório do projeto.

- **Threads:**  
  Uso de **pausas simuladas com `Thread.sleep()`** entre turnos para tornar o combate mais dinâmico e realista.

---
