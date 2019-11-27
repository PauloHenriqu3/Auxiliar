package br.com.auxilium.Util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import br.com.auxilium.Model.AulaModel;

public class AdapterAula extends RecyclerView.Adapter {

    private List<AulaModel> aulaModels;

    public AdapterAula(List<AulaModel> aulas){
        this.aulaModels = aulas;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return aulaModels.size ();
    }
}
