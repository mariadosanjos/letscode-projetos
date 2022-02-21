package letscode.avaliacao01.modelo.conta;

import java.math.BigDecimal;
import java.util.Objects;

public class Conta {

    private int numeroConta;
    protected BigDecimal saldo;

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = BigDecimal.valueOf(0);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void sacar(BigDecimal valorParaSacar) throws Exception {

        if (valorParaSacar.compareTo(saldo) == -1 || valorParaSacar.compareTo(saldo) == 0) {

            setSaldo(saldo.subtract(valorParaSacar));

        }
        else {
            throw new Exception("Saldo insuficiente!");
        }
    }

    public void depositar(BigDecimal valorParaDepositar){

        setSaldo(saldo.add(valorParaDepositar));
    }

    public void transferencia(Conta contaDestino, BigDecimal valor) throws Exception {

        if (Objects.isNull(contaDestino)) {
            throw new Exception("Conta inválida!");
        }
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
        setSaldo(getSaldo().subtract(valor));
    }
}