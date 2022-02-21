package letscode.avaliacao01.modelo.cliente;

public class ClientePessoaJuridica extends Cliente {

    private String cnpj;
    private String razaoSocial;

    public ClientePessoaJuridica(String nome, String telefone, String endereco, String cnpj, String razaoSocial){
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}