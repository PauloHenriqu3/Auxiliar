package br.com.auxilium.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.auxilium.Model.AulaModel;
import br.com.auxilium.Util.DAOUtil;

public class AulaRepository {

    private DAOUtil database;

    public AulaRepository(Context context) {
        this.database = new DAOUtil (context);
    }

    public DAOUtil getDatabase() {
        return database;
    }

    public void setDatabase(DAOUtil database) {
        this.database = database;
    }

    public void salvar(AulaModel aulaModel){
        ContentValues cv = new ContentValues ();
        cv.put ("Disciplina", aulaModel.getDisciplina ());
        cv.put ("Assunto", aulaModel.getAssunto ());
        cv.put ("Descricao", aulaModel.getDescricao ());
        cv.put ("Horario", aulaModel.getHorario ());
        cv.put ("Local", aulaModel.getLocal ());
        cv.put ("DataSolicitacao", aulaModel.getDataSolicitacao ());
        cv.put ("Concluido", aulaModel.getConcluido ());
        cv.put ("idUsuario", aulaModel.getIdUsuario ());
        database.getConnection ().insertOrThrow ("tb_Aula", null,cv);
    }

    public void atualizar(AulaModel aulaModel){

        ContentValues cv = new ContentValues ();
        cv.put ("Disciplina", aulaModel.getDisciplina ());
        cv.put ("Assunto", aulaModel.getAssunto ());
        cv.put ("Descricao", aulaModel.getDescricao ());
        cv.put ("Horario", aulaModel.getHorario ());
        cv.put ("Local", aulaModel.getLocal ());
        cv.put ("DataSolicitacao", aulaModel.getDataSolicitacao ());
        cv.put ("Concluido", aulaModel.getConcluido ());
        cv.put ("idUsuario", aulaModel.getIdUsuario ());
        database.getConnection ().update ("tb_Aula", cv,"idAula", new String[]{Integer.toString (aulaModel.getIdAula ())});
    }

    public void excluir(int idAula){
        database.getConnection ().delete ("tb_Aula","idAula=?", new String[]{Integer.toString (idAula)});
    }

    public AulaModel getAula(int idAula){

        AulaModel aulaaux = new AulaModel ();
        String sql = "SELECT * FROM tb_Aula WHERE idAula = " + Integer.toString (idAula);
        Cursor cursor = database.getConnection ().rawQuery (sql, null);
        cursor.moveToFirst ();

        aulaaux.setIdAula (cursor.getInt (cursor.getColumnIndex ("idAula")));
        aulaaux.setDisciplina (cursor.getString (cursor.getColumnIndex ("Disciplina")));
        aulaaux.setAssunto (cursor.getString (cursor.getColumnIndex ("Assunto")));
        aulaaux.setDescricao (cursor.getString (cursor.getColumnIndex ("Descricao")));
        aulaaux.setHorario (cursor.getString (cursor.getColumnIndex ("Horario")));
        aulaaux.setLocal (cursor.getString (cursor.getColumnIndex ("Local")));
        aulaaux.setDataSolicitacao (cursor.getString (cursor.getColumnIndex ("DataSolicitacao")));
        aulaaux.setConcluido (cursor.getString (cursor.getColumnIndex ("Concluido")));
        aulaaux.setIdUsuario (cursor.getInt (cursor.getColumnIndex ("idUsuario")));
        cursor.close ();

        return aulaaux;
    }

    public List<AulaModel> getTodos(){
        List<AulaModel> aulas = new ArrayList<> ();
        String sql =  "SELECT * FROM tb_Aula";
        Cursor cursor = database.getConnection ().rawQuery (sql, null);
        while (cursor.moveToNext ()){

            AulaModel aulaaux = new AulaModel ();
            aulaaux.setIdAula (cursor.getInt (cursor.getColumnIndex ("idAula")));
            aulaaux.setDisciplina (cursor.getString (cursor.getColumnIndex ("Disciplina")));
            aulaaux.setAssunto (cursor.getString (cursor.getColumnIndex ("Assunto")));
            aulaaux.setDescricao (cursor.getString (cursor.getColumnIndex ("Descricao")));
            aulaaux.setHorario (cursor.getString (cursor.getColumnIndex ("Horario")));
            aulaaux.setLocal (cursor.getString (cursor.getColumnIndex ("Local")));
            aulaaux.setDataSolicitacao (cursor.getString (cursor.getColumnIndex ("DataSolicitacao")));
            aulaaux.setConcluido (cursor.getString (cursor.getColumnIndex ("Concluido")));
            aulaaux.setIdUsuario (cursor.getInt (cursor.getColumnIndex ("idUsuario")));

            aulas.add (aulaaux);
        }
        cursor.close ();
        return aulas;
    }


}











