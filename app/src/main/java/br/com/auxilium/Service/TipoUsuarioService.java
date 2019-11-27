package br.com.auxilium.Service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.auxilium.Model.TipoUsuarioModel;

public class TipoUsuarioService {

    private RequestQueue meuQue;
    private StringRequest minhaStringRqs;
    private JsonArrayRequest jsArrayRequest;
    private String urlGetAll="https://localhost:44305/api/tipousuario";
    private String urlGetId="https://localhost:44305/api/tipousuario";
    private String urlPost="https://localhost:44305/api/tipousuario";
    private String urlPut="https://localhost:44305/api/tipousuario";
    private String urlDelete="https://localhost:44305/api/tipousuario";
    private TipoUsuarioModel tipoUsuarioModelaux;
    final List<TipoUsuarioModel> lista = new ArrayList<> ();



    public TipoUsuarioService() {
        tipoUsuarioModelaux = new TipoUsuarioModel ();
    }

    public List<TipoUsuarioModel> getLista() {
        return lista;
    }

    public TipoUsuarioModel getTipoUsuarioModelaux() {
        return tipoUsuarioModelaux;
    }

    public void setTipoUsuarioModelaux(TipoUsuarioModel tipoUsuarioModelaux) {
        this.tipoUsuarioModelaux = tipoUsuarioModelaux;
    }

    public void Put(final TipoUsuarioModel tipo){

        StringRequest putRequest = new StringRequest (Request.Method.PUT,urlPut, new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                //Response
                Log.d ("Response", response);

            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Caso aconteca algum erro no Volley
                Log.d ("Error.Reponse", error.getMessage ().toString ());
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String> ();
                params.put ("idTipoUsuario",tipo.getIdtipousuario ().toString ());
                params.put ("descricao", tipo.getDescricao ().toString ());

                return params;

            }
        };
        meuQue.add (putRequest);
    }

    public void Post(final Context context, final TipoUsuarioModel tipo){

        StringRequest post = new StringRequest (Request.Method.POST, urlPost, new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                //Response
                Toast.makeText (context, response, Toast.LENGTH_LONG).show ();
            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d ("Erro.Reponse", error.getMessage ().toString ());
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String> ();
                params.put ("idTipoUsuario",tipo.getIdtipousuario ().toString ());
                params.put ("descricao", tipo.getDescricao ().toString ());

                return params;

            }
        };
        meuQue.add (post);
    }

    public void Delete(final Context context, final TipoUsuarioModel tipo){


        StringRequest dr = new StringRequest (Request.Method.DELETE, urlDelete, new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                //Response
                Toast.makeText (context, response, Toast.LENGTH_LONG).show ();
            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d ("Erro.Reponse", error.getMessage ().toString ());
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String> ();
                params.put ("idTipoUsuario",tipo.getIdtipousuario ().toString ());
                params.put ("descricao", tipo.getDescricao ().toString ());

                return params;

            }
        };
        meuQue.add (dr);
    }

    public List<TipoUsuarioModel> GetAll(final Context context, TipoUsuarioModel tipo){


        meuQue = Volley.newRequestQueue (context);
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetAll, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idTipoUsuario");
                        String descricao = jsonObject.getString ("descricao");

                        tipoUsuarioModelaux.setIdtipousuario (id);
                        tipoUsuarioModelaux.setDescricao (descricao);
                        lista.add (tipoUsuarioModelaux);
                    }
                } catch (JSONException ex) {
                    ex.printStackTrace ();
                }

            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TipoUsuarioService", "Erro no http");
            }
        });
        return lista;
    }

    public TipoUsuarioModel GetId(final Context context, TipoUsuarioModel tipo, String id){


        meuQue = Volley.newRequestQueue (context);
        urlGetId += id;
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetId, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idTipoUsuario");
                        String descricao = jsonObject.getString ("descricao");

                        tipoUsuarioModelaux.setIdtipousuario (id);
                        tipoUsuarioModelaux.setDescricao (descricao);

                    }
                } catch (JSONException ex) {
                    ex.printStackTrace ();
                }

            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TipoUsuarioService", "Erro no http");
            }
        });
        return tipoUsuarioModelaux;
    }





}
