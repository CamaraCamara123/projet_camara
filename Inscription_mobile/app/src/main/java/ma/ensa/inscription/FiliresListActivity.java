package ma.ensa.inscription;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.inscription.adapter.FiliereAdapter;
import ma.ensa.inscription.beans.Filiere;

public class FiliresListActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filires_list);

        RecyclerView recycle_view = findViewById(R.id.recycle_view_f);
        Intent intent = getIntent();
        if (intent != null) {
            List<Filiere> filieres = intent.getParcelableArrayListExtra("filiereList");
            if (filieres != null) {
                recycle_view.setLayoutManager(new LinearLayoutManager(this));
                recycle_view.setAdapter(new FiliereAdapter(getApplicationContext(),filieres));
            }

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
}