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

import br.com.auxilium.Model.EnderecoModel;

public class EnderecoService {

    private RequestQueue meuQue;
    private StringRequest minhaStringRqs;
    private JsonArrayRequest jsArrayRequest;
    private String urlGetAll="https://localhost:44305/api/endereco";
    private String urlGetId="https://localhost:44305/api/endereco";
    private String urlPost="https://localhost:44305/api/endereco";
    private String urlPut="https://localhost:44305/api/endereco";
    private String urlDelete="https://localhost:44305/api/endereco";
    private EnderecoModel enderecoModelaux;
    private List<EnderecoModel> lista = new ArrayList<> ();

    public EnderecoService() {
        enderecoModelaux = new EnderecoModel ();
    }

    public EnderecoModel getEnderecoModelaux() {
        return enderecoModelaux;
    }

    public void setEnderecoModelaux(EnderecoModel enderecoModelaux) {
        this.enderecoModelaux = enderecoModelaux;
    }

    public List<EnderecoModel> getLista() {
        return lista;
    }

    public void setLista(List<EnderecoModel> lista) {
        this.lista = lista;
    }

    public void Put(final EnderecoModel endereco){

        urlPut += "/" +endereco.getIdEndereco ().toString ().trim ();

        minhaStringRqs = new StringRequest (Request.Method.PUT,urlPut, new Response.Listener<String> () {
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
                params.put ("idEndereco",endereco.getIdEndereco ().toString ());
                params.put ("endereco", endereco.getEndereco ());
                params.put ("bairro", endereco.getBairro ());
                params.put ("cidade", endereco.getCidade ());
                params.put ("numero", endereco.getNumero ());
                params.put ("cep", endereco.getCep ().toString ());
                params.put ("idEstado", endereco.getIdEstado ().toString ());

                return params;

            }
        };
        meuQue.add (minhaStringRqs);
    }

    public void Post(final Context context, final EnderecoModel endereco){

        urlPost += "/" +endereco.getIdEndereco ().toString ().trim ();

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
                params.put ("idEndereco",endereco.getIdEndereco ().toString ());
                params.put ("endereco", endereco.getEndereco ());
                params.put ("bairro", endereco.getBairro ());
                params.put ("cidade", endereco.getCidade ());
                params.put ("numero", endereco.getNumero ());
                params.put ("cep", endereco.getCep ().toString ());
                params.put ("idEstado", endereco.getIdEstado ().toString ());

                return params;

            }
        };
        meuQue.add (post);
    }

    public void Delete(final Context context, final EnderecoModel endereco){


        urlDelete += "/" +endereco.getIdEndereco ().toString ().trim ();

        minhaStringRqs = new StringRequest (Request.Method.DELETE, urlDelete, new Response.Listener<String> () {
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

                params.put ("idEndereco",endereco.getIdEndereco ().toString ());
                params.put ("endereco", endereco.getEndereco ());
                params.put ("bairro", endereco.getBairro ());
                params.put ("cidade", endereco.getCidade ());
                params.put ("numero", endereco.getNumero ());
                params.put ("cep", endereco.getCep ().toString ());
                params.put ("idEstado", endereco.getIdEstado ().toString ());

                return params;

            }
        };
        meuQue.add (minhaStringRqs);
    }

    public List<EnderecoModel> GetAll(final Context context, EnderecoModel estado){


        meuQue = Volley.newRequestQueue (context);
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetAll, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idEndereco");
                        String endereco = jsonObject.getString ("endereco");
                        String bairro = jsonObject.getString ("bairro");
                        String cidade = jsonObject.getString ("cidade");
                        String numero = jsonObject.getString ("numero");
                        Integer cep = jsonObject.getInt ("cep");
                        Integer idEstado = jsonObject.getInt ("idEstado");

                        enderecoModelaux.setIdEndereco (id);
                        enderecoModelaux.setEndereco (endereco);
                        enderecoModelaux.setBairro (bairro);
                        enderecoModelaux.setCep (cep);
                        enderecoModelaux.setCidade (cidade);
                        enderecoModelaux.setIdEstado (idEstado);
                        enderecoModelaux.setNumero (numero);

                        lista.add (enderecoModelaux);
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
        meuQue.add (jsArrayRequest);
        return lista;
    }

    public EnderecoModel GetId(final Context context, final EnderecoModel enderecoModel, String id){

        meuQue = Volley.newRequestQueue (context);
        urlGetId += id;
        jsArrayRequest = new JsonArrayRequest (Request.Method.GET, urlGetId, null, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length (); i++) {
                        JSONObject jsonObject = response.getJSONObject (i);

                        Integer id = jsonObject.getInt ("idEndereco");
                        String endereco = jsonObject.getString ("endereco");
                        String bairro = jsonObject.getString ("bairro");
                        String cidade = jsonObject.getString ("cidade");
                        String numero = jsonObject.getString ("numero");
                        Integer cep = jsonObject.getInt ("cep");
                        Integer idEstado = jsonObject.getInt ("idEstado");


                        enderecoModelaux.setIdEndereco (id);
                        enderecoModelaux.setEndereco (endereco);
                        enderecoModelaux.setBairro (bairro);
                        enderecoModelaux.setCep (cep);
                        enderecoModelaux.setCidade (cidade);
                        enderecoModelaux.setIdEstado (idEstado);
                        enderecoModelaux.setNumero (numero);
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
        meuQue.add (minhaStringRqs);
        return enderecoModelaux;
    }


}
