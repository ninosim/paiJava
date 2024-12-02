package service;
import model.Atendimento;
import model.Paciente;
import java.util.ArrayList;


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

// GET do código do ÚLTIMO Atendimento
    static int getUltimoId() {
        return atendimentos.get(atendimentos.size() - 1).getIdAtendimento();
    }


    // MÉTODO para Exibir Informações de UM Atendimento
    static boolean infoAtendimento(int codigo) {
        int i = 0;
        for (Atendimento atendimento : atendimentos) {
            if (codigo == atendimentos.get(i).getIdAtendimento()) {
                Atendimento atendimentoAtivo = atendimentos.get(i);
                Paciente pacienteAtivo = atendimentos.get(i).getPaciente();
                System.out.printf("\nCÓDIGO DO ATENDIMENTO: %d - Data: %tc\n Nome do Paciente: %s - Idade: %d \nCurso: %s - Período: %d - Sexo: %s", atendimentoAtivo.getIdAtendimento(), atendimentoAtivo.getDataAtendimento(), pacienteAtivo.getNome(), pacienteAtivo.getIdade(), pacienteAtivo.getCurso(), pacienteAtivo.getPeriodo(), pacienteAtivo.getSexo());
                System.out.printf("\nPRINCIPAIS QUEIXAS: Dificuldade Respiratória: %b - Febre: %b ( %.1f graus) - Náuseas: %b - Alergia: %b - Dor: %b (Local: %s)", atendimentoAtivo.isDificuldadeRespiratoria(), atendimentoAtivo.isFebre(), atendimentoAtivo.getFebreTemperatura(), atendimentoAtivo.isNauseas(), atendimentoAtivo.isAlergia(), atendimentoAtivo.isDor(), atendimentoAtivo.getDorLocal());
                System.out.printf("\nESTADO INICIAL:", atendimentoAtivo.getEstadoInicial().toString());
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

//MÉTODO para Exibir um Resumo de Todos os Atendimentos
    static void resumoAtendimentos() {
        for (Atendimento atendimento : atendimentos) {
            System.out.printf("\nCÓDIGO: %d - Paciente: %s - Data: %tD- Motivo do Atendimento: %s", atendimento.getIdAtendimento(), atendimento.getPaciente().getNome(), atendimento.getDataAtendimento(), atendimento.getMotivoAtendimento());
        }
    }
}