package br.com.auxilium.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class UsuarioModel implements Parcelable {

    private Integer codigo;
    private String nome;
    private String login;
    private String senha;
    private String email;
    private String dataNascimento;
    private String sexo;




    public UsuarioModel() {
    }

    public UsuarioModel(Integer codigo, String nome, String login, String senha, String email, String dataNascimento, String sexo) {
        this.codigo = codigo;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;

    }

    public static final Parcelable.Creator
            CREATOR = new Parcelable.Creator() {

        public UsuarioModel createFromParcel(Parcel in) {
            return new UsuarioModel(in);
        }

        public UsuarioModel[] newArray(int size) {
            return new UsuarioModel[size];
        }
    };



    protected UsuarioModel(Parcel in) {
        if (in.readByte () == 0) {
            codigo = null;
        } else {
            codigo = in.readInt ();
        }
        nome = in.readString ();
        login = in.readString ();
        senha = in.readString ();
        email = in.readString ();
        dataNascimento = in.readString ();
        sexo = in.readString ();
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt (codigo);
        dest.writeString (login);
        dest.writeString (nome);
        dest.writeString (senha);
        dest.writeString (email);
        dest.writeString (dataNascimento);

    }
}
