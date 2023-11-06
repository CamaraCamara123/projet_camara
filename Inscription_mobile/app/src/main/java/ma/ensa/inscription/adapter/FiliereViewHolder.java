package ma.ensa.inscription.adapter;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import ma.ensa.inscription.R;

public class FiliereViewHolder extends RecyclerView.ViewHolder {

    EditText code, filiere_id,libelle;

    public FiliereViewHolder(@NonNull View itemView){
        super(itemView);
        code = itemView.findViewById(R.id.code);
        libelle = itemView.findViewById(R.id.libelle);
        filiere_id = itemView.findViewById(R.id.filiere_id);

        code.setEnabled(false);
        libelle.setEnabled(false);
        filiere_id.setEnabled(false);
    }
}
