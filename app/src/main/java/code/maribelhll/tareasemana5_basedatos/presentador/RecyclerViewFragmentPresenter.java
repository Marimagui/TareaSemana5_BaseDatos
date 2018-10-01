package code.maribelhll.tareasemana5_basedatos.presentador;

import android.content.Context;

import java.util.ArrayList;

import code.maribelhll.tareasemana5_basedatos.db.ConstructorMascotas;
import code.maribelhll.tareasemana5_basedatos.fragmento.IRecyclerViewFragmentView;
import code.maribelhll.tareasemana5_basedatos.pojo.DatosMascotas;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<DatosMascotas> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptadorRecyclerView(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
