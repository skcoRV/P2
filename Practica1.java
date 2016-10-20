/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Paul y Victor
 */
public class Practica1 {

    public static void main(String[] args) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        ArrayList<Traspaso> traspasos = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int opc;
                
        do {
            opc = 0;
            System.out.println("Bienvenido al menu del sistema. Elija una opcion:\n"
                    + "1. Registrar un nuevo equipo.\n"
                    + "2. Registrar un nuevo jugador.\n"
                    + "3. Registrar un traspaso de jugador.\n"
                    + "4. Listar en pantalla los datos de los equipos registrados.\n"
                    + "5. Listar los jugadores de cada equipo.\n"
                    + "6. Mostrar los traspasos realizados.\n"
                    + "7. Salir del programa.\n");
            String a = scan.next();

            if (pruebayagarra(a, 1)) {
                opc = Integer.parseInt(a);

                switch (opc) {
                    case 1:
                        Equipo equipoaux = registrarEquipo();
                        equipos.add(equipoaux);
                        break;
                    case 2:
                        registrarJugador(equipos);
                        break;
                    case 3:
                        registrarTraspaso(equipos, traspasos);
                        break;
                    case 4:
                        System.out.println("++++++++++++++++++++++++++++");
                        for (Equipo eaux : equipos) {
                            System.out.println(eaux);
                        }
                        System.out.println("++++++++++++++++++++++++++++");
                        break;
                    case 5:
                        System.out.println("++++++++++++++++++++++++++++");
                        for (Equipo eaux : equipos) {
                            System.out.println(eaux.getNombre_equipo());
                            eaux.mostrarJugadores();
                            System.out.println("++++++++++++++++++++++++++++");
                        }
                        break;
                    case 6:
                        mostrarTraspasos(traspasos);
                        break;
                    case 7:
                        escribirFichero(equipos, traspasos);
                        break;
                    default:
                        break;    
                }
            }
        } while (opc != 7);

        scan.close();

    }

    public static boolean pruebayagarra(String a, int tipo) {
        int i;
        float f;
        boolean b = true;

        try {
            if (tipo == 1) {
                i = Integer.parseInt(a);
            } else if (tipo == 2) {
                f = Float.parseFloat(a);
            }
        } catch (Exception e) {
            System.out.println("Error. Valor no numerico.");
            b = false;
        }
        return b;
    }

    public static Equipo registrarEquipo() {
        String aux;
        String nombre;
        float importe;
        float gastos_fijos;
        float gastos_variables;
        int clientes;
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el nombre del equipo.");
        nombre = scan.nextLine();

        System.out.println("Introduce el saldo del equipo.");
        aux = scan.next();
        pruebayagarra(aux, 2);
        importe = Float.parseFloat(aux);

        System.out.println("Introduce el numero de clientes del equipo.");
        aux = scan.next();
        pruebayagarra(aux, 1);
        clientes = Integer.parseInt(aux);
        
        System.out.println("Introduce los gastos fijos anuales.");
        aux = scan.next();
        pruebayagarra(aux, 2);
        gastos_fijos = Float.parseFloat(aux);
        
        System.out.println("Introduce los gastos fijos anuales.");
        aux = scan.next();
        pruebayagarra(aux, 2);
        gastos_variables = Float.parseFloat(aux);
        

        Equipo a = new Equipo(nombre, importe, clientes, gastos_fijos, gastos_variables);

        return a;
    }

    public static void registrarJugador(ArrayList<Equipo> equipos) {
        String nombre;
        String equipo;
        String demarcacion;
        Float importe_clausula;
        Scanner scan = new Scanner(System.in);
        String aux;
        int contador = 0;

        System.out.println("Introduce el nombre del jugador");
        nombre = scan.nextLine();

        System.out.println("Introduce el nombre del equipo");
        equipo = scan.nextLine();
        
        do{
        System.out.println("Introduce su posicion");
        demarcacion = scan.nextLine();
        }while(!demarcacion.matches("portero|delantero|defensa|medio"));
            
        System.out.println("Introduce el importe de su clausula");
        aux = scan.next();

        pruebayagarra(aux, 2);
        importe_clausula = Float.parseFloat(aux);

        Jugador jug = new Jugador(nombre, equipo, demarcacion, importe_clausula);

        for (Equipo eaux : equipos) {
            if (equipo.equals(eaux.getNombre_equipo())) {
                eaux.addJugador(jug);
                equipos.set(contador, eaux);
            }
            contador++;
        }
    }

    public static void registrarTraspaso(ArrayList<Equipo> equipos, ArrayList<Traspaso> traspasos) {
        Scanner scan = new Scanner(System.in);
        String nombre_jug;
        String equipo_origen;
        String equipo_destino;
        Jugador jug;
        int contador = 0;
        
        
        System.out.println("Introduce el nombre del equipo origen: ");
        equipo_origen = scan.nextLine();
        System.out.println("Introduce el nombre del jugador: ");
        nombre_jug = scan.nextLine();
        System.out.println("Introduce el nombre del equipo destino: ");
        equipo_destino = scan.nextLine();
        
        
        for (Equipo eaux : equipos) {
            
            if (equipo_origen.equals(eaux.getNombre_equipo())) {
                jug = eaux.getJugador(nombre_jug);
                
                if(jug != null){
                    int contador2 = 0;                
                    for (Equipo eaux2 : equipos) {
                        if (equipo_destino.equals(eaux2.getNombre_equipo())) {
                            float saldo_origen = eaux.getImporte_caja();
                            float saldo_destino = eaux2.getImporte_caja();
                            float clausula = jug.getImporte_clausula();                       

                            if(saldo_destino >= clausula){
                                eaux.setImporte_caja(saldo_origen + clausula);
                                eaux.removeJugador(jug);

                                System.out.println("\nIntroduzca la nueva clausula del jugador: ");
                                String nuevaclausula;
                                nuevaclausula = scan.nextLine();
                                pruebayagarra(nuevaclausula, 2);
                                clausula = Integer.parseInt(nuevaclausula);                                                       
                                jug.setImporte_clausula(clausula);

                                eaux2.addJugador(jug);
                                eaux2.setImporte_caja(saldo_destino - clausula);
                                equipos.set(contador, eaux);
                                equipos.set(contador2, eaux2);

                                System.out.println("\nIntroduzca el año: ");
                                int anyo = Integer.parseInt(scan.next());
                                System.out.println("\nIntroduzca el mes: ");
                                int mes = Integer.parseInt(scan.next());
                                System.out.println("\nIntroduzca el dia: ");
                                int dia = Integer.parseInt(scan.next());

                                Calendar fecha = Calendar.getInstance();
                                fecha.set(anyo, mes, dia);

                                Traspaso traspaso = new Traspaso(jug, eaux, eaux2, fecha, clausula);
                                traspasos.add(traspaso);
                            }
                        }
                        contador2++;
                    }
                }
            }
            contador++;
        }

    }

    public static void mostrarTraspasos(ArrayList<Traspaso> traspasos) {
        for (Traspaso traspasoaux : traspasos) {
            System.out.println(traspasoaux);
            System.out.println("\n*************************");
        }

    }
    
    public static void escribirFichero(ArrayList<Equipo> equipos, ArrayList<Traspaso> traspasos){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Introduzca el nombre del fichero"); 
        String nom_fich = scan.nextLine();
        File f;
        f = new File(nom_fich);
        try{
            FileWriter file_writer = new FileWriter(f);
            BufferedWriter buffered_writer = new BufferedWriter(file_writer);
            PrintWriter print_writer = new PrintWriter(buffered_writer);
            String equipos_fich = equipos.toString();
            String jugadores_fich = "";
            String traspasos_fich = traspasos.toString();
            for(Equipo eaux: equipos)
                equipos_fich += eaux.getJugadores().toString();

            print_writer.write("Equipos: \n" + equipos_fich);
            print_writer.append("Jugadores: \n" + jugadores_fich);
            print_writer.append("Trapsasos: \n" + traspasos_fich);

            print_writer.close();
            buffered_writer.close();
        }catch(IOException exception){};
        
        scan.close();
    }
}
