package letscode.avaliacao01.modelo.conta;

import letscode.avaliacao01.modelo.cliente.ClientePessoaJuridica;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaPessoaJuridica extends Conta {

    private ClientePessoaJuridica cliente;
    private ContaInvestimentoPessoaJuridica contaInvestimentoPessoaJuridica;

    public ContaPessoaJuridica(int numeroConta, ClientePessoaJuridica cliente) {
        super(numeroConta);
        this.cliente = cliente;
    }

    public ClientePessoaJuridica getCliente() {
        return cliente;
    }

    public void setCliente(ClientePessoaJuridica cliente) {
        this.cliente = cliente;
    }

    public ContaInvestimentoPessoaJuridica getContaInvestimentoPessoaJuridica() {
        return contaInvestimentoPessoaJuridica;
    }

    public void setContaInvestimentoPessoaJuridica(ContaInvestimentoPessoaJuridica contaInvestimentoPessoaJuridica) {
        this.contaInvestimentoPessoaJuridica = contaInvestimentoPessoaJuridica;
    }

    @Override
    public void sacar(BigDecimal valorParaSacar) throws Exception {

        BigDecimal valorParaSacarComTaxa = valorParaSacar.multiply(BigDecimal.valueOf(1.005));

        if (valorParaSacarComTaxa.compareTo(getSaldo()) == -1 || valorParaSacarComTaxa.compareTo(getSaldo()) == 0) {

            setSaldo(saldo.subtract(valorParaSacarComTaxa));

        }
        else {
            throw new Exception("Saldo insuficiente!");
        }
    }

    @Override
    public void transferencia(Conta contaDestino, BigDecimal valor) throws Exception {

        if (Objects.isNull(contaDestino)) {
            throw new Exception("Conta inválida!");
        }
        contaDestino.setSaldo(contaDestino.saldo.add(valor));
        setSaldo(saldo.subtract(valor.multiply(new BigDecimal(1.005))));
    }
}
