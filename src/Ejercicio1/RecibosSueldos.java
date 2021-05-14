package Ejercicio1;

import java.time.Month;

public class RecibosSueldos {
private int num;
private Month mes;
private double total;
private Empleado emp;
public RecibosSueldos(int num, Month mes, double total, Empleado emp) {
	super();
	this.num = num;
	this.mes = mes;
	this.total = total;
	this.emp=emp;
}
@Override
public String toString() {
	return "RecibosSueldos [num=" + num + ", mes=" + mes + ", total=" + total + ", emp=" + emp + "]";
}
}
