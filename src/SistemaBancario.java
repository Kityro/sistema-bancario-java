import java.math.BigDecimal;
import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        // Declaração das variáveis

        String nome;
        String agencia;
        String conta;

        int menu;

        BigDecimal saldo;
        BigDecimal deposito;
        BigDecimal saque;

        // Dados do titular
        System.out.println("Informe o Nome do Titular");
        nome = a.nextLine();

        System.out.println("Digite o número da Agência:");
        agencia = a.nextLine();

        while (!agencia.matches("\\d{4}")) {

            System.err.println("Deve conter 4 Numeros Inteiros");

            System.out.println("Digite Novamente O valor: ");
            agencia = a.nextLine();
        }

        System.out.println("Digite a Conta com o Digito");
        conta = a.nextLine();

        while (!conta.matches("\\d{7}")) {

            System.err.println("Deve conter 7 Numeros Inteiros");

            System.out.println("Digite Novamente O valor ");
            conta = a.nextLine();

        }
        // Exibição dos dados do titular

        System.out.println("--Dados do Titular--");
        System.out.println("Nome: " + nome);
        System.out.println("Sua Agencia é: " + agencia);
        System.out.println("Sua Conta é: " + conta);

        // Menu principal

        saldo = BigDecimal.ZERO;
        do {
            System.out.println("=========MENU=========");
            System.out.println("Opção 1 : Consultar Saldo ");
            System.out.println("Opção 2 : Depositar ");
            System.out.println("Opção 3 : Sacar ");
            System.out.println("Opção 4 : Sair ");
            System.out.println("======================");

            while (!a.hasNextInt()) {
                System.err.println("Deve ser um valor Inteiro");
                a.next();
                System.out.println("Digite Numeros Inteiros de 1 a 4");
            }
            menu = a.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Seu saldo atual é: " + saldo);

                    break;
                case 2:
                    System.out.println("Depositar ");

                    while (!a.hasNextBigDecimal()) {
                        System.err.println("Digite Novamente Um Valor Monetario Valido ");
                        a.next();
                    }
                    deposito = a.nextBigDecimal();

                    while (deposito.compareTo(BigDecimal.ZERO) <= 0) {
                        System.err.println("O valor deve ser Maior de Zero");
                        while (!a.hasNextBigDecimal()) {
                            a.next();
                            System.err.println("Digite novamente um valor monetario valido");

                        }
                        deposito = a.nextBigDecimal();
                    }
                    saldo = deposito.add(saldo);
                    System.out.println("Depósito realizado com sucesso!");
                    System.out.println("Seu saldo atual é: " + saldo);

                    break;
                case 3:
                    System.out.println("Digite o valor do Saque ");
                    while (!a.hasNextBigDecimal()) {
                        a.next();
                        System.err.println("Digite Novamente um valor de saque monetario Valido ");
                    }
                    saque = a.nextBigDecimal();

                    while (saque.compareTo(BigDecimal.ZERO) <= 0 || saque.compareTo(saldo) > 0) {

                        if (saque.compareTo(saldo) > 0) {
                            System.err.println("Saque Maior que o Saldo atual");
                            System.out.println("Seu saldo atual e de " + saldo);
                        } else if (saque.compareTo(BigDecimal.ZERO) <= 0) {
                            System.err.println("O valor deve Ser maior que zero");
                        }
                        while (!a.hasNextBigDecimal()) {
                            a.next();
                            System.err.println("Digite um valor monetário válido.");
                        }
                        System.out.println("Digite novamente o valor do Saque");
                        saque = a.nextBigDecimal();

                    }
                    saldo = saldo.subtract(saque);
                    System.out.println("Saque realizado com sucesso!");
                    System.out.println("Seu saldo atual é: " + saldo);

                    break;
                case 4:
                    System.out.println("Sair ");

                    break;

                default:
                    System.out.println("Opção inválida!");

                    break;
            }

        } while (menu != 4);
    }
}