package br.com.auxilium.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAOUtil extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "Auxilium.db";
    private static final int VERSAO = 1;

    public DAOUtil(Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder sql = new StringBuilder ();
        sql.append ("CREATE TABLE   tb_Usuario (");
        sql.append ("idUsuario  INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append ("Nome   TEXT NOT NULL, ");
        sql.append ("Login  TEXT NOT NULL, ");
        sql.append ("Senha  TEXT NOT NULL, ");
        sql.append ("Email  TEXT NOT NULL, ");
        sql.append ("DataNascimento TEXT NOT NULL, ");
        sql.append ("Sexo TEXT NOT NULL)");

        StringBuilder sql2 = new StringBuilder ();
        sql2.append ("CREATE TABLE   tb_Aula (");
        sql2.append ("idAula    INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql2.append ("Disciplina    TEXT NOT NULL, ");
        sql2.append ("Assunto   TEXT NOT NULL, ");
        sql2.append ("Descricao TEXT NOT NULL, ");
        sql2.append ("DataSolicitacao   TEXT NOT NULL, ");
        sql2.append ("Local TEXT NOT NULL, ");
        sql2.append ("Horario   TEXT NOT NULL, ");
        sql2.append ("idUsuario    INTEGER NOT NULL, ");
        sql2.append ("Concluido TEXT NOT NULL)");



/*

db.execSQL ("DROP TABLE IF EXISTS tb_Aula");
*/
        db.execSQL (sql.toString ());
        db.execSQL (sql2.toString ());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("DROP TABLE IF EXISTS tb_Usuario");
        db.execSQL ("DROP TABLE IF EXISTS tb_Aula");

        onCreate (db);

    }

    public SQLiteDatabase getConnection(){
        return this.getWritableDatabase ();
    }
}
