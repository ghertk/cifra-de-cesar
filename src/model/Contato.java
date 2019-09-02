package model;

public class Contato {

    private String nome;
    private String celular;
    private String cidade;
    private String email;

    public Contato() {
    }

    public Contato(String nome, String celular, String cidade, String email) {
        this.nome = nome;
        this.celular = celular;
        this.cidade = cidade;
        this.email = email;
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

}
