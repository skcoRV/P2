/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Calendar;

/**
 *
 * @author Paul y Victor
 */
public class Traspaso {

    private Jugador jugador;
    private Equipo equipo_antiguo;
    private Equipo equipo_nuevo;
    private Calendar fecha_traspaso;
    private float importe_pagado;

    public Traspaso(Jugador jug, Equipo antiguo, Equipo nuevo, Calendar fecha, float importe) {
        jugador = jug;
        equipo_antiguo = antiguo;
        equipo_nuevo = nuevo;
        fecha_traspaso = fecha;
        importe_pagado = importe;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Equipo getEquipo_antiguo() {
        return equipo_antiguo;
    }

    public Equipo getEquipo_nuevo() {
        return equipo_nuevo;
    }

    public Calendar getFecha_traspaso() {
        return fecha_traspaso;
    }

    public float getImporte_pagado() {
        return importe_pagado;
    }

    
    @Override
    public String toString() {
        return 
                "\nJugador: " + jugador.getNombre()
                + "\nEquipo Origen: " + equipo_antiguo.getNombre_equipo()
                + "\nEquipo Destino: " + equipo_nuevo.getNombre_equipo()
                + "\nFecha del traspaso: " + fecha_traspaso.getTime()
                + "\nImporte pagado: " + importe_pagado;
    }
}
