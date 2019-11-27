package br.com.auxilium.Model;

public class InstituicaoEnsinoModel {

    private Integer idinstituicaoensino;
    private String nome;

    public InstituicaoEnsinoModel() {
    }

    public InstituicaoEnsinoModel(Integer idinstituicaoensino, String nome) {
        this.idinstituicaoensino = idinstituicaoensino;
        this.nome = nome;
    }

    public Integer getIdinstituicaoensino() {
        return idinstituicaoensino;
    }

    public void setIdinstituicaoensino(Integer idinstituicaoensino) {
        this.idinstituicaoensino = idinstituicaoensino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
