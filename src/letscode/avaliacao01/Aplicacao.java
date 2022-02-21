package letscode.avaliacao01;

import letscode.avaliacao01.modelo.banco.Banco;
import letscode.avaliacao01.modelo.cliente.ClientePessoaFisica;
import letscode.avaliacao01.modelo.cliente.ClientePessoaJuridica;
import letscode.avaliacao01.modelo.conta.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Aplicacao {
    public static void main(String[] args) {
        try {
            System.out.println("Abertura de contas para Pessoa Física e Pessoa Jurídica\n");
            Banco banco = new Banco();

            ClientePessoaFisica clienteMariaPF = new ClientePessoaFisica("Maria dos Anjos", "(83)99999-9999", "Rua 85 - João Pessoa", "999.999.999-00", LocalDate.of(1997,1,8));
            ContaPessoaFisica contaPF1 = banco.abrirConta(1, clienteMariaPF);

            ClientePessoaFisica clientePedroPF = new ClientePessoaFisica("Pedro Garcia", "(83)98888-8888", "Rua 16 - João Pessoa", "888.888.888-00", LocalDate.of(1998,12,24));
            ContaPessoaFisica contaPF2 = banco.abrirConta(2, clientePedroPF);

            ClientePessoaJuridica clienteAlicePJ = new ClientePessoaJuridica("Alice Marques", "(83)97777-7777", "Rua 41 - Recife", "77. 777. 777/0001-77.", "Alice Store LTDA");
            ContaPessoaJuridica contaPJ1 = banco.abrirContaPessoaJuridica(3, clienteAlicePJ);

            ClientePessoaJuridica clienteGabrielPJ = new ClientePessoaJuridica("Gabriel Oliveira", "(83)96666-6666", "Rua 17 - Recife", "66. 666. 666/0001-66.", "Gabriel Store LTDA");
            ContaPessoaJuridica contaPJ2 = banco.abrirContaPessoaJuridica(4, clienteGabrielPJ);

            System.out.println(contaPF1.getCliente().getNome());
            System.out.println(contaPF1.getCliente().getTelefone());
            System.out.println(contaPF1.getCliente().getEndereco());
            System.out.println(contaPF1.getCliente().getCpf());
            System.out.println(contaPF1.getCliente().getDataNascimento());
            System.out.println("Número da conta: " + contaPF1.getNumeroConta() + "\n");

            System.out.println(contaPF2.getCliente().getNome());
            System.out.println(contaPF2.getCliente().getTelefone());
            System.out.println(contaPF2.getCliente().getEndereco());
            System.out.println(contaPF2.getCliente().getCpf());
            System.out.println(contaPF2.getCliente().getDataNascimento());
            System.out.println("Número da conta: " + contaPF2.getNumeroConta() + "\n");

            System.out.println(contaPJ1.getCliente().getNome());
            System.out.println(contaPJ1.getCliente().getTelefone());
            System.out.println(contaPJ1.getCliente().getEndereco());
            System.out.println(contaPJ1.getCliente().getCnpj());
            System.out.println(contaPJ1.getCliente().getRazaoSocial());
            System.out.println("Número da conta: " + contaPJ1.getNumeroConta() + "\n");

            System.out.println(contaPJ2.getCliente().getNome());
            System.out.println(contaPJ2.getCliente().getTelefone());
            System.out.println(contaPJ2.getCliente().getEndereco());
            System.out.println(contaPJ2.getCliente().getCnpj());
            System.out.println(contaPJ2.getCliente().getRazaoSocial());
            System.out.println("Número da conta: " + contaPJ2.getNumeroConta() + "\n");

            System.out.println("Transferência de ContaPF para ContaPJ:");
            contaPF1.depositar(BigDecimal.valueOf(123.50));
            contaPF1.transferencia(banco.buscarConta(4), BigDecimal.valueOf(10));
            System.out.println("Saldo contaPF de origem: " + contaPF1.getSaldo());
            System.out.println("Saldo conta de destino: " + contaPJ2.getSaldo() + "\n");

            System.out.println("Transferência de ContaPJ para ContaPF:");
            contaPJ2.transferencia(banco.buscarConta(1), new BigDecimal(5));
            System.out.println("Saldo contaPJ de origem: " + contaPJ2.getSaldo());
            System.out.println("Saldo contaPF de destino: " + contaPF1.getSaldo() + "\n");

            System.out.println("Depósito em Conta Poupança:");
            ContaPoupanca contaPoupanca = new ContaPoupanca(5, clienteMariaPF);
            contaPF1.setContaPoupanca(contaPoupanca);
            contaPoupanca.depositar(BigDecimal.valueOf(55.79));
            System.out.println("Saldo Conta Poupança: " + contaPF1.getContaPoupanca().getSaldo() + "\n");

            System.out.println("Depósito e saldo de Conta Investimento PJ: ");
            ContaInvestimentoPessoaJuridica contaInvestimentoPJ1 = new ContaInvestimentoPessoaJuridica(6,clienteAlicePJ);
            contaInvestimentoPJ1.depositar(BigDecimal.valueOf(859));
            System.out.println("Saldo: " + contaInvestimentoPJ1.getSaldo() + "\n");

            System.out.println("Depósito e saldo de Conta Investimento PF: ");
            ContaInvestimentoPessoaFisica contaInvestimentoPF2 = new ContaInvestimentoPessoaFisica(9,clientePedroPF);
            contaInvestimentoPF2.depositar(BigDecimal.valueOf(859));
            System.out.println("Saldo: " + contaInvestimentoPF2.getSaldo() + "\n");

            System.out.println("Saque PF: ");
            contaPF2.depositar(BigDecimal.valueOf(500));
            System.out.println("Saldo contaPF: " + contaPF2.getSaldo());
            contaPF2.sacar(BigDecimal.valueOf(50));
            System.out.println("Saldo após saque contaPF: " + contaPF2.getSaldo() + "\n");

            System.out.println("Saque PJ: ");
            contaPJ2.depositar(BigDecimal.valueOf(368));
            System.out.println("Saldo contaPJ: " + contaPJ2.getSaldo());
            contaPJ2.sacar(BigDecimal.valueOf(26));
            System.out.println("Saldo após saque contaPJ: " + contaPJ2.getSaldo());

        } catch (Exception exception) {
            System.out.println("Ocorreu um erro na execução da aplicação");
            System.out.println("Erro: " + exception.getMessage());
        }
    }
}
