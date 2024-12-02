package model;

import enums.CURSOS;

import enums.NIVELUSUARIO;
import service.UsuarioService;

public final class Socorrista extends Usuario {

// CONSTRUTORES
    public Socorrista(String nome, String contato, NIVELUSUARIO nivelUsuario, String login, String senha, int idUsuario, CURSOS curso, int periodo) {
        super(nome, contato, nivelUsuario, login, senha, idUsuario);
        this.curso = curso;
        this.periodo = periodo;
    }

    public Socorrista() {
    }

// GETTER & SETTERS
    public CURSOS getCurso() {
        return curso;
    }

    public void setCurso(CURSOS curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

// MÉTODO de Alterar Curso
//    public static void alterarCurso(int codigo, String novoCurso) {
//        for (Usuario usuario : usuarios) {
//            if (usuario.getIdUsuario() == codigo) {
//                setCurso(novoCurso);
//                System.out.println("Curso atualizado com sucesso!");
//                UsuarioService.infoUsuario(codigo);
//            }//       }
//    }
}