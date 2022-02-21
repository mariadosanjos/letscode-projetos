package letscode.avaliacao01.modelo.banco;

import letscode.avaliacao01.modelo.cliente.ClientePessoaFisica;
import letscode.avaliacao01.modelo.cliente.ClientePessoaJuridica;
import letscode.avaliacao01.modelo.conta.Conta;
import letscode.avaliacao01.modelo.conta.ContaPessoaFisica;
import letscode.avaliacao01.modelo.conta.ContaPessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {

    private List<Conta> contas = new ArrayList<>();

    public ContaPessoaFisica abrirConta(int numeroConta, ClientePessoaFisica cliente) {

        //int numeroConta = new Random().nextInt(1000); Removido para fins de testes
        ClientePessoaFisica novoCliente = new ClientePessoaFisica(cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getCpf(), cliente.getDataNascimento());
        ContaPessoaFisica novaConta = new ContaPessoaFisica(numeroConta, novoCliente);
        contas.add(novaConta);
        return novaConta;
    }

    public ContaPessoaJuridica abrirContaPessoaJuridica(int numeroConta, ClientePessoaJuridica cliente) {

        //int numeroConta = new Random().nextInt(1000); Removido para fins de testes
        ClientePessoaJuridica novoCliente = new ClientePessoaJuridica(cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getCnpj(), cliente.getRazaoSocial());
        ContaPessoaJuridica novaConta = new ContaPessoaJuridica(numeroConta, novoCliente);
        contas.add(novaConta);
        return novaConta;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Conta buscarConta(int numeroConta){

        Conta contaLocalizada = null;

        for(Conta conta : getContas()) {
            if (conta.getNumeroConta() == numeroConta) {
                contaLocalizada = conta;
                break;
            }
        }
        return contaLocalizada;
    }
}
