# Projeto Bank - API REST

## 📌 Sobre o Projeto
Este projeto consiste em uma **API REST** desenvolvida em **Java com Spring Boot**, que simula a gestão de contas bancárias. A API permite:
- Criar contas bancárias
- Consultar contas por ID e CPF
- Depositar e sacar dinheiro
- Realizar transferências via PIX
- Encerrar contas

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot** (Spring Web, Spring DevTools)
- **Maven**
- **Postman** (para testes da API)

## 📂 Estrutura do Projeto
```
src/main/java/seu/pacote/
│── model/
│   ├── Conta.java
│
│── repository/
│   ├── ContaRepository.java
│
│── controller/
│   ├── HomeController.java
│   ├── ContaController.java
│
└── Application.java
```

## 📌 Endpoints Disponíveis

### 📍 Informações do Projeto
**GET /**  
Retorna o nome do projeto e da equipe.

### 📍 Cadastro de Contas
**POST /contas**  
Cadastra uma nova conta bancária.

Exemplo de JSON:
```json
{
  "numero": "12345",
  "agencia": "001",
  "nomeTitular": "João Victor",
  "cpfTitular": "12345678900",
  "dataAbertura": "2025-03-13",
  "saldo": 1000.00,
  "ativa": true,
  "tipo": "corrente"
}
```

### 📍 Consultas
**GET /contas**  
Retorna todas as contas cadastradas.

**GET /contas/{id}**  
Busca uma conta pelo ID.

**GET /contas/cpf/{cpf}**  
Busca uma conta pelo CPF.

### 📍 Operações Bancárias
**PUT /contas/{id}/deposito**  
Realiza um depósito na conta informada.
```json
{
  "valor": 500.00
}
```

**PUT /contas/{id}/saque**  
Realiza um saque da conta informada.
```json
{
  "valor": 200.00
}
```

**PUT /contas/pix**  
Realiza uma transferência entre contas.
```json
{
  "idOrigem": 1,
  "idDestino": 2,
  "valor": 300.00
}
```

### 📍 Encerramento de Conta
**PUT /contas/{id}/encerrar**  
Marca a conta como inativa.

## 🔧 Como Rodar o Projeto
1. Clone este repositório:
   ```sh
   git clone https://github.com/seu-usuario/projeto-bank.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd projeto-bank
   ```
3. Execute o projeto via Maven:
   ```sh
   mvn spring-boot:run
   ```
4. A API estará rodando em: `http://localhost:8080`

## 📌 Autor
Desenvolvido por **João Victor**.
Se tiver dúvidas ou sugestões, fique à vontade para entrar em contato! 🚀
