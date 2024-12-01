import java.time.LocalDate;
import java.util.Scanner;
import model.*;
import service.*;
import enums.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Scanner scNum = new Scanner(System.in);
        Scanner scText = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        String login;
        String senha;
        String nivelUsuarioAtivo;
        boolean loginValido = false;
        int menu;

// INSTÂNCIAS previamente cadastradas para popular o banco de dados:
        Pessoa admin = new Coordenadora("Admin", "83989991234", "admin", "1234", 2024999001);
        UsuarioService.cadastrarUsuario((Usuario) admin);
        Socorrista socorrista = new Socorrista("Vitória", "839898989898", "vitoria85", "1234", 202455001, CURSOS.Farmácia, 4);
        UsuarioService.cadastrarUsuario((Usuario) socorrista);
        Paciente paciente = new Paciente("Arthur", "arthur@bol.com.br", 202400001, 21,"Sistemas para Internet", 2, "Masculino");
        PacienteService.cadastrarPaciente((Paciente) paciente);
        Date d1 = new Date();
        Atendimento atendimento = new Atendimento(2024000000, paciente, d1, "Coceira e enjôo", false, true, 37, true, true, false, false, "n/a", false, "n/a", ESTADOINICIAL.Leve_e_Instavel);
        AtendimentoService.cadastrarAtendimento((Atendimento) atendimento);


        System.out.println("Pronto Atendimento Institucional UNIESP");
        while (!loginValido) {
            System.out.println("Digite seu LOGIN (admin): ");
            login = scText.nextLine();
            System.out.println("Digite sua SENHA (1234): ");
            senha = scText.nextLine();
            if ((Usuario.validarUsuario(login, senha))) {
                Usuario usuarioAtivo = (UsuarioService.consultarUsuario(login));
                if (usuarioAtivo.getNivelUsuario().toString() == "Coordenadora") {
                    System.out.println("Bem-vinda, Coordenadora " + usuarioAtivo.getNome());
                    loginValido = true;
                    nivelUsuarioAtivo = "coord";

                } else if (usuarioAtivo.getNivelUsuario().toString() == "Socorrista") {
                    System.out.println("Bem-vinda, Socorrista " + usuarioAtivo.getNome());
                    loginValido = true;
                    nivelUsuarioAtivo = "socorrista";
                }
            } else {
                System.out.println("Login ou senha incorreta, tente novamente.");
            }
        }

        if (loginValido && nivelUsuarioAtivo.equals("coord")) {
            do {
                System.out.println("\nPronto Atendimento Institucional UNIESP");
                System.out.println("[1] CRIAR Relatório (não implementado)");
                System.out.println("[2] CONSULTAR Paciente (não implementado)");
                System.out.println("[3] CONSULTAR Atendimento (não implementado)");
                System.out.println("[4] CONSULTAR Socorristas Cadastradas");
                System.out.println("[5] CRIAR Nova Socorrista");
                System.out.println("[6] ALTERAR Informações de Usuário");
                System.out.println("[0] SAIR");
                menu = scNum.nextInt();
                switch (menu) {
                    case 1:
                        /// Método Relatório
                        break;
                    case 2:
                        /// Método Consultar Paciente
                        break;
                    case 3:
                        /// Método Consultar Atendimento
                        break;
                    case 4:
                        UsuarioService.exibirUsuarios();
                        break;
                    case 5:
                        Socorrista socorristaNova = new Socorrista();
                        System.out.println("Informe o NOME da Socorrista: ");
                        socorristaNova.setNome(scText.nextLine());
                        System.out.println("Informe o CONTATO da Socorrista: ");
                        socorristaNova.setContato(scText.nextLine());
                        System.out.println("Informe o LOGIN da Socorrista: ");
                        socorristaNova.setLogin(scText.nextLine());
                        System.out.println("Informe a SENHA da Socorrista: ");
                        socorristaNova.setSenha(scText.nextLine());
                        System.out.println("Informe o CÓDIGO da Socorrista: ");
                        socorristaNova.setIdUsuario(scNum.nextInt());
                        int opcaoCurso;
                        do {
                            System.out.println("Informe o CURSO da Socorrista: ");
                            System.out.println(" [1] Biomedicina");
                            System.out.println(" [2] Educação Física");
                            System.out.println(" [3] Enfermaria");
                            System.out.println(" [4] Estética e Cosmética");
                            System.out.println(" [5] Farmácia");
                            System.out.println(" [6] Fisioterapia");
                            System.out.println(" [7] Medicina");
                            System.out.println(" [8] Medicina Veterinária");
                            System.out.println(" [9] Nutrição");
                            System.out.println(" [10] Odontologia");
                            System.out.println(" [11] Psicologia");
                            opcaoCurso = scNum.nextInt();
                            switch (opcaoCurso) {
                                case 1:
                                    socorristaNova.setCURSO(CURSOS.Biomedicina);
                                    break;
                                case 2:
                                    socorristaNova.setCURSO(CURSOS.Educação_Física);
                                    break;
                                case 3:
                                    socorristaNova.setCURSO(CURSOS.Enfermaria);
                                    break;
                                case 4:
                                    socorristaNova.setCURSO(CURSOS.Estética_e_Cosmética);
                                    break;
                                case 5:
                                    socorristaNova.setCURSO(CURSOS.Farmácia);
                                    break;
                                case 6:
                                    socorristaNova.setCURSO(CURSOS.Fisioterapia);
                                    break;
                                case 7:
                                    socorristaNova.setCURSO(CURSOS.Medicina);
                                    break;
                                case 8:
                                    socorristaNova.setCURSO(CURSOS.Medicina_Veterinária);
                                    break;
                                case 9:
                                    socorristaNova.setCURSO(CURSOS.Nutrição);
                                    break;
                                case 10:
                                    socorristaNova.setCURSO(CURSOS.Odontologia);
                                    break;
                                case 11:
                                    socorristaNova.setCURSO(CURSOS.Psicologia);
                                    break;
                                default:
                                    throw new IllegalStateException("Valor inesperado: " + opcaoCurso);
                            }
                        } while (opcaoCurso < 1 || opcaoCurso > 10);
                        System.out.println("Informe o PERÍODO da Socorrista: ");
                        socorristaNova.setPeriodo(scNum.nextInt());
                        UsuarioService.cadastrarUsuario(socorristaNova);
                        UsuarioService.exibirUsuarios();
                        break;
                    case 6:
                        int codigoUsuario;
                        do {
                            UsuarioService.exibirUsuarios();
                            System.out.println("Informe o CÓDIGO do usuário que deseja alterar ou digite 0 para SAIR: ");
                            codigoUsuario = scNum.nextInt();
                            if (codigoUsuario == 0) {
                                System.out.println("Você escolheu SAIR!");
                                break;
                            }
                            if (UsuarioService.infoUsuario(codigoUsuario)) {
                                int menuAlteracao;
                                do {
                                    System.out.println("Qual informação você deseja alterar? \n[1] Nome \n[2] Contato \n[3] Login \n[4] Senha \n[0] Cancelar");
                                    menuAlteracao = scNum.nextInt();
                                    switch (menuAlteracao) {
                                        case 1:
                                            System.out.println("Novo Nome: ");
                                            String novoNome = scText.nextLine();
                                            UsuarioService.alterarNomeUsuario(codigoUsuario, novoNome);
                                            break;
                                        case 2:
                                            System.out.println("Novo Contato: ");
                                            String novoContato = scText.nextLine();
                                            UsuarioService.alterarContatoUsuario(codigoUsuario, novoContato);
                                            break;
                                        case 3:
                                            System.out.println("Novo Login: ");
                                            String novoLogin = scText.nextLine();
                                            UsuarioService.alterarLoginUsuario(codigoUsuario, novoLogin);
                                            break;
                                        case 4:
                                            System.out.println("Nova Senha: ");
                                            String novaSenha = scText.nextLine();
                                            UsuarioService.alterarSenhaUsuario(codigoUsuario, novaSenha);
                                            break;
                                        case 0:
                                            System.out.println("Você escolheu SAIR.");
                                            break;
                                        default:
                                            throw new IllegalStateException("Valor inesperado: " + menuAlteracao);
                                    }
                                } while (menuAlteracao != 0);
                            }
                        } while (codigoUsuario != 0);
                    case 0:
                        System.out.println("Você escolheu SAIR! Até logo!");
                        break;
                    default:
                        throw new IllegalStateException("Valor inesperado: " + menu);
                }
            } while (menu != 0);
        } else if (loginValido && nivelUsuarioAtivo.equals("socorrista")) {
            do {
                System.out.println("\nPronto Atendimento Institucional UNIESP");
                System.out.println("[1] CADASTRAR Novo Atendimento");
                System.out.println("[2] CONSULTAR Paciente (não implementado)");
                System.out.println("[3] CONSULTAR Atendimento (não implementado)");
                System.out.println("[6] ALTERAR Informações Pessoais (não implementado");
                System.out.println("[0] SAIR");
                menu = scNum.nextInt();
                switch (menu) {
                    case 1:
                        Paciente pacienteNovo = new Paciente();
                        System.out.println("Informe o NOME do Paciente: ");
                        pacienteNovo.setNome(scText.nextLine());
                        System.out.println("Informe o CONTATO do Paciente: ");
                        pacienteNovo.setContato(scText.nextLine());
                        System.out.println("Informe o CÓDIGO do Paciente: ");
                        pacienteNovo.setIdPaciente(scNum.nextInt());
                        System.out.println("Informe a IDADE do Paciente: ");
                        pacienteNovo.setIdade(scNum.nextInt());
                        System.out.println("Informe o CURSO do Paciente: ");
                        pacienteNovo.setCurso(scText.nextLine());
                        System.out.println("Informe o PERÍODO do Paciente: ");
                        pacienteNovo.setPeriodo(scNum.nextInt());
                        System.out.println("Informe o SEXO do Paciente: ");
                        pacienteNovo.setSexo(scText.nextLine());
                        PacienteService.cadastrarPaciente((Paciente) pacienteNovo);

                        Atendimento atendimentoNovo = new Atendimento();
                        atendimentoNovo.setIdAtendimento(PacienteService.getUltimoId() + 1);
// (int idAtendimento, Paciente paciente, Date dataAtendimento, String motivoAtendimento, boolean dificuldadeRespiratoria, boolean febre, double febreTemperatura, boolean nauseas, boolean alergia, boolean vomitos, boolean dor, String dorLocal, boolean outraQueixa, String outraQueixaTexto, ESTADOINICIAL estadoinicial) {
                    case 2:
                        //MÉTODO de Consultar Pacientes
                    case 3:
                        //MÉTODO de Consultar Atendimentos
                    case 0:
                        System.out.println("Você escolheu SAIR! Até logo!");
                    default:
                        throw new IllegalStateException("Valor inesperado: " + menu);
                }
            } while (menu != 0);
        }
    }
}



        // Recepcionar com CLASSE e nome
        // Mostrar menu de operações dependendo da CLASSE

        //MENU Coordenadora
        // Opções:
        // * Método de criar nova Socorrista
        // * Método de consultar Paciente
        // * Método de consultar Atendimento
        // * Método de Relatório
            // Pede data de início/fim

        //MENU Socorrista
        // * Método de Alterar Próprias Informações
        // * Método de Consultar Paciente
        // * Método de Consultar Atendimento
        // * Método de Realizar Atendimento



/* Classes:
SuperClasse Pessoa
    Atributos: nome
    Atributos: contato
Classe Filha Socorrista
    Atributos: CÓDIGO, Curso, Período
Classe Filha Coordenadora
    Método: CÓDIGO, Consultar todos os atendimentos (de dado período, default esse ano).
Classe Filha Paciente
        CÓDIGO,
Classe Atendimento
        Herda CodPaciente, CodSocorrista
    Puxa date/time
    Armazena todos os atributos de queixas e sintomas

Interface Usuário
    Implementada por Socorrista e Coordenadora
    Métodos:
    Login
    Fazer Atendimento*/