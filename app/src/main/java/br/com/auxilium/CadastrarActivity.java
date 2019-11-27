package br.com.auxilium;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;
import java.util.Locale;

import br.com.auxilium.Model.TelefoneModel;
import br.com.auxilium.Model.TipoUsuarioModel;
import br.com.auxilium.Model.UsuarioModel;
import br.com.auxilium.Repository.UsuarioRepository;
import br.com.auxilium.Util.Utilidades;

public class CadastrarActivity extends AppCompatActivity {



    private EditText edtNome;
    private EditText edtLogin;
    private EditText edtSenha;
    private EditText edtEmail;
    private EditText edtNascimento;
    private EditText edtTelefone;
    private RadioGroup rgTipoUsuario;
    private RadioButton rbAluno;
    private RadioButton rbMonitor;
    private RadioGroup rgSexo;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private Button btnSalvar;
    private Button btnVoltar;
    private DatePickerDialog dpdDataNascimento;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);


        this.localizacao();
        this.criarComponentes ();
        this.criaTodososEventos ();

    }

    protected void localizacao() {

        Locale local = new Locale("pt", "BR");
        Locale.setDefault(local);
        Configuration configuration = new Configuration();
        configuration.locale = local;
        getApplicationContext().getResources().updateConfiguration(configuration, null);
    }


    protected void criarComponentes(){

        this.edtNome = (EditText)super.findViewById(R.id.edtNome);
        this.edtLogin = (EditText)super.findViewById(R.id.edtLogin);
        this.edtSenha = (EditText)super.findViewById(R.id.edtSenha);
        this.edtTelefone = (EditText)super.findViewById (R.id.edtTelefone);
        this.rgTipoUsuario = (RadioGroup)super.findViewById (R.id.rgTipoUsuario);
        this.rgSexo = (RadioGroup)super.findViewById(R.id.rgSexo);
        this.edtEmail = (EditText)super.findViewById(R.id.edtEmail);
        this.edtNascimento = (EditText)super.findViewById(R.id.edtNascimento);
        this.rbAluno = (RadioButton)super.findViewById(R.id.rbAluno);
        this.rbMonitor = (RadioButton)super.findViewById(R.id.rbMonitor);
        this.rbMasculino = (RadioButton)super.findViewById (R.id.rbMasculino);
        this.rbFeminino = (RadioButton)super.findViewById (R.id.rbFeminino);
        this.btnSalvar = (Button)super.findViewById(R.id.btnSalvar);
        this.btnVoltar = (Button)super.findViewById(R.id.btnCancelar);
    }

    protected void limparCampos(){
        this.edtNome.setText(null);
        this.edtLogin.setText(null);
        this.edtSenha.setText(null);
        this.edtTelefone.setText (null);
        this.edtEmail.setText(null);
        this.edtNascimento.setText(null);
        this.rgTipoUsuario.clearCheck ();
        this.rgSexo.clearCheck ();
    }

    protected void carregarSalvar(){

        boolean res = false;
        String email = edtEmail.getText().toString();

        if(this.edtNome.getText ().toString ().trim ().isEmpty () || this.edtNome.getText ().toString ().equals (null)){
            Utilidades.Alert (this, String.valueOf ("O Nome deve ser informado"));
            this.edtNome.requestFocus ();
        }else if(this.edtLogin.getText ().toString ().trim ().isEmpty ()){
            Utilidades.Alert (this, String.valueOf ("O Login deve ser informado"));
            edtLogin.requestFocus ();
            edtLogin.setError ("O Login é obrigatorio");
        }else if(!rbAluno.isChecked () && !rbMonitor.isChecked ()){
            Utilidades.Alert (this,String.valueOf ("Por favor informe o tipo de usuario"));
        }else if(!rbMasculino.isChecked () && !rbFeminino.isChecked ()){
            Utilidades.Alert (this, String.valueOf ("Por favor informe o sexo"));
        }else if(this.edtSenha.getText ().toString ().trim ().isEmpty ()){
            Utilidades.Alert (this, "A Senha é obrigatoria");
            edtSenha.requestFocus ();
            edtSenha.setError ("Senha obrigatoria");
        }else if(this.edtTelefone.getText ().toString ().trim ().isEmpty ()){
            Utilidades.Alert (this,String.valueOf ("O telefone é obrigatorio"));
            edtTelefone.requestFocus ();
            edtTelefone.setError ("Telefone obrigatorio");
        }else if(this.edtEmail.getText ().toString ().trim ().isEmpty () ){
            Utilidades.Alert (this,String.valueOf ("O email é obrigatorio"));
            edtEmail.requestFocus ();
            edtEmail.setError ("Email obrigatorio");
        }else if(this.edtNascimento.getText ().toString ().trim ().isEmpty ()) {
            Utilidades.Alert (this, String.valueOf ("A data de nascimento é obrigatoria"));
            edtNascimento.requestFocus ();
            edtNascimento.setError ("Data de nascimento obrigatorio");
        }else{
                UsuarioModel usuario = new UsuarioModel ();
                TipoUsuarioModel tipoUsuario = new TipoUsuarioModel ();
                TelefoneModel telefone = new TelefoneModel ();
                usuario.setNome (this.edtNome.getText ().toString ().toUpperCase ().trim ());
                usuario.setLogin (this.edtLogin.getText ().toString ().toUpperCase ().trim ());
                usuario.setSenha (this.edtSenha.getText ().toString ().toUpperCase ().trim ());
                usuario.setEmail (this.edtEmail.getText ().toString ().toUpperCase ().trim ());
                usuario.setDataNascimento (this.edtNascimento.getText ().toString ().trim ());

                ///telefone.setDescricao (this.edtTelefone.getText().toString().toUpperCase().trim());

                //if(rbAluno.isChecked ()){
                //    tipoUsuario.setDescricao ("Aluno");
                //}else{
                //    tipoUsuario.setDescricao ("Monitor");
               // }

                if (rbMasculino.isChecked ()){
                    usuario.setSexo ("Masculino");
                }else {
                    usuario.setSexo ("Feminino");
                }
                //usuario.setTipoUsuarioModel (tipoUsuario);
                //usuario.setTelefoneModel (telefone);
                ///TipoUsuarioRepository tipoRepository = new TipoUsuarioRepository (this);
                ///TelefoneRepository telefoneRepository = new TelefoneRepository (this);
                ///telefoneRepository.Salvar (telefone);

                ///Mandar o Usuario registrado para a intent da View

                UsuarioRepository usuarioRepository = new UsuarioRepository (this);
                usuarioRepository.salvar (usuario);
                Utilidades.Alert (this, "Registro salvo com sucesso");
                this.limparCampos ();
                startActivity (new Intent (CadastrarActivity.this, MainActivity.class));
            }
        }


    protected void criaTodososEventos(){
        final Calendar dataNascimento = Calendar.getInstance ();
        int ano = dataNascimento.get (Calendar.YEAR);
        final int mes = dataNascimento.get (Calendar.MONTH);
        int dia = dataNascimento.get (Calendar.DAY_OF_MONTH);

        this.dpdDataNascimento = new DatePickerDialog (this, new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String mesPicker = String.valueOf(month + 1).length() == 1 ? "0" + (month + 1) : String.valueOf(month);
                CadastrarActivity.this.edtNascimento.setText(dayOfMonth + "/ " + mes + "/" + year);
            }
        },ano,mes,dia);

        this.edtNascimento.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                dpdDataNascimento.show ();
            }
        });

        this.edtNascimento.setOnFocusChangeListener (new View.OnFocusChangeListener () {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                dpdDataNascimento.show ();
            }
        });

        btnVoltar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (CadastrarActivity.this,MainActivity.class));
                finish ();
            }
        });

        btnSalvar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                carregarSalvar ();

            }
        });



    }



}
