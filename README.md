# Sistema Bancário em Java

Sistema bancário simples, executado no terminal, para praticar validação de dados, leitura de entrada com `Scanner` e operações financeiras com `BigDecimal`.

## Funcionalidades

- Cadastro do titular com nome, agência e conta
- Validação de agência (4 dígitos) e conta com dígito (7 dígitos)
- Consulta de saldo
- Depósito, aceitando apenas valores maiores que zero
- Saque, aceitando apenas valores maiores que zero e não superiores ao saldo
- Menu interativo com tratamento de entradas inválidas

## Tecnologias

- Java
- `java.util.Scanner` para entrada de dados
- `java.math.BigDecimal` para valores monetários

## Como executar

Pré-requisito: ter o JDK instalado.

```bash
javac src/SistemaBancario.java
java -cp src SistemaBancario
```

## Exemplo de uso
Informe o Nome do Titular
Maria Silva
Digite o número da Agência:
1234
Digite a Conta com o Digito
1234567


Depois, escolha a opção 2 para depositar 500 e a opção 3 para sacar 200. O saldo final será 300.

## Observações

- O saldo é armazenado apenas na memória. Ao encerrar o programa, os dados são perdidos.
- Os valores monetários usam `BigDecimal` para evitar erros de arredondamento de `double`.

## Próximos passos

- Separar o código em classes, como `Conta` e `Titular`
- Aplicar orientação a objetos
- Criar testes automatizados
- Persistir os dados em arquivo ou banco de dados
