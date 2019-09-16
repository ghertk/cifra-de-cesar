package model;

public class Contato {

    private Long id;
    private String nome;
    private String celular;
    private String cidade;
    private String email;

    public Contato() {
    }

    public Contato(Long id, String nome, String celular, String cidade, String email) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.cidade = cidade;
        this.email = email;
    }

    public Contato(String nome, String celular, String cidade, String email) {
        this.nome = nome;
        this.celular = celular;
        this.cidade = cidade;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + ", celular=" + celular + ", cidade=" + cidade + ", email=" + email + '}';
    }
}