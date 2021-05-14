package Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		//int cuil, String nombre, LocalDate fechan, String mail,double horas_mes, double costo_hora, double obj_ventas
		EContratado e1= new EContratado(1,"Fede", LocalDate.now().minusMonths(7), "@mali1", 12, 100.0, 1000);
		EEnConvenio e2= new EEnConvenio (2, "marce",LocalDate.now(), "@mail2", 5,100.0);
		RRHH r1 = new RRHH();
		Ventas v1 = new Ventas(1,LocalDate.now(), 50.0);
		//lo ideal seria hacer un metodo veender(Ventas v) en empleado y que e.ventas sea private pero por cuestion de tiempo 
		//lo hago public para agregar las ventas directamente.
		e1.ventas.add(v1);
		e2.ventas.add(v1);
		ArrayList<Empleado> le = new ArrayList<Empleado>();
		le.add(e2);
		le.add(e1);
		System.out.println(r1.generarRecibos(le));
		
	}

}
