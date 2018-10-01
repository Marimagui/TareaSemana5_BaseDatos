package code.maribelhll.tareasemana5_basedatos.fragmento;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import code.maribelhll.tareasemana5_basedatos.R;
import code.maribelhll.tareasemana5_basedatos.adaptador.MascotasAdaptador;
import code.maribelhll.tareasemana5_basedatos.pojo.DatosMascotas;
import code.maribelhll.tareasemana5_basedatos.presentador.IRecyclerViewFragmentPresenter;
import code.maribelhll.tareasemana5_basedatos.presentador.RecyclerViewFragmentPresenter;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    ArrayList<DatosMascotas> mascotas ;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotasAdaptador crearAdaptador(ArrayList<DatosMascotas> mascotas) {
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(MascotasAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

    }
}
