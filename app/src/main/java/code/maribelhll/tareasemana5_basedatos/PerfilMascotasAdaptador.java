package code.maribelhll.tareasemana5_basedatos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import code.maribelhll.tareasemana5_basedatos.pojo.DatosMascotas;

public class PerfilMascotasAdaptador extends RecyclerView.Adapter<PerfilMascotasAdaptador.PerfilMascotasViewHolder>{

    ArrayList<DatosMascotas> perfilMascota;

    public PerfilMascotasAdaptador(ArrayList<DatosMascotas> perfilMascota){
        this.perfilMascota = perfilMascota;
    }

    @Override
    public PerfilMascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent,false);
        return new PerfilMascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilMascotasViewHolder perfilMascotasViewHolder, final int position) {
        final DatosMascotas perfil = perfilMascota.get(position);
        perfilMascotasViewHolder.imgFotoCVP.setImageResource(perfil.getFoto());
        perfilMascotasViewHolder.likesCVP.setText(perfil.getLikes());
    }

    @Override
    public int getItemCount() {
        return perfilMascota.size();
    }

    public static class PerfilMascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoCVP;
        private TextView likesCVP;

        public PerfilMascotasViewHolder(View itemView) {
            super(itemView);
            imgFotoCVP     = (ImageView) itemView.findViewById(R.id.imgFotoCVP);
            likesCVP     = (TextView) itemView.findViewById(R.id.txtNLikesCVP);
        }
    }

}

