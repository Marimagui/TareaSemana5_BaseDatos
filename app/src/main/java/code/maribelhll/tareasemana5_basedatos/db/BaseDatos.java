package code.maribelhll.tareasemana5_basedatos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import code.maribelhll.tareasemana5_basedatos.pojo.DatosMascotas;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID          +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE      +" TEXT, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO        +" INTEGER " +
                ")";

        String queryCrearTablaLikesMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID            +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA   + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES  + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + ") "+
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +ConstantesBaseDatos.TABLE_MASCOTAS_ID +" )"+
                ")";

        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<DatosMascotas> obtenerTodasMascotas (){
        ArrayList<DatosMascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            DatosMascotas mascotaActual = new DatosMascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLike = " SELECT COUNT (" +ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES + ") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registroLikes = db.rawQuery(queryLike, null);

            if(registroLikes.moveToNext()){
                mascotaActual.setLikes(registroLikes.getInt(0));
            } else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
    }

    public void insertarLikeMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS, null,contentValues);
        db.close();
    }

    public int obtenerLikesMascota(DatosMascotas mascotas){
        int likes = 0;

        String query = " SELECT COUNT ( " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "=" +mascotas.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

}
