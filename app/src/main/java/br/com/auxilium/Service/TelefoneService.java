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

import br.com.auxilium.Model.TelefoneModel;

public class TelefoneService {


    private RequestQueue meuQue;
    private StringRequest minhaStringRqs;
    private JsonArrayRequest jsArrayRequest;
    private String urlGetAll="https://localhost:44305/api/telefone";
    private String urlGetId="https://localhost:44305/api/telefone";
    private String urlPost="https://localhost:44305/api/telefone";
    private String urlPut="https://localhost:44305/api/telefone";
    private String urlDelete="https://localhost:44305/api/telefone";
    private TelefoneModel telefoneModelaux;
    private List<TelefoneModel> lista = new ArrayList<> ();

    public TelefoneService() {
        telefoneModelaux = new TelefoneModel ();
    }

    public TelefoneModel getTelefoneModelaux() {
        return telefoneModelaux;
    }

    public void setTelefoneModelaux(TelefoneModel telefoneModelaux) {
        this.telefoneModelaux = telefoneModelaux;
    }

    public List<TelefoneModel> getLista() {
        return lista;
    }

    public void setLista(List<TelefoneModel> lista) {
        this.lista = lista;
    }


    public void Put(final TelefoneModel telefone){

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
                params.put ("idTelefone",telefone.getIdtelefone ().toString ());
                params.put ("descricao", telefone.getDescricao ());

                return params;

            }
        };
        meuQue.add (putRequest);
    }


    public void Post(final Context context, final TelefoneModel telefone){

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
                params.put ("idTelefone",telefone.getIdtelefone ().toString ());
                params.put ("descricao", telefone.getDescricao ());

                return params;

            }
        };
        meuQue.add (post);
    }

    public void Delete(final Context context, final TelefoneModel telefone){


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
                params.put ("idTelefone",telefone.getIdtelefone ().toString ());
                params.put ("descricao", telefone.getDescricao ());

                return params;

            }
        };
        meuQue.add (dr);
    }


    public List<TelefoneModel> GetAll(final Context context, final TelefoneModel telefone){


        meuQue = Volley.newRequestQueue (context);
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetAll, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idTelefone");
                        String descricao = jsonObject.getString ("descricao");

                        telefoneModelaux.setIdtelefone (id);
                        telefoneModelaux.setDescricao (descricao);
                        lista.add (telefoneModelaux);
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

    public TelefoneModel GetId(final Context context, TelefoneModel telefone, String id){


        meuQue = Volley.newRequestQueue (context);
        urlGetId += id;
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetId, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idTelefone");
                        String descricao = jsonObject.getString ("descricao");

                        telefoneModelaux.setIdtelefone (id);
                        telefoneModelaux.setDescricao (descricao);

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
        return telefoneModelaux;
    }

}
