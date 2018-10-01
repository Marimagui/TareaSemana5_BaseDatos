package code.maribelhll.tareasemana5_basedatos.pojo;

public class DatosMascotas {

    private int id;
    private String nombre;
    private int foto;
    private int likes;

    public DatosMascotas(String nombre, int foto, int likes) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }

    public DatosMascotas (int foto, int likes){
        this.foto = foto;
        this.likes = likes;
    }

    public DatosMascotas() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
