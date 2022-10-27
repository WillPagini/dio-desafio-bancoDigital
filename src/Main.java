import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    static Scanner input = new Scanner(System.in);

    static Banco bank = new Banco();

    public static void main(String[] args) {
        //Banco bank = new Banco();

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Cliente cleiton = new Cliente();
        cleiton.setNome("Cleiton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(cleiton);
        bank.SetConta(cc);
        bank.SetConta(poupanca);

        cc.depositar(100);
        cc.transferir(poupanca, 50);

        //poupanca.imprimirExtrato();
        //cc.imprimirExtrato();

        //printa os dados das contas criadas em Main
        //bank.PrintAccInfos();

        fluxo();
    }

    public static void fluxo(){
        System.out.println("----------------------------------------------");
        System.out.println("----------Bem vindos a nossa Agencia----------");
        System.out.println("----------------------------------------------");
        System.out.println("**Selecione uma operacao que deseja realizar**");
        System.out.println("----------------------------------------------");
        System.out.println("|  Opcao 1 - Criar conta  |");
        System.out.println("|  Opcao 2 - Depositar    |");
        System.out.println("|  Opcao 3 - Sacar        |");
        System.out.println("|  Opcao 4 - Transferir   |");
        System.out.println("|  Opcao 5 - Listar       |");
        System.out.println("|  Opcao 6 - Sair         |\n");

        int operacao =  input.nextInt();

        switch(operacao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                System.out.println("Sacar de conta");
                break;
            case 4:
                System.out.println("Transferir para conta");
                break;
            case 5:
                System.out.println("Lista contas:");
                bank.PrintAccInfos();
                fluxo();
                break;
            case 6:
                System.out.println("Saindo do sistema...");
                System.exit(0);
                break;
            default:
                System.out.println("opção inválida!");
                //operacoes();
                break;
        }
    }

    public static void criarConta(){

        System.out.println("\n");
        System.out.println("----------------------------------------------");
        System.out.println("Selecione o tipo de conta a ser criada: ");
        System.out.println("|  Opcao 1 - Conta Corrente |");
        System.out.println("|  Opcao 2 - Conta Poupanca |");

        int tipoConta =  input.nextInt();

        if(tipoConta==1){
            System.out.println("Digite o nome do titutar da conta corrente:");
            String nomeClient = input.next();
            Cliente newClient = new Cliente();
            newClient.setNome(nomeClient);

            Conta cc = new ContaCorrente(newClient);
            bank.SetConta(cc);

            System.out.println("Conta Corrente criada com sucesso!");
        } else if (tipoConta==2) {
            System.out.println("Digite o nome do titutar da conta poupanca:");
            String nomeClient = input.next();
            Cliente newClient = new Cliente();
            newClient.setNome(nomeClient);

            Conta cp = new ContaPoupanca(newClient);
            bank.SetConta(cp);
            System.out.println("Conta Poupanca criada com sucesso!");
        }else {
            System.out.println("Opcao invalida.");
        }
        fluxo();
    }

    private static Conta encontrarConta(int numConta){
        Conta conta = null;
        for(Conta c: bank.getContas()){
            if(c.getNumero() == numConta){
                conta = c;
            }
        }
        return conta;
    }

    public static void depositar(){
        System.out.println("Número da conta que deseja depositar: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        System.out.println("Qual valor deseja depositar? ");
        Double valorDeposito = input.nextDouble();
        conta.depositar(valorDeposito);

        fluxo();
    }

    public static void sacar(){
        System.out.println("Número da conta que deseja sacar: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        System.out.println("Qual valor deseja sacar? ");
        Double valorSaque= input.nextDouble();
        conta.sacar(valorSaque);

        fluxo();
    }

    public static void transferir(){

        System.out.println("Número da conta do remetente: ");
        int numerocontaRemetente = input.nextInt();
        Conta contaRemetente = encontrarConta(numerocontaRemetente);

        System.out.println("Número da conta destinario: ");
        int numeroContaDestinatario = input.nextInt();
        Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

        System.out.println("Valor da transferencia: ");
        Double valor = input.nextDouble();
        contaRemetente.transferir(contaDestinatario, valor);
    }
}
