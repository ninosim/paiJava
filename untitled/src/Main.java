import java.util.*;

import model.*;
import service.*;
import enums.*;

public class Main {
    public static void main(String[] args) {
        Scanner scNum = new Scanner(System.in);
        Scanner scText = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        String login;
        String senha;
        String nivelUsuarioAtivo = "";
        boolean loginValido = false;
        int menu;
        Usuario usuarioAtivo = null;

// INSTÂNCIAS previamente cadastradas para popular o banco de dados:
        Pessoa admin = new Coordenadora("Admin", "83989991234", NIVELUSUARIO.Coordenadora, "admin", "1234", 2024999001);
        UsuarioService.cadastrarUsuario((Usuario) admin);
        Pessoa socorrista = new Socorrista("Vitória", "839898989898", NIVELUSUARIO.Socorrista, "vitoria85", "1234", 202455001, CURSOS.Farmácia, 4);
        UsuarioService.cadastrarUsuario((Usuario) socorrista);
        Pessoa socorrista2 = new Socorrista("user", "83555555555", NIVELUSUARIO.Socorrista, "user", "1234", 202455000, CURSOS.Biomedicina, 1);
        UsuarioService.cadastrarUsuario((Usuario) socorrista2);
        Paciente paciente = new Paciente("Arthur", "arthur@bol.com.br", 202400001, 21,"Sistemas para Internet", 2, "Masculino");
        PacienteService.cadastrarPaciente(paciente);
        Date d1 = new Date();
        Atendimento atendimento = new Atendimento(2024000000, paciente, d1, "Coceira e enjôo", false, true, 37, true, true, false, false, "n/a", false, "n/a", ESTADOINICIAL.Leve_e_Instavel);
        AtendimentoService.cadastrarAtendimento(atendimento);


        System.out.println("\n\n\nPronto Atendimento Institucional UNIESP");
        while (!loginValido) {
            System.out.println("Digite seu LOGIN: ");
            login = scText.nextLine();
            System.out.println("Digite sua SENHA: ");
            senha = scText.nextLine();
            if ((Usuario.validarUsuario(login, senha))) {
                usuarioAtivo = (UsuarioService.consultarUsuario(login));
                if (Objects.equals(usuarioAtivo.getNivelUsuario().toString(), "Coordenadora")) {
                    System.out.println("Bem-vinda, Coordenadora " + usuarioAtivo.getNome());
                    loginValido = true;
                    nivelUsuarioAtivo = "coord";

                } else if (Objects.equals(usuarioAtivo.getNivelUsuario().toString(), "Socorrista")) {
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
                System.out.println("\n\nPronto Atendimento Institucional UNIESP");
                System.out.println("[1] CRIAR Relatório (não implementado)");
                System.out.println("[2] CONSULTAR Paciente");
                System.out.println("[3] CONSULTAR Atendimento");
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
                        PacienteService.consultarPacientes();
                        System.out.println("\nInforme o CÓDIGO do Paciente que deseja consultar: ");
                        int codigoPaciente = scNum.nextInt();
                        if (codigoPaciente == 0) {
                            System.out.println("Você escolheu SAIR!");
                            break;
                        } else {
                            PacienteService.infoPaciente(codigoPaciente);
                        }
                        break;
                    case 3:
                        /// Método Consultar Atendimento
                        AtendimentoService.resumoAtendimentos();
                        System.out.println("\nInforme o CÓDIGO do Atendimento que deseja consultar: ");
                        int codigoAtend = scNum.nextInt();
                        if (codigoAtend == 0) {
                            System.out.println("Você escolheu SAIR!");
                            break;
                        } else {
                            AtendimentoService.infoAtendimento(codigoAtend);
                        }
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
                System.out.println("\n\nPronto Atendimento Institucional UNIESP");
                System.out.println("[1] CADASTRAR Novo Atendimento");
                System.out.println("[2] CONSULTAR Paciente");
                System.out.println("[3] CONSULTAR Atendimento");
                System.out.println("[4] ALTERAR Informações Pessoais");
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
                        System.out.println("Informe o CÓDIGO do atendimento: ");
                        atendimentoNovo.setIdAtendimento(scNum.nextInt());
                        atendimentoNovo.setPaciente(pacienteNovo);
                        atendimentoNovo.setDataAtendimento(d1);
                        System.out.println("Informe o MOTIVO do atendimento: ");
                        atendimentoNovo.setMotivoAtendimento(scText.nextLine());
                        System.out.println("Paciente apresenta DIFICULDADE RESPIRATÓRIA? (S/N)");
                        String menuSN = scText.nextLine();
                        if (menuSN.equals("S")) {
                            atendimentoNovo.setDificuldadeRespiratoria(true);
                        } else {
                            atendimentoNovo.setDificuldadeRespiratoria(false);
                        }
                        System.out.println("Paciente apresenta FEBRE? (S/N)");
                        menuSN = scText.nextLine();
                        if (menuSN.equals("S")) {
                            atendimentoNovo.setFebre(true);
                            System.out.println("Qual a temperatura do Paciente (em graus Celsius)?");
                            atendimentoNovo.setFebreTemperatura(scNum.nextDouble());
                        } else {
                            atendimentoNovo.setDificuldadeRespiratoria(false);
                            atendimentoNovo.setFebreTemperatura(0);
                        }
                        System.out.println("Paciente apresenta NÁUSEAS? (S/N)");
                        menuSN = scText.nextLine();
                        if (menuSN.equals("S")) {
                            atendimentoNovo.setNauseas(true);
                        } else {
                            atendimentoNovo.setNauseas(false);
                        }

                        System.out.println("Paciente apresenta ALERGIA? (S/N)");
                        menuSN = scText.nextLine();
                        if (menuSN.equals("S")) {
                            atendimentoNovo.setAlergia(true);
                        } else {
                            atendimentoNovo.setAlergia(false);
                        }

                        System.out.println("Paciente apresenta VÔMITOS? (S/N)");
                        menuSN = scText.nextLine();
                        if (menuSN.equals("S")) {
                            atendimentoNovo.setVomitos(true);
                        } else {
                            atendimentoNovo.setVomitos(false);
                        }

                        System.out.println("Paciente apresenta DOR? (S/N)");
                        menuSN = scText.nextLine();
                        if (menuSN.equals("S")) {
                            atendimentoNovo.setDor(true);
                            System.out.println("Qual o local da dor?");
                            atendimentoNovo.setDorLocal(scText.nextLine());
                        } else {
                            atendimentoNovo.setDor(false);
                            atendimentoNovo.setDorLocal("");
                        }
                        System.out.println("Paciente apresenta OUTRAS QUEIXAS? (S/N)");
                        menuSN = scText.nextLine();
                        if (menuSN.equals("S")) {
                            atendimentoNovo.setOutraQueixa(true);
                            System.out.println("Qual é a outra queixa?");
                            atendimentoNovo.setOutraQueixaTexto(scText.nextLine());
                        } else {
                            atendimentoNovo.setOutraQueixa(false);
                            atendimentoNovo.setOutraQueixaTexto("");
                        }
                        System.out.println("Qual é o ESTADO INICIAL do Paciente?");
                        System.out.println("Digite [1] para Leve e Estável");
                        System.out.println("Digite [2] para Leve e Instável");
                        System.out.println("Digite [3] para Moderado e Estável");
                        System.out.println("Digite [4] para Moderado e Instável");
                        System.out.println("Digite [5] para Grave e Estável");
                        System.out.println("Digite [6] para Grave e Instável");
                        System.out.println("Digite [7] para Crítico e Estável");
                        System.out.println("Digite [8] para Crítico e Instável");
                        System.out.println("Digite [5] para Grave e Estável");
                        int menuEstado = scNum.nextInt();
                        switch (menuEstado) {
                            case 1:
                                atendimentoNovo.setEstadoInicial(ESTADOINICIAL.Leve_e_Estavel);
                                break;
                            case 2:
                                atendimentoNovo.setEstadoInicial(ESTADOINICIAL.Leve_e_Instavel);
                                break;
                            case 3:
                                atendimentoNovo.setEstadoInicial(ESTADOINICIAL.Moderado_e_Estavel);
                                break;
                            case 4:
                                atendimentoNovo.setEstadoInicial(ESTADOINICIAL.Moderado_e_Instavel);
                                break;
                            case 5:
                                atendimentoNovo.setEstadoInicial(ESTADOINICIAL.Grave_e_Estavel);
                                break;
                            case 6:
                                atendimentoNovo.setEstadoInicial(ESTADOINICIAL.Grave_e_Instavel);
                                break;
                            case 7:
                                atendimentoNovo.setEstadoInicial(ESTADOINICIAL.Critico_e_Estavel);
                                break;
                            case 8:
                                atendimentoNovo.setEstadoInicial(ESTADOINICIAL.Critico_e_Instavel);
                                break;
                            default:
                                throw new IllegalStateException("Valor inesperado: " + menuEstado);
                        }
                        AtendimentoService.cadastrarAtendimento(atendimentoNovo);
                        break;
                    case 2:
                        //MÉTODO de Consultar Pacientes
                        PacienteService.consultarPacientes();
                        System.out.println("Informe o CÓDIGO do Paciente que deseja consultar: ");
                        int codigoPaciente = scNum.nextInt();
                        if (codigoPaciente == 0) {
                            System.out.println("Você escolheu SAIR!");
                            break;
                        } else {
                            PacienteService.infoPaciente(codigoPaciente);
                        }
                        break;
                    case 3:
                        /// Método Consultar Atendimento
                        AtendimentoService.resumoAtendimentos();
                        System.out.println("\nInforme o CÓDIGO do Atendimento que deseja consultar: ");
                        int codigoAtend = scNum.nextInt();
                        if (codigoAtend == 0) {
                            System.out.println("Você escolheu SAIR!");
                            break;
                        } else {
                            AtendimentoService.infoAtendimento(codigoAtend);
                        }
                        break;
                    case 4:
                        int menuAlteracao;
                        do {
                            System.out.println("Qual informação você deseja alterar? \n[1] Nome \n[2] Contato \n[3] Login \n[4] Senha \n[0] Cancelar");
                            menuAlteracao = scNum.nextInt();
                            switch (menuAlteracao) {
                                case 1:
                                    System.out.println("Novo Nome: ");
                                    String novoNome = scText.nextLine();
                                    UsuarioService.alterarNomeUsuario(usuarioAtivo.getIdUsuario(), novoNome);
                                    break;
                                case 2:
                                    System.out.println("Novo Contato: ");
                                    String novoContato = scText.nextLine();
                                    UsuarioService.alterarContatoUsuario(usuarioAtivo.getIdUsuario(), novoContato);
                                    break;
                                case 3:
                                    System.out.println("Novo Login: ");
                                    String novoLogin = scText.nextLine();
                                    UsuarioService.alterarLoginUsuario(usuarioAtivo.getIdUsuario(), novoLogin);
                                    break;
                                case 4:
                                    System.out.println("Nova Senha: ");
                                    String novaSenha = scText.nextLine();
                                    UsuarioService.alterarSenhaUsuario(usuarioAtivo.getIdUsuario(), novaSenha);
                                    break;
                                case 0:
                                    System.out.println("Você escolheu SAIR.");
                                    break;
                                default:
                                    throw new IllegalStateException("Valor inesperado: " + menuAlteracao);
                            }
                        } while (menuAlteracao != 0);
                    case 0:
                        System.out.println("Você escolheu SAIR! Até logo!");
                    default:
                        throw new IllegalStateException("Valor inesperado: " + menu);
                }
            } while (menu != 0);
        }
    }
}

//TO-DO:
// * Método de Relatório
    // Pede data de início/fim e retorna todos os atendimentos nesse período.