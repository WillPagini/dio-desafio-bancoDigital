//classe abstrata não pode ser isntanciada.
// como Conta só vai ser extentida para ContaCorrente e ContaPoupaca, existe outro tipo de Conta a ser instancia eventualmente.
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        //this é opcional
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);

    }

    protected void imprimirDados() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("saldo: %.2f", this.saldo));
    }
}