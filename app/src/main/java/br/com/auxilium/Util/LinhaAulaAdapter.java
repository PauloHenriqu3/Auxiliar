package br.com.auxilium.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.auxilium.MenuPrincipalActivity;
import br.com.auxilium.Model.AulaModel;
import br.com.auxilium.R;
import br.com.auxilium.Repository.AulaRepository;

public class LinhaAulaAdapter extends BaseAdapter {

    private static LayoutInflater layoutInflater = null;
    private List<AulaModel> aulas = new ArrayList<> ();
    private MenuPrincipalActivity menuPrincipalActivity;
    private AulaRepository aulaRepository;

    public LinhaAulaAdapter(List<AulaModel> aulas, MenuPrincipalActivity menuPrincipalActivity, AulaRepository aulaRepository) {
        this.aulas = aulas;
        layoutInflater = (LayoutInflater)this.menuPrincipalActivity.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
        this.menuPrincipalActivity = menuPrincipalActivity;
        this.aulaRepository = new AulaRepository (menuPrincipalActivity);
    }

    public LinhaAulaAdapter(MenuPrincipalActivity menuPrincipalActivity, List<AulaModel> aulas) {
    }

    @Override
    public int getCount() {
        return aulas.size ();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final View viewLinha = layoutInflater.inflate (R.layout.linha_aula, null);
        TextView txtVIdAula = (TextView)viewLinha.findViewById (R.id.txtLinhaId);
        TextView txtVDisciplina = (TextView)viewLinha.findViewById (R.id.txtLinhaDisciplina);
        TextView txtVAssunto = (TextView)viewLinha.findViewById (R.id.txtLinhaAssunto);
        TextView txtVDescricao = (TextView)viewLinha.findViewById (R.id.txtLinhaDescricao);
        TextView txtVLocal = (TextView)viewLinha.findViewById (R.id.txtLinhaLocal);
        TextView txtVHorairo = (TextView)viewLinha.findViewById (R.id.txtLinhaHorario);
        TextView txtVDataRealizacao = (TextView)viewLinha.findViewById (R.id.txtLinhaDataSolicitacao);
        Button btnVExcluir = (Button)viewLinha.findViewById (R.id.btnLinhaExcluirAula);
        Button btnVAlterar = (Button)viewLinha.findViewById (R.id.btnLinhaAlterarAula);


        txtVIdAula.setText (String.valueOf (aulas.get (position).getIdAula ()));
        txtVDisciplina.setText (String.valueOf (aulas.get (position).getDisciplina ()));
        txtVAssunto.setText (String.valueOf (aulas.get (position).getAssunto ()));
        txtVDescricao.setText (String.valueOf (aulas.get (position).getDescricao ()));
        txtVLocal.setText (String.valueOf (aulas.get (position).getLocal ()));
        txtVHorairo.setText (String.valueOf (aulas.get (position).getHorario ()));
        txtVDataRealizacao.setText (String.valueOf (aulas.get (position).getDataSolicitacao ()));

        btnVExcluir.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                aulaRepository.excluir (aulas.get (position).getIdAula ());
                Toast.makeText (menuPrincipalActivity, "Aula Excluida com sucesso!", Toast.LENGTH_LONG).show ();
                aulas.clear ();
                aulas = aulaRepository.getTodos ();
                notifyDataSetChanged ();

            }
        });

        btnVAlterar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

            }
        });


        return viewLinha;

    }

    public void refreshList(){
        this.aulas.clear ();
        this.aulas = this.aulaRepository.getTodos ();
        this.notifyDataSetChanged ();
    }


}
