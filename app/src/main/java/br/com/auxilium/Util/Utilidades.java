package br.com.auxilium.Util;

import android.app.AlertDialog;
import android.content.Context;

public class Utilidades {

    public static void Alert(Context context, String mensagem){
        ///Criando o alerta Dialogo
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Projeto Auxilium");
        alertDialog.setMessage(mensagem);

        alertDialog.setPositiveButton("Ok", null);
        alertDialog.show();
    }

}
