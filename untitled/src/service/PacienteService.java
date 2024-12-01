package service;
import model.Paciente;
import java.util.ArrayList;

public interface PacienteService {
// @POST, cria uma lista com todos os Atendimentos.
    ArrayList<Paciente> pacientes = new ArrayList<>();

    static void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

// GET da lista de Pacientes
    static ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

// GET do código do ÚLTIMO Paciente
    static int getUltimoId() {
        return pacientes.get(-1).getIdPaciente();
    }

// MÉTODO para Exibir Informações de UM Paciente
    static boolean infoPaciente(int codigoPaciente) {
        int i = 0;
        for (Paciente paciente : pacientes) {
            if (codigoPaciente == pacientes.get(i).getIdPaciente()) {
                Paciente pacienteAtivo = pacientes.get(i);
                System.out.printf("\nCÓDIGO DO PACIENTE: %d - \n Nome do Paciente: %s - Contato: %s -  Idade: %d\n - Curso: %s - Período: %d - Sexo: %s", pacienteAtivo.getIdPaciente(), pacienteAtivo.getNome(), pacienteAtivo.getContato(), pacienteAtivo.getIdade(), pacienteAtivo.getCurso(), pacienteAtivo.getPeriodo(), pacienteAtivo.getSexo());
                return true;
            } else {
                i++;
            }
        }
        System.out.println("Código de Paciente não encontrado!");
        return false;
    }

}
