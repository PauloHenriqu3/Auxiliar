package br.com.auxilium.Model;

public class TipoUsuarioModel {

    private Integer idtipousuario;
    private String descricao;

    public TipoUsuarioModel() {
    }

    public TipoUsuarioModel(Integer idtipousuario, String descricao) {
        this.idtipousuario = idtipousuario;
        this.descricao = descricao;
    }

    public Integer getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Integer idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
