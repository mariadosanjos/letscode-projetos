package letscode.avaliacao01.modelo.conta;

import letscode.avaliacao01.modelo.cliente.ClientePessoaFisica;

public class ContaPessoaFisica extends Conta {

    private ClientePessoaFisica cliente;
    private ContaPoupanca contaPoupanca;
    private ContaInvestimentoPessoaFisica contaInvestimentoPessoaFisica;

    public ContaPessoaFisica(int numeroConta, ClientePessoaFisica cliente) {
        super(numeroConta);
        this.cliente = cliente;
    }

    public ClientePessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(ClientePessoaFisica cliente) {
        this.cliente = cliente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    public ContaInvestimentoPessoaFisica getContaInvestimentoPessoaFisica() {
        return contaInvestimentoPessoaFisica;
    }

    public void setContaInvestimentoPessoaFisica(ContaInvestimentoPessoaFisica contaInvestimentoPessoaFisica) {
        this.contaInvestimentoPessoaFisica = contaInvestimentoPessoaFisica;
    }
}
