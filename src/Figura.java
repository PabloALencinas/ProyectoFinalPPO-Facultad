

import java.util.*;

        // Clase creada para instanciar una figura a insertar en el tablero

public class Figura {

    private int base;

    private int altura;

    private int inicioX;

    private int inicioY;

    public Jugador jugador;


    public void base(int unaBase){
        this.base = unaBase;
    }

    public void altura(int unaAltura){
        this.altura = unaAltura;
    }

    public void inicioX(int x){
        this.inicioX = x;
    }

    public void inicioY(int y){
        this.inicioY = y;
    }

    public void jugador(Jugador unJugador){
        this.jugador = unJugador;
    }

    public int base(){
        return base;
    }

    public int altura(){
        return altura;
    }

    public int inicioX(){
        return inicioX;
    }

    public int inicioY(){
        return inicioY;
    }

    public Figura(){
        Dados Dados = new Dados();
        this.base = Dados.dado1;
        this.altura = Dados.dado2;
        this.inicioX = 1;
        this.inicioY = 1;
        this.jugador = new Jugador();
    }

    public int obtenerArea(){
        return base*altura;
    }

    public void elegirPuntoInicial(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu figura es de base " + base + " y altura " + altura + " elija una coordenada x.");
        inicioX = sc.nextInt();
        System.out.println("Tu figura es de base " + base + " y altura " + altura + " elija una coordenada y.");
        inicioY = sc.nextInt();
    }

    @Override
    public String toString(){
        return "Base:" + base + "\nAltura:" + altura + "\nInicioX:" + inicioX + "\nInicioY:" + inicioY + "\nJugador:" + jugador;
    }

}
