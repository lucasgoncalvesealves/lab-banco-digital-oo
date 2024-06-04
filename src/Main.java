import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

	public static Scanner scanner = new Scanner(System.in);
	public static int conta;
	public static double valor;
	public static Conta corrente;
	public static Conta poupanca;

	public static void abertura() {
		System.out.print("Abra uma conta digitando seu nome: ");
        String nome = scanner.nextLine();
		
		Cliente cliente = new Cliente(nome);
		
		corrente = new ContaCorrente(cliente);
		poupanca = new ContaPoupanca(cliente);

		principal();
	}

	public static void principal() {
		System.out.println("Selecione uma opção:");
		System.out.println("1 para SAQUE");
		System.out.println("2 para DEPÓSITO");
		System.out.println("3 para TRANSFERÊNCIA");
		System.out.println("4 para EXTRATO");
		System.out.println("Qualquer outra tecla para ENCERRAR o atendimento");
		
		switch (scanner.nextInt()) {
			case 1:
				saque(corrente, poupanca);
				break;
			case 2:
				deposito();
				break;
			case 3:
				transferencia();
				break;
			case 4:
				extrato();
				break;
			default:
				System.err.println("Obrigado por utilizar nossos serviços!");
				scanner.close();
				break;
		}
	}

	public static void saque(Conta corrente, Conta poupanca) {
		System.out.println("Informe a conta da qual será feito o saque: ");
			System.out.println("5 para CONTA CORRENTE: ");
			System.out.println("6 para CONTA POUPANÇA: ");
			System.out.println("0 para VOLTAR ao menu anterior ");
			System.out.println("Qualquer outra tecla para ENCERRAR o atendimento. ");
			conta = scanner.nextInt();
			System.out.print("Informe o valor a ser sacado: ");
			valor = scanner.nextDouble();
		switch (conta) {
			case 5:
				corrente.sacar(valor);
				principal();
			case 6:
				poupanca.sacar(valor);
				principal();
			case 0:
				principal();
			default:
				System.out.println("Obrigado por utilizar nossos serviços!");
				scanner.close();
				break;
		}
	}

	public static void deposito() {
		System.out.println("Informe a conta na qual será feito o depósito: ");
				System.out.println("5 para CONTA CORRENTE: ");
				System.out.println("6 para CONTA POUPANÇA: ");
				System.out.println("0 para VOLTAR ao menu anterior ");
				System.out.println("Qualquer outra tecla para ENCERRAR o atendimento");
				conta = scanner.nextInt();
				System.out.print("Informe o valor a ser depositado: ");
				valor = scanner.nextDouble();
			switch (conta) {
				case 5:
					corrente.depositar(valor);
					principal();
				case 6:
					poupanca.depositar(valor);
					principal();
				case 0:
					principal();
				default:
					System.out.println("Obrigado por utilizar nossos serviços!");
					scanner.close();
					break;
		}
	}
	
	public static void transferencia() {
		System.out.println("Informe a conta que RECEBERÁ a transferência: ");
			System.out.println("5 para CONTA CORRENTE: ");
			System.out.println("6 para CONTA POUPANÇA: ");
			System.out.println("0 para VOLTAR ao menu anterior ");
			System.out.println("Qualquer outra tecla para ENCERRAR o atendimento");
			conta = scanner.nextInt();
			System.out.print("Informe o valor a ser transferido: ");
			valor = scanner.nextDouble();
		switch (conta) {
			case 5:
				poupanca.transferir(valor, corrente);
				principal();
			case 6:
				corrente.transferir(valor, poupanca);
				principal();
			case 0:
				principal();
			default:
				System.out.println("Obrigado por utilizar nossos serviços!");
				scanner.close();
				break;
		}
	}

	public static void extrato() {
		System.out.println("Informe a conta a ser consultada: ");
		System.out.println("5 para CONTA CORRENTE: ");
		System.out.println("6 para CONTA POUPANÇA: ");
		System.out.println("0 para VOLTAR ao menu anterior ");
		System.out.println("Qualquer outra tecla para ENCERRAR o atendimento");
		conta = scanner.nextInt();
		switch (conta) {
			case 5:
				corrente.imprimirExtrato();
				principal();
			case 6:
				poupanca.imprimirExtrato();
				principal();
			case 0:
				principal();
			default:
				System.out.println("Obrigado por utilizar nossos serviços!");
				scanner.close();
				break;
		}
	}

	public static void main(String[] args) {
		try {
			abertura();
			principal();
		} catch(InputMismatchException ime) {
            System.out.println("Obrigado por utilizar nossos serviços!");
		}
	}

}