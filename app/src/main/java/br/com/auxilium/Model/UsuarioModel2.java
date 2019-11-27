package br.com.auxilium.Model;

import java.util.Date;

public class UsuarioModel2 {

    private Integer idUsuario;
    private String Nome;
    private String Login;
    private String Senha;
    private String Email;
    private Date DataNascimento;
    private TipoUsuarioModel tipoUsuario;
    private Integer idTipoUsuario;
    private EnderecoModel Endereco;
    private Integer IdEndereco;
    private InstituicaoEnsinoModel instituicaoEnsino;
    private Integer idInstituicaoEnsino;

    public UsuarioModel2() {
    }

    public UsuarioModel2(Integer idUsuario, String nome, String login, String senha, String email, Date dataNascimento, TipoUsuarioModel tipoUsuario, Integer idTipoUsuario, EnderecoModel endereco, Integer idEndereco, InstituicaoEnsinoModel instituicaoEnsino, Integer idInstituicaoEnsino) {
        this.idUsuario = idUsuario;
        Nome = nome;
        Login = login;
        Senha = senha;
        Email = email;
        DataNascimento = dataNascimento;
        this.tipoUsuario = tipoUsuario;
        this.idTipoUsuario = idTipoUsuario;
        Endereco = endereco;
        IdEndereco = idEndereco;
        this.instituicaoEnsino = instituicaoEnsino;
        this.idInstituicaoEnsino = idInstituicaoEnsino;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public TipoUsuarioModel getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioModel tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public EnderecoModel getEndereco() {
        return Endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        Endereco = endereco;
    }

    public Integer getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        IdEndereco = idEndereco;
    }

    public InstituicaoEnsinoModel getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(InstituicaoEnsinoModel instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public Integer getIdInstituicaoEnsino() {
        return idInstituicaoEnsino;
    }

    public void setIdInstituicaoEnsino(Integer idInstituicaoEnsino) {
        this.idInstituicaoEnsino = idInstituicaoEnsino;
    }
}
