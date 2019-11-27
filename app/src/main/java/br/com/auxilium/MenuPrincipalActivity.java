package br.com.auxilium;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.auxilium.Model.AulaModel;
import br.com.auxilium.Repository.AulaRepository;

public class MenuPrincipalActivity extends AppCompatActivity {

    private ListView lstViewAulas;
    private Button btnSolicitarAula;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_menu_principal);

        this.btnSolicitarAula=(Button) super.findViewById (R.id.btnSolicitarAula);
        this.lstViewAulas = (ListView) super.findViewById (R.id.lstAulas);
        this.btnVoltar = (Button)super.findViewById (R.id.btnVoltar);
        this.carregarListView ();
        this.criarEventos ();

    }


    protected void carregarListView(){

        AulaRepository aulaRepository = new AulaRepository (this);
        List<AulaModel> aulas = aulaRepository.getTodos ();

        ArrayAdapter<AulaModel> aulas2 = new ArrayAdapter<AulaModel>(MenuPrincipalActivity.this,
                android.R.layout.simple_list_item_1, aulas
        );
        lstViewAulas.setAdapter(aulas2);



    }

    protected void criarEventos(){
        btnSolicitarAula.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (MenuPrincipalActivity.this,CadastrarAulaActivity.class));
                finish ();
            }
        });

        btnVoltar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (MenuPrincipalActivity.this, MainActivity.class));
            }
        });

    }

}
