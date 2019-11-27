package br.com.auxilium.Service;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;

import br.com.auxilium.Model.UsuarioModel;

public class UsuarioService {

    private RequestQueue meuQue;
    private StringRequest minhaStringRqs;
    private JsonArrayRequest jsArrayRequest;
    private String urlGetAll="https://localhost:44305/api/usuario";
    private String urlGetId="https://localhost:44305/api/usuario";
    private String urlPost="https://localhost:44305/api/usuario";
    private String urlPut="https://localhost:44305/api/usuario";
    private String urlDelete="https://localhost:44305/api/usuario";
    private UsuarioModel usuarioModel;
    private List<UsuarioModel> lista = new ArrayList<> ();

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }



}
