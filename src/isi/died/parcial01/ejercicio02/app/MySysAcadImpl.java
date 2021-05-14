package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.*;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo)throws GuardadoBDException, AlumnoNoLibreException {
		try {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		if(a.inscriptoNotLibre(m)) throw new AlumnoNoLibreException();
		a.addCursada(insc);
		m.addInscripcion(insc);
		DB.guardar(insc);
		}catch (BaseDeDatosExcepcion e) {
			throw new GuardadoBDException("No se pudo guardar la inscripcion a la cursada en la vase dee datos");
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}
	
	public void registrarNota(Examen e, int nota) {
		e.setNota(nota);
		if(nota>=6)e.getAlumno().actualizarEstadoMateria(e.getMateria());
		
	}
	public List<Examenes> topNExamenes(Alumno a, Integer nota){
		a.getExamenes().stream().filter(e->e.getNota()>nota).sorted((e1,e2)->e1.getNota().compareTo(e2.getNota())).collect(Collectors.toList());
	}
	

}
