import java.util.Objects;

public class Categoria {
    private static int count = 0;
    private int id;
    private String nome;
    private String status;

    public Categoria( String nome, String status){
        this.nome = nome;
        setStatus(status);
        this.id = ++count;
    }
    public Categoria(String nome){
        this(nome, "ativa");
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setStatus(String status) {
        if(Objects.equals(status, "ativa") || Objects.equals(status, "inativa")){
            this.status =  status;
        }
    }
}
