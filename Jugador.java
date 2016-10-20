/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Paul y Victor
 */
public class Jugador {

    private String nombre;
    private String equipo;
    private String demarcacion;
    private float importe_clausula;
    private int id_jugador;

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }
    private static int contador_jugador = 1;

    public Jugador(String name, String team, String position, float money) {
        nombre = name;
        equipo = team;
        demarcacion = position;
        importe_clausula = money;
        id_jugador = contador_jugador;
        contador_jugador++;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getDemarcacion() {
        return demarcacion;
    }

    public float getImporte_clausula() {
        return importe_clausula;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setImporte_clausula(float importe_clausula) {
        this.importe_clausula = importe_clausula;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return 
                  "\nID Jugador: " + Integer.toString(id_jugador)
                + "\nNombre: " + nombre
                + "\nDemarcacion: " + demarcacion
                + "\nImporte clausula: " + Float.toString(importe_clausula);
    }

}
