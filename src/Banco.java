import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas = new ArrayList<>();;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas(){
        return contas;
    }

    public void SetConta(Conta conta) {
        this.contas.add(conta);
    }

    public void PrintAccInfos(){
        for(int i=0; i < contas.size(); i++){

            System.out.println("Titular da conta: " + contas.get(i).cliente.getNome());
            System.out.println("Numero da conta:" + contas.get(i).getNumero());
            System.out.println("Saldo: R$ " + contas.get(i).getSaldo());
            System.out.println("---------------------------");
        }
    }
}
