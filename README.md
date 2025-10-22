# 🚗 Sistema de Aluguel de Carros

Sistema de gerenciamento de aluguel de veículos desenvolvido em Java, com cálculo automático de valores baseado em tempo de locação e aplicação de impostos conforme legislação brasileira.

## 📋 Sobre o Projeto

Este sistema permite registrar aluguéis de veículos, calculando automaticamente o valor a ser pago com base no tempo de locação (horas ou dias) e aplicando a taxa de imposto apropriada segundo as regras fiscais brasileiras.

### 🎓 Contexto Acadêmico

Este projeto foi desenvolvido como parte de um desafio do **Curso de Java COMPLETO** ministrado pelo professor **Nélio Alves** na Udemy. O curso aborda desde os fundamentos da linguagem Java até tópicos avançados como programação orientada a objetos, interfaces, design patterns e boas práticas de desenvolvimento.

## 🛠️ Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **Java Time API** - Manipulação de datas e horários (LocalDateTime, Duration)
- **Programação Orientada a Objetos** - Aplicação de conceitos como encapsulamento, herança e polimorfismo
- **Interfaces** - Implementação de contratos para serviços
- **Design Patterns** - Strategy Pattern (TaxService)

## 📁 Estrutura do Projeto

```
src/
├── application/
│   └── Main.java                    # Classe principal com interface do usuário
├── model/
│   ├── entities/
│   │   ├── Aluguel.java            # Entidade que representa o aluguel
│   │   ├── Veiculo.java            # Entidade que representa o veículo
│   │   └── Fatura.java             # Entidade que representa a fatura
│   └── services/
│       ├── TaxService.java         # Interface para serviços de impostos
│       ├── BrazilTaxService.java   # Implementação de impostos brasileiros
│       └── RentalService.java      # Serviço de processamento de aluguéis
```

## 🎯 Funcionalidades

### 1. Cadastro de Aluguel
- Registro do modelo do veículo
- Data e hora de retirada
- Data e hora de devolução

### 2. Cálculo de Valores
- **Locação por hora**: Para períodos até 12 horas
- **Locação por dia**: Para períodos superiores a 12 horas
- Arredondamento automático para cima (teto)

### 3. Sistema de Impostos (Brasil)
- **20% de imposto**: Para valores até R$ 100,00
- **15% de imposto**: Para valores acima de R$ 100,00

### 4. Geração de Fatura
- Pagamento básico (sem impostos)
- Valor do imposto
- Pagamento total (básico + imposto)
