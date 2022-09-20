public class Cliente {
    private static int count = 0;
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public String getBairro() {
        return bairro;
    }public String getCidade() {
        return cidade;
    }public String getComplemento() {
        return complemento;
    }public String getCpf() {
        return cpf;
    }public String getEstado() {
        return estado;
    }public int getId() {
        return id;
    }public String getNome() {
        return nome;
    }public String getNumero() {
        return numero;
    }public String getRua() {
        return rua;
    }public String getTelefone() {
        return telefone;
    }
    public Cliente(String nome, String cpf, String telefone, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.id = ++count;
    }
    
}
