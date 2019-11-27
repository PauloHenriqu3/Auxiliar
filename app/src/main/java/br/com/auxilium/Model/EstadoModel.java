package br.com.auxilium.Model;

public class EstadoModel {

    private Integer idestado;
    private String sigla;
    private String descricao;

    public EstadoModel() {
    }

    public EstadoModel(Integer idestado, String sigla, String descricao) {
        this.idestado = idestado;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
