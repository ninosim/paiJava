package model;

public abstract class Pessoa {
    protected String nome;
    protected String contato;


//CONSTRUTORES
    public Pessoa(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public Pessoa() {
    }

//GETTERS & SETTERS
    public String getNome() {
        return nome;
    }

    //Pode ser usado para ALTERAR o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    //Pode ser usado para ALTERAR o meio de contato
    public void setContato(String contato) {
        this.contato = contato;
    }
}