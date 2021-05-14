package Ejercicio1;

import java.time.LocalDate;

public class Ventas {
private int nro;
private LocalDate fecha;
private double monto;
public Ventas() {
	super();
}
public Ventas(int nro, LocalDate fecha, double monto) {
	super();
	this.nro = nro;
	this.fecha = fecha;
	this.monto = monto;
}
public double getMonto() {
	return this.monto;
}



}
