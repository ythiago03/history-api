# API de Histórico de Produtos

Esta API permite salvar e recuperar o histórico de produtos em uma aplicação Java Spring.

## Endpoints

### 1. **Salvar Histórico de Produto**

- **Método:** `POST`
- **URL:** `/history`
- **Descrição:** Salva o histórico de um produto.

#### Corpo da Requisição

- **Content-Type:** `application/json`

```json
{
  "amount": 0,
  "productName": "string",
  "productId": 0
}
```

#### Exemplo de requisição

```json
{
  "amount": 10,
  "productName": "Teclado Mecânico",
  "productId": 101
}
```

#### Respostas

- **Código:** **201** Created
- **Content-Type:** `application/json`
```json
{
  "id": 0,
  "productId": 0,
  "productName": "string",
  "amount": 0,
  "incomes": 0,
  "outcomes": 0,
  "insertionDate": "2024-08-05"
}