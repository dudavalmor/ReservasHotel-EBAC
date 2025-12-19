# Sistema de Reservas de Hotel (HOSPEDABAC)

Aplicação de console em Java para gerenciamento básico de reservas de um hotel, permitindo cadastro, listagem, busca e ordenação de reservas.

## Funcionalidades

- Cadastro de nova reserva:
  - Nome do hóspede
  - Tipo de quarto (`Standard`, `Luxo`, `Presidencial`)
  - Quantidade de dias de estadia
- Listagem de todas as reservas cadastradas
- Busca de reservas por nome de hóspede
- Ordenação das reservas por quantidade de dias (da maior para a menor)
- Cálculo automático:
  - Valor da diária conforme o tipo de quarto
  - Valor total da reserva (diária × quantidade de dias)

## Tecnologias utilizadas

- Java (aplicação console)
- `Scanner` para entrada de dados via terminal

## Regras de negócio

- Capacidade máxima do hotel: **10 reservas**
- Valor da diária por tipo de quarto:
  - `Standard`: R$ 100,00
  - `Luxo`: R$ 150,00
  - `Presidencial`: R$ 250,00
- Número de dias deve ser **maior ou igual a 1**
- O sistema encerra ao selecionar a opção **5 - Sair**

## Estrutura do projeto

```text
src/
└── br/com/edvalmor/
    ├── HotelReservas.java  // Classe principal com o menu e fluxo do sistema
    └── Reserva.java        // Classe que representa uma reserva
