package code.maribelhll.tareasemana5_basedatos.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import code.maribelhll.tareasemana5_basedatos.R;
import code.maribelhll.tareasemana5_basedatos.pojo.DatosMascotas;

public class ConstructorMascotas {

    private static final int LIKE = 1 ;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<DatosMascotas> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodasMascotas();
    }

    public void insertarCincoMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Cometa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_5l);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Bartolo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_2l);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Oso");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_3l);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Firulais");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_1l);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Chester");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro_4l);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota (DatosMascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA,mascotas.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES,LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascotas (DatosMascotas mascotas){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascotas);
    }

}
