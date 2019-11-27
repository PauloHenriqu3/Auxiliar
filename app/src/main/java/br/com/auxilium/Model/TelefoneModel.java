package br.com.auxilium.Model;

public class TelefoneModel {

    private Integer idtelefone;
    private String descricao;

    public TelefoneModel() {
    }

    public TelefoneModel(Integer idtelefone, String descricao) {
        this.idtelefone = idtelefone;
        this.descricao = descricao;
    }

    public Integer getIdtelefone() {
        return idtelefone;
    }

    public void setIdtelefone(Integer idtelefone) {
        this.idtelefone = idtelefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
