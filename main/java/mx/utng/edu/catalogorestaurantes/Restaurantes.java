package mx.utng.edu.catalogorestaurantes;

/**
 * Created by Elena Alvarado on 17/02/2018.
 */

public class Restaurantes {
    private int imageId;
    private String name;
    private String descripción;
    private String precio;

    public Restaurantes(int imageId, String name, String descripción, String precio){
        this.imageId=imageId;
        this.name=name;
        this.descripción=descripción;
        this.precio=precio;
    }



    public Restaurantes(){
        this(R.mipmap.ic_launcher_round, "unamed", "without description", "0.00");
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescripción() {
        return descripción;
    }

    public String getPrecio() {
        return precio;
    }
}


