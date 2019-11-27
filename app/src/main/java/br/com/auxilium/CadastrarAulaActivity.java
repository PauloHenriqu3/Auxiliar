package br.com.auxilium;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.util.Calendar;

import br.com.auxilium.Model.AulaModel;
import br.com.auxilium.Repository.AulaRepository;
import br.com.auxilium.Util.Utilidades;

public class CadastrarAulaActivity extends AppCompatActivity {


    private EditText edtDisciplina;
    private EditText edtAssunto;
    private EditText edtDescricao;
    private EditText edtLocal;
    private EditText edtHorario;
    private EditText edtDataSolicitacao;
    private Button btnCadastrarAula;
    private Button btnCancelarAula;
    private DatePickerDialog dpdDataSolicitacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_cadastrar_aula);


        this.CriarComponentes ();
        this.Eventos ();

    }


    public void CriarComponentes(){

        this.edtAssunto = (EditText)super.findViewById (R.id.edtAssunto);
        this.edtDescricao = (EditText)super.findViewById (R.id.edtDescricao);
        this.edtDisciplina = (EditText)super.findViewById (R.id.edtDisciplina);
        this.edtHorario = (EditText)super.findViewById (R.id.edtHorario);
        this.edtDataSolicitacao = (EditText)super.findViewById (R.id.edtDataSolicitacao);
        this.edtLocal = (EditText)super.findViewById (R.id.edtLocal);
        this.btnCadastrarAula = (Button)super.findViewById (R.id.btnCadastrarAula);
        this.btnCancelarAula = (Button)super.findViewById (R.id.btnCancelarAula);
    }

    public void LimparCampos(){

        this.edtAssunto.setText (null);
        this.edtDescricao.setText (null);
        this.edtDisciplina.setText (null);
        this.edtLocal.setText (null);
    }

    public void SalvarAula() throws ParseException {

        if(this.edtLocal.getText ().toString ().trim ().isEmpty () || this.edtLocal.getText ().toString ().trim ().equals (null)){
            Utilidades.Alert (this, "O Local deve ser informado");
            edtLocal.requestFocus ();
        }else if(this.edtDisciplina.getText ().toString ().trim ().isEmpty () || this.edtDisciplina.getText ().toString ().trim ().equals (null)){
            Utilidades.Alert (this,"A Disciplina deve ser informada");
            edtDisciplina.requestFocus ();
        }else if (this.edtDataSolicitacao.getText ().toString ().trim ().isEmpty () || this.edtDataSolicitacao.getText ().toString ().trim ().equals (null)){
            Utilidades.Alert (this,"A Data Solicitada deve ser informada com a de hoje");
            edtDataSolicitacao.requestFocus ();
        }else if(this.edtHorario.getText ().toString ().trim ().isEmpty () || this.edtHorario.getText ().toString ().trim ().equals (null)){
            Utilidades.Alert (this,"O Horario deve ser informada");
            edtHorario.requestFocus ();
        }else if(this.edtDescricao.getText ().toString ().trim ().isEmpty () || this.edtDescricao.getText ().toString ().trim ().equals (null)){
            Utilidades.Alert (this,"A Descrição deve ser informada");
            edtDescricao.requestFocus ();
        }else if(this.edtAssunto.getText ().toString ().trim ().isEmpty () || this.edtAssunto.getText ().toString ().trim ().equals (null)){
            Utilidades.Alert (this, "O Assunto deve ser informado");
            edtAssunto.requestFocus ();
        }else{

            AulaModel aula = new AulaModel ();
            aula.setDisciplina (edtDisciplina.getText ().toString ().trim ());
            aula.setAssunto (edtAssunto.getText ().toString ().trim ());
            aula.setDescricao (edtDescricao.getText ().toString ().trim ());
            aula.setLocal (edtLocal.getText ().toString ().trim ());
            aula.setConcluido ("0");
            aula.setHorario (edtHorario.getText ().toString ().trim ());
            aula.setDataSolicitacao (edtDataSolicitacao.getText ().toString ().trim ());
            int idUsuario = getIntent ().getIntExtra ("idUsuario",1);
            aula.setIdUsuario (idUsuario);

            /*
            /// FORMATANDO A DATA COM A DATA ATUAL
            SimpleDateFormat data = new SimpleDateFormat ("dd-MM-yyyy");
            String dataSelecionada = edtDataSolicitacao.getText ().toString ().trim ();
            Date dataCerta = data.parse (dataSelecionada);
            aula.setDataSolicitacao (dataCerta);
            aula.setDataRealizacao (dataCerta);
            */
            AulaRepository aulaRepository = new AulaRepository (this);
            aulaRepository.salvar (aula);

            LimparCampos ();
            startActivity (new Intent (this, MenuPrincipalActivity.class));
        }
    }


    public void Eventos(){
        final Calendar dataNascimento = Calendar.getInstance ();
        int ano = dataNascimento.get (Calendar.YEAR);
        final int mes = dataNascimento.get (Calendar.MONTH);
        int dia = dataNascimento.get (Calendar.DAY_OF_MONTH);

        this.dpdDataSolicitacao = new DatePickerDialog (this, new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String mesPicker = String.valueOf(month + 1).length() == 1 ? "0" + (month + 1) : String.valueOf(month);
                CadastrarAulaActivity.this.edtDataSolicitacao.setText(dayOfMonth + "/ " + mes + "/" + year);
            }
        },ano,mes,dia);

        this.edtDataSolicitacao.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                dpdDataSolicitacao.show ();
            }
        });

        this.edtDataSolicitacao.setOnFocusChangeListener (new View.OnFocusChangeListener () {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                dpdDataSolicitacao.show ();
            }
        });



        btnCancelarAula.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                LimparCampos ();
                startActivity (new Intent (CadastrarAulaActivity.this,MenuPrincipalActivity.class));
                finish ();
            }
        });

        btnCadastrarAula.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                try {
                    SalvarAula ();
                } catch (ParseException e) {
                    e.printStackTrace ();
                    e.getMessage ().toString ();
                }
                startActivity (new Intent (CadastrarAulaActivity.this, MenuPrincipalActivity.class));
                finish ();
            }
        });



    }



}
