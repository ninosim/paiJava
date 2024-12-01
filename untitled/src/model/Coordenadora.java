package model;

import enums.NIVELUSUARIO;

public final class Coordenadora extends Usuario {
    public Coordenadora(String nome, String contato, String login, String senha, int idUsuario) {
        super(nome, contato, login, senha, idUsuario);
        this.nivelUsuario = NIVELUSUARIO.Coordenadora;
    }

    public Coordenadora() {
    }
}

//MÉTODO de Criar Novo Socorrista

//MÉTODO de Consultar TODOS os atendimentos em determinado período
