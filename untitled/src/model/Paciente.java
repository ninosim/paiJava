package model;

public final class Paciente extends Pessoa {
    private int idPaciente;
    private int idade;
    private String curso;
    private int periodo;
    private String sexo;

// CONSTRUTORES
    public Paciente(String nome, String contato, int idPaciente, int idade, String curso, int periodo, String sexo) {
        super(nome, contato);
        this.idPaciente = idPaciente;
        this.idade = idade;
        this.curso = curso;
        this.periodo = periodo;
        this.sexo = sexo;
    }

    public Paciente(int idPaciente, int idade, String curso, int periodo, String sexo) {
        this.idPaciente = idPaciente;
        this.idade = idade;
        this.curso = curso;
        this.periodo = periodo;
        this.sexo = sexo;
    }

    public Paciente() {
    }

// GETTERS & SETTERS
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}

