package br.com.auxilium.Model;

import android.support.annotation.NonNull;

public class AulaModel {

    private Integer idAula;
    private String disciplina;
    private String assunto;
    private String descricao;
    private String dataSolicitacao;
    private String local;
    private String horario;
    private UsuarioModel usuario;
    private Integer idUsuario;
    private String concluido;

    public AulaModel() {
    }

    public AulaModel(Integer idAula, String disciplina, String assunto, String descricao, String dataSolicitacao, String local, String horario, UsuarioModel usuario, Integer idUsuario, String concluido) {
        this.idAula = idAula;
        this.disciplina = disciplina;
        this.assunto = assunto;
        this.descricao = descricao;
        this.dataSolicitacao = dataSolicitacao;
        this.local = local;
        this.horario = horario;
        this.usuario = usuario;
        this.idUsuario = idUsuario;
        this.concluido = concluido;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getConcluido() {
        return concluido;
    }

    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }


    @NonNull
    @Override
    public String toString() {
        return local;
    }
}
