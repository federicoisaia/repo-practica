package Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class RRHH {
	private static int nro_recibo;

	public RRHH() {
		super();
		nro_recibo = 1;
	}
	

	
	public List<RecibosSueldos> generarRecibos(List<Empleado> listemp){
		ArrayList<RecibosSueldos> res= new ArrayList<RecibosSueldos>();
		for (Empleado emp: listemp) {
			res.add(new RecibosSueldos(nro_recibo,LocalDate.now().getMonth(),emp.sueldo(LocalDate.now()),emp ));
			nro_recibo++;
		}
		return res;
	}
}
