# Sistema Bancário em Java (POO)

Projeto desenvolvido com o objetivo de praticar Programação Orientada a Objetos (POO) em Java, simulando o funcionamento básico de um sistema bancário.

O sistema permite criar clientes, criar contas bancárias (corrente e poupança) e realizar operações como depósito, saque e transferência entre contas, seguindo uma arquitetura organizada e próxima da utilizada em sistemas reais.

---

## Funcionalidades

- Cadastro de clientes
- Criação de contas corrente e poupança
- Depósito em conta
- Saque com validação de saldo
- Transferência entre contas
- Geração automática de número da conta
- Listagem e busca de contas por número

---

## Tecnologias utilizadas

- Java (JDK 17+)
- IntelliJ IDEA
- Programação Orientada a Objetos (POO)
- Collections (List / ArrayList)

---

## Conceitos aplicados

- Encapsulamento
- Herança
- Abstração
- Polimorfismo (sobrescrita do método `toString`)
- Service Layer (BancoService)
- Organização em pacotes (model, service, app)

---

## Estrutura do projeto

```
src/
└── br.com.diogo.banco
    ├── model
    │   ├── Cliente.java
    │   ├── Conta.java
    │   ├── ContaCorrente.java
    │   └── ContaPoupanca.java
    │
    ├── service
    │   └── BancoService.java
    │
    └── app
        └── Main.java
```
---

## Como executar o projeto

1. Clone o repositório
2. Abra o projeto no IntelliJ IDEA
3. Execute a classe `Main`
4. O sistema irá criar contas automaticamente e realizar operações de teste (depósito, saque e transferência)

---

## Exemplo de operações realizadas

- Depósito em conta corrente
- Saque em conta corrente
- Transferência para conta poupança
- Exibição dos saldos atualizados no console

---

## Próximos passos (evolução futura)

- Criar menu interativo com `Scanner`
- Persistência de dados (arquivo ou banco de dados)
- Interface gráfica ou API REST com Spring Boot
- Autenticação de usuários

---

## Autor

Diogo Garcia  
Desenvolvedor Back End Java

LinkedIn: (https://www.linkedin.com/in/diogogarciadev/)  
GitHub: (https://github.com/devgarciadiogo)

---