package Ejercicio1;

import java.time.LocalDate;

public class EContratado extends Empleado{
	private double horas_mes;
	private double costo_hora;
	private double obj_ventas;

	public EContratado(int cuil, String nombre, LocalDate fechan, String mail,double horas_mes, double costo_hora, double obj_ventas) {
		super(cuil,nombre,fechan,mail);
		this.horas_mes = horas_mes;
		this.costo_hora = costo_hora;
		this.obj_ventas=obj_ventas;
	}
	
	public double sueldo( LocalDate fecha_sueldo) {
		double total_ventas=0.0;
		double aux=0.0;
		for(Ventas ven: this.ventas) {total_ventas+= ven.getMonto();}
		if (this.obj_ventas < total_ventas)aux=this.costo_hora*(5*this.ventas.size()+this.horas_mes);
		else aux= this.costo_hora*this.horas_mes;
		return (fecha_sueldo.getMonth()== this.fecha_nacimiento.getMonth())? aux*1.5 : aux;
	}

}
