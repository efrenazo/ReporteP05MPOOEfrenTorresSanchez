/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5;

public class Compra {
    public double monto;
    public Membresia membresia;
    public Dia dia;
    boolean esCumpleanos;

    public Compra(double monto, Membresia membresia, Dia dia, boolean esCumpleanos) {
        this.monto = monto;
        this.membresia = membresia;
        this.dia = dia;
        this.esCumpleanos = esCumpleanos;
    }

    public double calcularPrecio()
    {
        if (monto <= 0) {
            return -1;
        }

        double precio = monto;

        if (esCumpleanos)
        {
            // Cumpleaños: 50% y no se aplican los demás descuentos
            precio = precio * 0.50;
        }
        else
        {
            // Descuento por membresía (Plata: 5%, Oro: 8%, Diamante: 12%)
            switch (membresia)
            {
                case PLATA -> precio = precio * 0.95;
                case ORO -> precio = precio * 0.92;
                case DIAMANTE -> precio = precio * 0.88;
            }

            // Descuento por día de promoción (sobre lo ya rebajado)
            switch (dia)
            {
                case MARTES -> {
                    // Martes: Oro y Diamante tienen 10% adicional
                    if (membresia == Membresia.ORO || membresia == Membresia.DIAMANTE) {
                        precio = precio * 0.90;
                    }
                }
                case LUNES, JUEVES -> // Lunes y Jueves: 12% adicional para todas las membresías
                    precio = precio * 0.88;
                default -> {
                }
            }
        }

        return Math.round(precio * 100) / 100.0;
    }
}