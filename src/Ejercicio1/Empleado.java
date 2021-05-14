package Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Empleado {
	protected int cuil;
	protected String nombre;
	protected LocalDate fecha_nacimiento;
	protected String email;
	public ArrayList<Ventas> ventas;
	
	@Override
	public String toString() {
		return "Empleado [cuil=" + cuil + ", nombre=" + nombre + "]";
	}
	public Empleado() {
		super();
	}
	public Empleado(int cuil, String nombre, LocalDate fecha_nacimiento, String email) {
		super();
		this.cuil = cuil;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.email = email;
		this.ventas = new ArrayList<Ventas>();
	}
	public abstract double sueldo(LocalDate fecha) ;
	
	

}
