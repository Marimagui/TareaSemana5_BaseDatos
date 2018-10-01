package code.maribelhll.tareasemana5_basedatos;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import code.maribelhll.tareasemana5_basedatos.adaptador.MascotasAdaptador;
import code.maribelhll.tareasemana5_basedatos.fragmento.IRecyclerViewFragmentView;
import code.maribelhll.tareasemana5_basedatos.pojo.DatosMascotas;
import code.maribelhll.tareasemana5_basedatos.presentador.IRecyclerViewFragmentPresenter;
import code.maribelhll.tareasemana5_basedatos.presentador.RecyclerViewFragmentPresenter;

public class MascotasLike extends AppCompatActivity implements IRecyclerViewFragmentView{

    ArrayList<DatosMascotas> mascotas ;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_like);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.MiActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, this);

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotasAdaptador crearAdaptador(ArrayList<DatosMascotas> mascotas) {
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRecyclerView(MascotasAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
