
// Clase para instanciar un login para cada jugador.

public class Jugador {

    private int id;

    private String nombre;

    private int cantidadCasilleros;

    public void id(int unId){
        this.id = unId;
    }

    public void nombre(String unNombre){
        this.nombre = unNombre;
    }

    public void cantidadCasilleros(int unaCantidad){
        this.cantidadCasilleros = unaCantidad;
    }

    public int id(){
        return id;
    }

    public String nombre(){
        return nombre;
    }

    public int cantidadCasilleros(){
        return cantidadCasilleros;
    }

    public Jugador(){
        this.id = 1;
        this.nombre = "";
        this.cantidadCasilleros = 0;
    }

    public Jugador(int unId, String unNombre, int unaCantidad){
        this.id = unId;
        this.nombre = unNombre;
        this.cantidadCasilleros = unaCantidad;
    }

    @Override
    public String toString(){
        return "ID: " + id + "\nNombre: " + nombre + "\nCantidad de casilleros: " + cantidadCasilleros;
    }


}
