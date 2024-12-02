package service;

import model.*;
import java.util.ArrayList;
import java.util.Objects;


// @POST, cria uma lista com todos os usuários.
public interface UsuarioService {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    static void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

// GET da lista de Usuários
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

// MÉTODO para Exibir Informações de um Usuário
    static boolean infoUsuario(int codigo) {
        int i = 0;
        for (Usuario usuario : usuarios) {
                if (codigo == usuarios.get(i).getIdUsuario()) {
                    System.out.printf("\nCÓDIGO: %d - Nome: %s - Contato: %s - Login: %s - Curso: %s - Período: %d\n", usuario.getIdUsuario(), usuario.getNome(), usuario.getContato(), usuario.getLogin(), usuario.getCurso(), usuario.getPeriodo());
                    return true;
                } else {
                    i++;
                }
            }
        System.out.println("Código de usuário não encontrado!");
        return false;
    }

//MÉTODO para Exibir a Lista de Usuários:
    static void exibirUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.printf("\nCÓDIGO: %d - Nome: %s - Contato: %s - Login: %s\n", usuario.getIdUsuario(), usuario.getNome(), usuario.getContato(), usuario.getLogin());
        }
    }

//MÉTODO para determinar o Nível de Usuário:
    default String consultarNivelUsuario(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin() == login) {
                return usuario.getNivelUsuario().toString();
            }
        }
        return login;
    }

//MÉTODO para puxar dados de um usuário pelo login:
    static Usuario consultarUsuario(String login) {
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getLogin(), login)) {
                return usuario;
            }
        }
        return null;
    }

// MÉTODO de Alterar Nome:
    public static void alterarNomeUsuario(int codigo, String novoNome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == codigo) {
                usuario.setNome(novoNome);
                System.out.println("Nome atualizado com sucesso!");
                infoUsuario(codigo);
            }
        }
    }

// MÉTODO de Alterar Contato:
    public static void alterarContatoUsuario(int codigo, String novoContato) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == codigo) {
                usuario.setContato(novoContato);
                System.out.println("Contato atualizado com sucesso!");
                infoUsuario(codigo);
            }
        }
    }


// MÉTODO de Alterar Login:
    public static void alterarLoginUsuario(int codigo, String novoLogin) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == codigo) {
                usuario.setLogin(novoLogin);
                System.out.println("Login atualizado com sucesso!");
                infoUsuario(codigo);
            }
        }
    }

// MÉTODO de Alterar Senha:
    public static void alterarSenhaUsuario(int codigo, String novaSenha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == codigo) {
                usuario.setSenha(novaSenha);
                System.out.println("Senha atualizada com sucesso!");
                infoUsuario(codigo);
            }
        }
    }
}

//MÉTODO de Consulta de Paciente

//MÉTODO de Consulta de Atendimentos