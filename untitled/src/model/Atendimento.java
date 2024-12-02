package model;

import enums.ESTADOINICIAL;
import service.AtendimentoService;
import java.util.Date;
import java.util.Calendar;

public class Atendimento implements AtendimentoService {
    private int idAtendimento;
    private Paciente paciente;
    private int idPaciente;
    private Date dataAtendimento;
    private String motivoAtendimento;
    private boolean dificuldadeRespiratoria;
    private boolean febre;
    private double febreTemperatura;
    private boolean nauseas;
    private boolean alergia;
    private boolean vomitos;
    private boolean dor;
    private String dorLocal;
    private boolean outraQueixa;
    private String outraQueixaTexto;
    private ESTADOINICIAL estadoInicial;

// CONSTRUTORES
    public Atendimento(int idAtendimento, Paciente paciente, Date dataAtendimento, String motivoAtendimento, boolean dificuldadeRespiratoria, boolean febre, double febreTemperatura, boolean nauseas, boolean alergia, boolean vomitos, boolean dor, String dorLocal, boolean outraQueixa, String outraQueixaTexto, ESTADOINICIAL estadoinicial) {
        this.idAtendimento = idAtendimento;
        this.paciente = paciente;
        this.idPaciente = paciente.getIdPaciente();
        this.dataAtendimento = dataAtendimento;
        this.motivoAtendimento = motivoAtendimento;
        this.dificuldadeRespiratoria = dificuldadeRespiratoria;
        this.febre = febre;
        this.febreTemperatura = febreTemperatura;
        this.nauseas = nauseas;
        this.alergia = alergia;
        this.vomitos = vomitos;
        this.dor = dor;
        this.dorLocal = dorLocal;
        this.outraQueixa = outraQueixa;
        this.outraQueixaTexto = outraQueixaTexto;
        this.estadoInicial = estadoinicial;
    }

    public Atendimento() {
    }

// GETTERS & SETTERS

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setEstadoInicial(ESTADOINICIAL estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public ESTADOINICIAL getEstadoInicial() {
        return estadoInicial;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getMotivoAtendimento() {
        return motivoAtendimento;
    }

    public void setMotivoAtendimento(String motivoAtendimento) {
        this.motivoAtendimento = motivoAtendimento;
    }

    public boolean isDificuldadeRespiratoria() {
        return dificuldadeRespiratoria;
    }

    public void setDificuldadeRespiratoria(boolean dificuldadeRespiratoria) {
        this.dificuldadeRespiratoria = dificuldadeRespiratoria;
    }

    public boolean isFebre() {
        return febre;
    }

    public void setFebre(boolean febre) {
        this.febre = febre;
    }

    public double getFebreTemperatura() {
        return febreTemperatura;
    }

    public void setFebreTemperatura(double febreTemperatura) {
        this.febreTemperatura = febreTemperatura;
    }

    public boolean isNauseas() {
        return nauseas;
    }

    public void setNauseas(boolean nauseas) {
        this.nauseas = nauseas;
    }

    public boolean isAlergia() {
        return alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public boolean isVomitos() {
        return vomitos;
    }

    public void setVomitos(boolean vomitos) {
        this.vomitos = vomitos;
    }

    public boolean isDor() {
        return dor;
    }

    public void setDor(boolean dor) {
        this.dor = dor;
    }

    public String getDorLocal() {
        return dorLocal;
    }

    public void setDorLocal(String dorLocal) {
        this.dorLocal = dorLocal;
    }

    public boolean isOutraQueixa() {
        return outraQueixa;
    }

    public void setOutraQueixa(boolean outraQueixa) {
        this.outraQueixa = outraQueixa;
    }

    public String getOutraQueixaTexto() {
        return outraQueixaTexto;
    }

    public void setOutraQueixaTexto(String outraQueixaTexto) {
        this.outraQueixaTexto = outraQueixaTexto;
    }
}