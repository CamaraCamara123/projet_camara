package ma.ensa.inscription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.inscription.beans.Filiere;

public class AccueilActivity extends AppCompatActivity {

    private Button new_filire, new_user, list_filiere, list_user;
    private Intent intent;
    private String apiUrl = "http://10.0.2.2:8087/api/v1/filieres";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        new_filire = findViewById(R.id.new_filiere);
        new_user = findViewById(R.id.new_user);
        list_filiere = findViewById(R.id.list_filiere);
        list_user = findViewById(R.id.list_user);

        new_filire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(AccueilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Action à effectuer lorsque le bouton "new_user" est cliqué
                // Par exemple, ouvrir une nouvelle activité ou effectuer une action spécifique
            }
        });

        list_filiere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, apiUrl, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Log.d("resultat", response + "");
                                List<Filiere> filieres = parseJsonResponse(response);

                                intent = new Intent(AccueilActivity.this, FiliresListActivity.class);

                                List<String> filieresJsonList = new ArrayList<>();
                                for (Filiere filiere : filieres) {
                                    String filiereJson = convertFiliereToJson(filiere);
                                    filieresJsonList.add(filiereJson);
                                }

                                intent.putStringArrayListExtra("filiereList", (ArrayList<String>) filieresJsonList);


                                startActivity(intent);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("erreur", error + "");
                            }
                        });

                Volley.newRequestQueue(getApplicationContext()).add(jsonArrayRequest);
            }
        });

        list_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Action à effectuer lorsque le bouton "list_user" est cliqué
                // Par exemple, ouvrir une nouvelle activité ou effectuer une action spécifique
            }
        });
    }

    private String convertFiliereToJson(Filiere filiere) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", filiere.getId());
            jsonObject.put("code", filiere.getCode());
            jsonObject.put("libelle", filiere.getLibelle());
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Filiere convertJsonToFiliere(String filiereJson) {
        try {
            JSONObject jsonObject = new JSONObject(filiereJson);
            Long id = jsonObject.getLong("id");
            String code = jsonObject.getString("code");
            String libelle = jsonObject.getString("libelle");
            return new Filiere(id, code, libelle);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Filiere> parseJsonResponse(JSONArray response) {
        List<Filiere> filieres = new ArrayList<>();

        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject jsonObject = response.getJSONObject(i);
                Long id = jsonObject.getLong("id");
                String code = jsonObject.getString("code");
                String libelle = jsonObject.getString("libelle");

                Filiere filiere = new Filiere(id, code, libelle);
                filieres.add(filiere);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return filieres;
    }
}
