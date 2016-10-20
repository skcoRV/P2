/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;

/**
 *
 * @author Paul y Victor
 */
public class Equipo {

    private String nombre_equipo;
    private float importe_caja;
    private int numero_abonados;
    private ArrayList<Jugador> jugadores;
    private int id_equipo;
    private static int contador_equipo = 1;

    public Equipo(String team_name, float team_money, int clients) {
        nombre_equipo = team_name;
        importe_caja = team_money;
        numero_abonados = clients;
        jugadores = new ArrayList<>();
        id_equipo = contador_equipo;
        contador_equipo++;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public float getImporte_caja() {
        return importe_caja;
    }

    public int getNumero_abonados() {
        return numero_abonados;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setImporte_caja(float importe_caja) {
        this.importe_caja = importe_caja;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador j) {
        jugadores.add(j);
    }

    public Jugador getJugador(String nombre) {
        
        Jugador jugadoraux = null;
        int contador = 0;

        for (Jugador aux : jugadores) {
            if (aux.getNombre().equals(nombre)) {
                jugadoraux = jugadores.get(contador);
            }
            contador++;
        }

        return jugadoraux;
    }

    public void removeJugador(Jugador j) {
       
        jugadores.remove(j);
    }

    public void setNumero_abonados(int numero_abonados) {
        this.numero_abonados = numero_abonados;
    }

    public void mostrarJugadores() {
        for (Jugador jaux : jugadores) {
            System.out.println(jaux);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return 
                 "\nID Equipo: " + Integer.toString(id_equipo)
                + "\nNombre: " + nombre_equipo
                + "\nImporte: " + Float.toString(importe_caja)
                + "\nNumero de abonados: " + Integer.toString(numero_abonados);
    }
}
