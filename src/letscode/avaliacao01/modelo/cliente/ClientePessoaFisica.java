package letscode.avaliacao01.modelo.cliente;

import java.time.LocalDate;

public class ClientePessoaFisica extends Cliente {

    private String cpf;
    private LocalDate dataNascimento;

    public ClientePessoaFisica(String nome, String telefone, String endereco, String cpf, LocalDate dataNascimento){
        super(nome, telefone, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}