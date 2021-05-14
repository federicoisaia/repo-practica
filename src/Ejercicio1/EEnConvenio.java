package Ejercicio1;

import java.time.LocalDate;

public class EEnConvenio extends Empleado{
private int antiguedad;
private double sueldo_bas;
public EEnConvenio(int cuil, String nombre, LocalDate fechan, String mail, int antiguedad, double sueldo_bas) {
	super(cuil,nombre,fechan,mail);
	this.antiguedad = antiguedad;
	this.sueldo_bas = sueldo_bas;
}

public double sueldo(LocalDate fecha_sueldo) {
	double comision=0.0;
	for(Ventas Ven: this.ventas) {
		comision+=(Ven.getMonto()*0.3);
	}
	return (this.fecha_nacimiento.getMonth() == fecha_sueldo.getMonth())? this.sueldo_bas+comision*(1-(0.11+0.03))*1.5: (this.sueldo_bas+comision)*(1-(0.11+0.03));
}

}
