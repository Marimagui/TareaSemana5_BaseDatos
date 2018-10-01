package code.maribelhll.tareasemana5_basedatos.fragmento;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import code.maribelhll.tareasemana5_basedatos.R;
import code.maribelhll.tareasemana5_basedatos.adaptador.MascotasAdaptador;
import code.maribelhll.tareasemana5_basedatos.pojo.DatosMascotas;

public class PerfilFragment extends Fragment {

    ArrayList<DatosMascotas> perfilmascotas ;
    private RecyclerView listaMascotasP;
    public MascotasAdaptador adaptador;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotasP = (RecyclerView) v.findViewById(R.id.rvPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listaMascotasP.setLayoutManager(glm);
        InicializarMascotas1();
        InicializarAdaptador1();

        return v;
    }

    public void InicializarAdaptador1 (){
        adaptador = new MascotasAdaptador(perfilmascotas, getActivity());
        listaMascotasP.setAdapter(adaptador);
    }

    public void InicializarMascotas1 (){

        perfilmascotas = new ArrayList<DatosMascotas>();
        perfilmascotas.add(new DatosMascotas( R.drawable.perro_1l, 8));
        perfilmascotas.add(new DatosMascotas( R.drawable.perro_1l, 5));
        perfilmascotas.add(new DatosMascotas( R.drawable.perro_1l,10));
        perfilmascotas.add(new DatosMascotas( R.drawable.perro_1l, 2));
        perfilmascotas.add(new DatosMascotas( R.drawable.perro_1l, 4));
    }

}
