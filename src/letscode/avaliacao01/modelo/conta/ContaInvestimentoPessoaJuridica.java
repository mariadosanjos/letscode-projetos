package letscode.avaliacao01.modelo.conta;

import letscode.avaliacao01.modelo.cliente.ClientePessoaJuridica;

import java.math.BigDecimal;

public class ContaInvestimentoPessoaJuridica extends ContaPessoaJuridica {


    public ContaInvestimentoPessoaJuridica(int numeroConta, ClientePessoaJuridica cliente) {
        super(numeroConta, cliente);
    }

    @Override
    public BigDecimal getSaldo() {
        return saldo.multiply(new BigDecimal(1.12));
    }
}