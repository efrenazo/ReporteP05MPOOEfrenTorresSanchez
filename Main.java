/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica5;

import java.util.Scanner;

/**
 *
 * @author irvin
 */
public class Main {
    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            
            do {
                System.out.println("1. Calcular compra");
                System.out.println("2. Salir");
                opcion = sc.nextInt();
                
                if (opcion == 1)
                {
                    System.out.println("Monto de la compra:");
                    double monto = sc.nextDouble();
                    
                    System.out.println("Membresia (1=Plata, 2=Oro, 3=Diamante):");
                    int numMembresia = sc.nextInt();
                    
                    Membresia membresia;
                    switch (numMembresia) {
                        case 1 -> membresia = Membresia.PLATA;
                        case 2 -> membresia = Membresia.ORO;
                        case 3 -> membresia = Membresia.DIAMANTE;
                        default -> {
                            System.out.println("Membresia invalida");
                            continue;
                        }
                    }
                    
                    System.out.println("Dia (1=Lunes, 2=Martes, 3=Miercoles, 4=Jueves, 5=Viernes, 6=Sabado, 7=Domingo):");
                    int numDia = sc.nextInt();
                    
                    Dia dia;
                    switch (numDia)
                    {
                        case 1 -> dia = Dia.LUNES;
                        case 2 -> dia = Dia.MARTES;
                        case 3 -> dia = Dia.MIERCOLES;
                        case 4 -> dia = Dia.JUEVES;
                        case 5 -> dia = Dia.VIERNES;
                        case 6 -> dia = Dia.SABADO;
                        case 7 -> dia = Dia.DOMINGO;
                        default -> {
                            System.out.println("Dia invalido");
                            continue;
                        }
                    }
                    
                    System.out.println("¿Es su cumpleaños? (s/n):");
                    boolean esCumpleanos = sc.next().equalsIgnoreCase("s");
                    
                    double precio = new Compra(monto, membresia, dia, esCumpleanos).calcularPrecio();
                    
                    if (precio == -1)
                    {
                        System.out.println("Monto invalido");
                    } else
                    {
                        System.out.println("Total a pagar: $" + precio);
                    }
                }
            } while (opcion != 2);
        }
    }
}