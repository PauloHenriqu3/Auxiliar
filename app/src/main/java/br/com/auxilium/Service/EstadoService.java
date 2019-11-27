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

import br.com.auxilium.Model.EstadoModel;

public class EstadoService {

    private RequestQueue meuQue;
    private StringRequest minhaStringRqs;
    private JsonArrayRequest jsArrayRequest;
    private String urlGetAll="https://localhost:44305/api/estado";
    private String urlGetId="https://localhost:44305/api/estado";
    private String urlPost="https://localhost:44305/api/estado";
    private String urlPut="https://localhost:44305/api/estado";
    private String urlDelete="https://localhost:44305/api/estado";
    private EstadoModel estadoModelaux;
    private List<EstadoModel> lista = new ArrayList<> ();

    public EstadoService() {
        estadoModelaux = new EstadoModel ();
    }

    public EstadoModel getEstadoModelaux() {
        return estadoModelaux;
    }

    public void setEstadoModelaux(EstadoModel estadoModelaux) {
        this.estadoModelaux = estadoModelaux;
    }

    public List<EstadoModel> getLista() {
        return lista;
    }

    public void setLista(List<EstadoModel> lista) {
        this.lista = lista;
    }

    public void Put(final EstadoModel estado){

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
                params.put ("idEstado",estado.getIdestado ().toString ());
                params.put ("sigla", estado.getSigla ().toString ());
                params.put ("descricao", estado.getDescricao ().toString ());

                return params;

            }
        };
        meuQue.add (putRequest);
    }

    public void Post(final Context context, final EstadoModel estado){

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
                params.put ("idEstado",estado.getIdestado ().toString ());
                params.put ("sigla", estado.getSigla ().toString ());
                params.put ("descricao", estado.getDescricao ().toString ());

                return params;

            }
        };
        meuQue.add (post);
    }

    public void Delete(final Context context, final EstadoModel estado){


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

                params.put ("idEstado",estado.getIdestado ().toString ());
                params.put ("sigla", estado.getSigla ().toString ());
                params.put ("descricao", estado.getDescricao ().toString ());

                return params;

            }
        };
        meuQue.add (dr);
    }

    public List<EstadoModel> GetAll(final Context context, EstadoModel estado){


        meuQue = Volley.newRequestQueue (context);
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetAll, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idEstado");
                        String descricao = jsonObject.getString ("descricao");
                        String sigla = jsonObject.getString ("sigla");

                        estadoModelaux.setIdestado (id);
                        estadoModelaux.setSigla (sigla);
                        estadoModelaux.setDescricao (descricao);
                        lista.add (estadoModelaux);
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

    public EstadoModel GetId(final Context context, final EstadoModel estado, String id){


        meuQue = Volley.newRequestQueue (context);
        urlGetId += id;
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetId, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idTipoUsuario");
                        String sigla = jsonObject.getString ("sigla");
                        String descricao = jsonObject.getString ("descricao");

                        estadoModelaux.setIdestado (id);
                        estadoModelaux.setSigla (sigla);
                        estadoModelaux.setDescricao (descricao);


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
        return estadoModelaux;
    }


}
