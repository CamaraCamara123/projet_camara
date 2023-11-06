package ma.ensa.inscription.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ma.ensa.inscription.R;
import ma.ensa.inscription.beans.Filiere;

public class FiliereAdapter extends RecyclerView.Adapter<FiliereViewHolder> {

    Context context;
    List<Filiere> filieres;

    public FiliereAdapter(Context context, List<Filiere> filieres) {
        this.context = context;
        this.filieres = filieres;
    }

    @NonNull
    @Override
    public FiliereViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FiliereViewHolder(LayoutInflater.from(context).inflate(R.layout.filiere_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FiliereViewHolder holder, int position) {
        Object item =(Filiere) filieres.get(position);
        if (item instanceof Filiere) {
            Filiere filiere = (Filiere) item;
            holder.code.setText(filiere.getCode());
            holder.libelle.setText(filiere.getLibelle());
            holder.filiere_id.setText(String.valueOf(filiere.getId()));
        } else {
            Log.d("elt",item.toString());
        }
    }



    @Override
    public int getItemCount() {
        return filieres.size();
    }


}
