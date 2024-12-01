package service;
import model.Atendimento;
import model.Paciente;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public interface AtendimentoService {
// @POST, cria uma lista com todos os Atendimentos.
    ArrayList<Atendimento> atendimentos = new ArrayList<>();

    static void cadastrarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        System.out.println("Atendimento cadastrado com sucesso!");
    }

// GET da lista de Atendimentos
    static ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }


// MÉTODO para Exibir Informações de UM Atendimento
    static boolean infoAtendimento(int codigo) {
        int i = 0;
        for (Atendimento atendimento : atendimentos) {
            if (codigo == atendimentos.get(i).getIdAtendimento()) {
                Atendimento atendimentoAtivo = atendimentos.get(i);
                Paciente pacienteAtivo = atendimentos.get(i).getPaciente();
                System.out.printf("\nCÓDIGO DO ATENDIMENTO: %d - Data: %tc\n Nome do Paciente: %s - Idade: %d\n - Curso: %s - Período: %d - Sexo: %s", atendimentoAtivo.getIdAtendimento(), atendimentoAtivo.getDataAtendimento(), pacienteAtivo.getNome(), pacienteAtivo.getIdade(), pacienteAtivo.getCurso(), pacienteAtivo.getPeriodo(), pacienteAtivo.getSexo());
                System.out.printf("\nPRINCIPAIS QUEIXAS: Dificuldade Respiratória: %b - Febre: %b ( %f graus) - Náuseas: %b - Alergia: %b", atendimentoAtivo.isDificuldadeRespiratoria(), atendimentoAtivo.isFebre(), atendimentoAtivo.getFebreTemperatura(), atendimentoAtivo.isNauseas(), atendimentoAtivo.isAlergia());
                System.out.printf("\nESTADO INICIAL:", atendimentoAtivo.getEstadoInicial()), ;
                return true;
            } else {
                i++;
            }
        }
        System.out.println("Código de usuário não encontrado!");
        return false;
    }

//MÉTODO para Exibir Todos os Atendimentos de um Paciente
    static void consultarAtendimentosPaciente(int codigoPaciente) {
        for (Atendimento atendimento : atendimentos) {
            if (codigoPaciente == atendimento.getIdPaciente()) {
                AtendimentoService.infoAtendimento(codigoPaciente);
            }
        }
    }
}