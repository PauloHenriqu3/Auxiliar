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

import br.com.auxilium.Model.InstituicaoEnsinoModel;

public class InstituicaoEnsinoService {

    private RequestQueue meuQue;
    private StringRequest minhaStringRqs;
    private JsonArrayRequest jsArrayRequest;
    private String urlGetAll="https://localhost:44305/api/estado";
    private String urlGetId="https://localhost:44305/api/estado";
    private String urlPost="https://localhost:44305/api/estado";
    private String urlPut="https://localhost:44305/api/estado";
    private String urlDelete="https://localhost:44305/api/estado";
    private InstituicaoEnsinoModel instituicaoEnsinoAux;
    private List<InstituicaoEnsinoModel> lista = new ArrayList<> ();

    public InstituicaoEnsinoService() {
        instituicaoEnsinoAux = new InstituicaoEnsinoModel ();
    }

    public InstituicaoEnsinoModel getInstituicaoEnsinoAux() {
        return instituicaoEnsinoAux;
    }

    public List<InstituicaoEnsinoModel> getLista() {
        return lista;
    }

    public void setLista(List<InstituicaoEnsinoModel> lista) {
        this.lista = lista;
    }

    public void setInstituicaoEnsinoAux(InstituicaoEnsinoModel instituicaoEnsinoAux) {
        this.instituicaoEnsinoAux = instituicaoEnsinoAux;
    }

    public void Put(final InstituicaoEnsinoModel instituicao){

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
                params.put ("idInstituicaoEnsino",instituicao.getIdinstituicaoensino ().toString ());
                params.put ("nome", instituicao.getNome ());

                return params;

            }
        };
        meuQue.add (putRequest);
    }

    public void Post(final Context context, final InstituicaoEnsinoModel instituicao){

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
                params.put ("idInstituicaoEnsino",instituicao.getIdinstituicaoensino ().toString ());
                params.put ("nome", instituicao.getNome ());

                return params;

            }
        };
        meuQue.add (post);
    }

    public void Delete(final Context context, final InstituicaoEnsinoModel instituicao){


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
                params.put ("idInstituicaoEnsino",instituicao.getIdinstituicaoensino ().toString ());
                params.put ("nome", instituicao.getNome ());

                return params;

            }
        };
        meuQue.add (dr);
    }


    public List<InstituicaoEnsinoModel> GetAll(final Context context, final InstituicaoEnsinoModel instituicao){


        meuQue = Volley.newRequestQueue (context);
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetAll, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idInstituicaoEnsino");
                        String nome = jsonObject.getString ("nome");

                        instituicaoEnsinoAux.setIdinstituicaoensino (id);
                        instituicaoEnsinoAux.setNome (nome);
                        lista.add (instituicaoEnsinoAux);
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

    public InstituicaoEnsinoModel GetId(final Context context, InstituicaoEnsinoModel instituicao, String id){


        meuQue = Volley.newRequestQueue (context);
        urlGetId += id;
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetId, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idInstituicaoEnsino");
                        String nome = jsonObject.getString ("nome");

                        instituicaoEnsinoAux.setIdinstituicaoensino (id);
                        instituicaoEnsinoAux.setNome (nome);

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
        return instituicaoEnsinoAux;
    }

}

