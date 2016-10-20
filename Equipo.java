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
    private float gastos_fijos;
    private float gastos_variables;
    private int id_equipo;
    private static int contador_equipo = 1;

    public Equipo(String team_name, float team_money, int clients, float gf, float ga) {
        nombre_equipo = team_name;
        importe_caja = team_money;
        numero_abonados = clients;
        jugadores = new ArrayList<>();
        gastos_fijos = gf;
        gastos_variables = ga;
        id_equipo = contador_equipo;
        contador_equipo++;
    }

    public void setGastos_fijos(float gastos_fijos) {
        this.gastos_fijos = gastos_fijos;
    }

    public void setGastos_variables(float gastos_variables) {
        this.gastos_variables = gastos_variables;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public float getGastos_fijos() {
        return gastos_fijos;
    }

    public float getGastos_variables() {
        return gastos_variables;
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
                + "\nNumero de abonados: " + Integer.toString(numero_abonados)
                + "\nGastos fijos anuales: " + Float.toString(gastos_fijos)
                + "\nGastos variables anuales: " + Float.toString(gastos_variables);
    }
}
