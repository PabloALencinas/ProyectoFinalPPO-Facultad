
import java.util.*;

public class Tablero {

    private int fila;

    private int columna;

    private int[][] estado;

    private List <Figura> figuras = new ArrayList<Figura> ();

    public void fila(int cantFilas){
        this.fila = cantFilas;
    }

    public void columna(int cantColumnas){
        this.columna = cantColumnas;
    }

    public int fila(){
        return fila;
    }

    public int columna(){
        return columna;
    }

    public int[][] estado(){
        return estado;
    }

    public List <Figura> figuras(){
        return figuras;
    }

    public void dimension(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cantidad de filas");
        fila = sc.nextInt()+1;
        System.out.println("Ingrese cantidad de columnas");
        columna = sc.nextInt()+1;
    }

    public void coordenadas(){
        int i,j;
        j = 0;
        for(i=0; i < fila; i++){
            estado[i][0] = j;
            j++;
        };
        j = 1;
        for(i=1; i < columna; i++){
            estado[0][i] = j;
            j++;
        }
    }

    public int contarFiguras(Jugador unJugador){
       int contador = 0;
       int i;
       for (i = 0; i < figuras.size(); i++){
           if (figuras.get(i).jugador.id() ==  unJugador.id()){
               contador++;
           }
       }
       return contador;
    }

    public boolean desborde(Figura unaFigura){
        return (unaFigura.inicioX() + unaFigura.base() - 1) > fila || (unaFigura.inicioY() + unaFigura.altura() - 1) > columna;
    }

    public boolean comprobar(Figura unaFigura){
        boolean bandera = true;
        if(this.desborde(unaFigura)){
            bandera = false;
            return bandera;
        } else {
            int i;
            int j;
            for (i = unaFigura.inicioX(); i < (unaFigura.inicioX() + unaFigura.base() - 1); i++){
                for (j = unaFigura.inicioY(); j < (unaFigura.inicioY() + unaFigura.base() - 1); j++){
                    if(estado[i][j] != 0){
                        bandera = false;
                        return bandera;
                    }
                }
            }
        }
        return bandera;
    }

    public boolean dibujarFigura(Figura unaFigura){
        boolean opcion = true;
        if (this.comprobar(unaFigura)){
            int i;
            int j;
            for (i = unaFigura.inicioX(); i < (unaFigura.inicioX() + unaFigura.base()) ; i++){
                for (j = unaFigura.inicioY(); j < (unaFigura.inicioY() + unaFigura.altura()); j++){
                    estado[j][i] = unaFigura.jugador.id();
                }
            }
            figuras.add(unaFigura);
            return opcion;
        } else {
            opcion = false;
            return opcion;
        }
    }

    public Tablero(){
        this.dimension();
        this.estado = new int[fila][columna];
        this.coordenadas();
    }

    public boolean existeLugar(Figura unaFigura){
        Figura figura = unaFigura;
        boolean bandera = false;
        int i;
        int j;
        for (i = 1; i < fila; i++){
            for (j = 1; j < columna; j++ ){
                if (this.comprobar(figura)){
                    bandera = true;
                    return bandera;
                }
            }
        }
        return bandera;
    }

    public void mostrarTablero(){
        int i;
        int j;
        for ( i = 0; i < fila; i++){
            for ( j = 0; j < columna; j++){
                System.out.print("  " + estado[i][j] + "  ");
            }
            System.out.println("\n");
        }
    }

    @Override
    public String toString(){
        return "fila: " + fila + "\nColumnas: " + columna + "\nFiguras:" + figuras;
    }

}
