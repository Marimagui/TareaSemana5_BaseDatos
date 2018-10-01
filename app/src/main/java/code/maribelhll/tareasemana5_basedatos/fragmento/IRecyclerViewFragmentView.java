package code.maribelhll.tareasemana5_basedatos.fragmento;

import java.util.ArrayList;

import code.maribelhll.tareasemana5_basedatos.adaptador.MascotasAdaptador;
import code.maribelhll.tareasemana5_basedatos.pojo.DatosMascotas;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical ();
    public MascotasAdaptador crearAdaptador (ArrayList<DatosMascotas> mascotas);
    public void inicializarAdaptadorRecyclerView (MascotasAdaptador adaptador);
}
