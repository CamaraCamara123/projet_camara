package ma.ensa.inscription;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText code, libelle;
    private Button bnAdd;
    RequestQueue requestQueue;
    String insertUrl = "http://10.0.2.2:8087/api/v1/filieres";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = findViewById(R.id.code);
        libelle = findViewById(R.id.libelle);
        bnAdd = findViewById(R.id.bnAdd);

        bnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //Filiere filiere = new Filiere(code.getText().toString(), libelle.getText().toString());
        //Gson toJson()

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("code", code.getText().toString() );
            jsonBody.put("libelle", libelle.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                insertUrl, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("resultat", response+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Erreur", error.toString());
            }
        });
        requestQueue.add(request);

    }
}