package model;

import enums.*;
import service.UsuarioService;

import java.util.Objects;

public abstract class Usuario extends Pessoa implements UsuarioService {
    protected NIVELUSUARIO nivelUsuario;
    protected String login;
    protected String senha;
    protected int idUsuario;
    protected CURSOS curso;
    protected int periodo;


    //CONSTRUTORES
    public Usuario(String nome, String contato, NIVELUSUARIO nivelUsuario, String login, String senha, int idUsuario) {
        super(nome, contato);
        this.nivelUsuario = nivelUsuario;
        this.login = login;
        this.senha = senha;
        this.idUsuario = idUsuario;
    }

    public Usuario() {
    }

    //GETTERS & SETTERS


    public NIVELUSUARIO getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(NIVELUSUARIO nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public String getLogin() {
        return login;
    }

    // Esse setter pode ser usado para ALTERAR o login
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    // Esse setter pode ser usado para ALTERAR a senha
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    // Esse setter pode ser usado para ALTERAR a idUsuario
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Esse setter pode ser usado para ALTERAR o curso
    public void setCURSO(CURSOS curso) {
        this.curso = curso;
    }

    public CURSOS getCurso() {
        return curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

//MÉTODO de Validar Login/Senha
    public static boolean validarUsuario(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getLogin(), login)) {
                if (Objects.equals(usuario.getSenha(), senha)) {
                    return true;
                }
            }
        }
        return false;
    }


//MÉTODO de Alterar Senha
    public void alterarSenha(String senha) {
        this.senha = senha;
    }
}