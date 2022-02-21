package letscode.avaliacao01.modelo.conta;

import letscode.avaliacao01.modelo.cliente.ClientePessoaFisica;

import java.math.BigDecimal;

public class ContaInvestimentoPessoaFisica extends ContaPessoaFisica {


    public ContaInvestimentoPessoaFisica(int numeroConta, ClientePessoaFisica cliente) {
        super(numeroConta, cliente);
    }

    @Override
    public BigDecimal getSaldo() {
        return saldo.multiply(new BigDecimal(1.1));
    }
}