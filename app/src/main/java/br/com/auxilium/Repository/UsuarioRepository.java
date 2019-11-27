package br.com.auxilium.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.auxilium.Model.UsuarioModel;
import br.com.auxilium.Util.DAOUtil;

public class UsuarioRepository {

    private DAOUtil dataBaseUtil;

    public UsuarioRepository(Context context) {
        this.dataBaseUtil = new DAOUtil (context);
    }

    public DAOUtil getDataBaseUtil() {
        return dataBaseUtil;
    }

    public void setDataBaseUtil(DAOUtil dataBaseUtil) {
        this.dataBaseUtil = dataBaseUtil;
    }

    public void salvar(UsuarioModel usuario) {

        ContentValues cv = new ContentValues ();
        cv.put ("Nome", usuario.getNome ());
        cv.put ("Login", usuario.getLogin ());
        cv.put ("Senha", usuario.getSenha ());
        cv.put ("Email", usuario.getEmail ());
        cv.put ("DataNascimento", usuario.getDataNascimento ());
        cv.put ("Sexo", usuario.getSexo ());

        dataBaseUtil.getConnection ().insert ("tb_Usuario", null, cv);
    }

    public void atualizar(UsuarioModel usuario) {

        ContentValues cv = new ContentValues ();
        cv.put ("Nome", usuario.getNome ());
        cv.put ("Login", usuario.getLogin ());
        cv.put ("Senha", usuario.getSenha ());
        cv.put ("Email", usuario.getEmail ());
        cv.put ("DataNascimento", usuario.getDataNascimento ());
        cv.put ("Sexo", usuario.getSexo ());

        dataBaseUtil.getConnection ().update ("tb_Usuario", cv, "idUsuario = ?", new String[]{Integer.toString (usuario.getCodigo ())});
    }

    public Integer excluir(int codigo) {
        return dataBaseUtil.getConnection ().delete ("tb_Usuario", "idUsuario = ?", new String[]{Integer.toString (codigo)});
    }

    public UsuarioModel getLogin2(UsuarioModel usuario) {
        UsuarioModel usuarioaux = new UsuarioModel ();
        String sql = "SELECT * FROM tb_Usuario WHERE Login = '" + usuario.getLogin ().toUpperCase ().trim () + "';";
        Cursor cursor = dataBaseUtil.getConnection ().rawQuery (sql, null);
        if (cursor.moveToFirst ()) {

            usuarioaux.setCodigo (cursor.getInt (cursor.getColumnIndex ("idUsuario")));
            usuarioaux.setNome (cursor.getString (cursor.getColumnIndex ("Nome")));
            usuarioaux.setLogin (cursor.getString (cursor.getColumnIndex ("Login")));
            usuarioaux.setSenha (cursor.getString (cursor.getColumnIndex ("Senha")));
            usuarioaux.setEmail (cursor.getString (cursor.getColumnIndex ("Email")));
            usuarioaux.setDataNascimento (cursor.getString (cursor.getColumnIndex ("DataNascimento")));
            usuarioaux.setSexo (cursor.getString (cursor.getColumnIndex ("Sexo")));
            cursor.close ();
        }

        if (usuario.getSenha ().equals (usuarioaux.getSenha ()) && usuario.getLogin ().equals (usuarioaux.getLogin ())) {
            return usuarioaux;
        } else {
            return null;
        }
    }


    public boolean getLogin(UsuarioModel usuario) {
        UsuarioModel usuarioaux = new UsuarioModel ();
        String sql = "SELECT * FROM tb_Usuario WHERE Login = '" + usuario.getLogin ().toUpperCase ().trim () + "';";
        Cursor cursor = dataBaseUtil.getConnection ().rawQuery (sql, null);
        if (cursor.moveToFirst ()) {

            usuarioaux.setCodigo (cursor.getInt (cursor.getColumnIndex ("idUsuario")));
            usuarioaux.setNome (cursor.getString (cursor.getColumnIndex ("Nome")));
            usuarioaux.setLogin (cursor.getString (cursor.getColumnIndex ("Login")));
            usuarioaux.setSenha (cursor.getString (cursor.getColumnIndex ("Senha")));
            usuarioaux.setEmail (cursor.getString (cursor.getColumnIndex ("Email")));
            usuarioaux.setDataNascimento (cursor.getString (cursor.getColumnIndex ("DataNascimento")));
            usuarioaux.setSexo (cursor.getString (cursor.getColumnIndex ("Sexo")));
            cursor.close ();
        }

        if (usuario.getSenha ().equals (usuarioaux.getSenha ()) && usuario.getLogin ().equals (usuarioaux.getLogin ())) {
            return true;
        } else {
            return false;
        }
    }

    public UsuarioModel getUsuario(int codigo) {

        UsuarioModel usuario = new UsuarioModel ();
        String sql = "SELECT * FROM tb_Usuario WHERE idUsuario = " + Integer.toString (codigo);
        Cursor cursor = dataBaseUtil.getConnection ().rawQuery (sql, null);
        cursor.moveToFirst ();

        usuario.setCodigo (cursor.getInt (cursor.getColumnIndex ("idUsuario")));
        usuario.setNome (cursor.getString (cursor.getColumnIndex ("Nome")));
        usuario.setLogin (cursor.getString (cursor.getColumnIndex ("Login")));
        usuario.setSenha (cursor.getString (cursor.getColumnIndex ("Senha")));
        usuario.setEmail (cursor.getString (cursor.getColumnIndex ("Email")));
        usuario.setDataNascimento (cursor.getString (cursor.getColumnIndex ("DataNascimento")));
        usuario.setSexo (cursor.getString (cursor.getColumnIndex ("Sexo")));
        cursor.close ();

        return usuario;
    }

    public List<UsuarioModel> getTodos() {

        List<UsuarioModel> usuarios = new ArrayList<> ();
        String sql = "SELECT * FROM tb_Usuario";
        Cursor cursor = dataBaseUtil.getConnection ().rawQuery (sql, null);

        while (cursor.moveToNext ()) {
            UsuarioModel usuario = new UsuarioModel ();

            usuario.setCodigo (cursor.getInt (cursor.getColumnIndex ("idUsuario")));
            usuario.setNome (cursor.getString (cursor.getColumnIndex ("Nome")));
            usuario.setLogin (cursor.getString (cursor.getColumnIndex ("Login")));
            usuario.setSenha (cursor.getString (cursor.getColumnIndex ("Senha")));
            usuario.setEmail (cursor.getString (cursor.getColumnIndex ("Email")));
            usuario.setDataNascimento (cursor.getString (cursor.getColumnIndex ("DataNascimento")));
            usuario.setSexo (cursor.getString (cursor.getColumnIndex ("Sexo")));
            usuarios.add (usuario);
        }
        cursor.close ();
        return usuarios;
    }


}
