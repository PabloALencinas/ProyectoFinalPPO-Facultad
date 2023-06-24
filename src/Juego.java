
import java.util.*;

public class Juego {

    private Tablero tablero;

    private List <Jugador> jugadores = new ArrayList<Jugador> ();

    private boolean estadoDeJuego;

    public List <Jugador> jugadores() {
        return jugadores;
    }

    public Tablero tablero(){
        return tablero;
    }

    public void tablero(Tablero unTablero){
        this.tablero = unTablero;
    }

    public void inicializarTablero(){
        Tablero tablero = new Tablero();
        this.tablero = tablero;
    }

    public void unaJugada(Jugador unJugador){
        Figura figura = new Figura();
        figura.jugador(unJugador);
        boolean opcion = true;
        while(opcion == true){
            if(tablero.existeLugar(figura)){
                figura.elegirPuntoInicial();
                if(tablero.existeLugar(figura) == false){
                    System.out.println("Hay lugar en el tablero pero debe elegir otras coordenadas.");
                } else {
                    break;
                }
            } else {
                // Aca se muestran los resultados
                opcion = false;
                break;
            }
        }
        tablero.dibujarFigura(figura);
        tablero.mostrarTablero();
    }

    public int cantidadJugadores(){
        return jugadores.size();
    }

    public void agregarJugador(){
        if(this.cantidadJugadores() < 2){
            Jugador jugador = new Jugador();
            Scanner sc = new Scanner(System.in);
            if (this.cantidadJugadores() == 0){
                jugador.id(1);
            } else {
                jugador.id(2);
            }
            System.out.println("Ingrese su nombre.");
            String nombre = sc.nextLine();
            jugador.nombre(nombre);
            jugadores.add(jugador);
        }
    }

    public void jugar(){
        this.inicializarTablero();
        this.estadoDeJuego = true;
        while (estadoDeJuego == true){
            this.unaJugada(jugadores.get(0));
            this.unaJugada(jugadores.get(1));
        }
    }


}
