package br.com.auxilium.Model;

public class EnderecoModel {

    private Integer idEndereco;
    private String Endereco;
    private String Numero;
    private String Bairro;
    private String Cidade;
    private Integer cep;
    private Integer idEstado;
    private EstadoModel estado;

    public EnderecoModel() {
    }

    public EnderecoModel(Integer idEndereco, String endereco, String numero, String bairro, String cidade, Integer cep, Integer idEstado, EstadoModel estado) {
        this.idEndereco = idEndereco;
        Endereco = endereco;
        Numero = numero;
        Bairro = bairro;
        Cidade = cidade;
        this.cep = cep;
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }
}
