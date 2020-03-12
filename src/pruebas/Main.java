package pruebas;

import java.util.ArrayList;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

public class Main {

	public static void main(String[] args) {
		ModeloActividad ma = new ModeloActividad();
		
		ArrayList<Actividad> actividades = ma.selectAll();
		
		System.out.println(actividades);
		
	}

	
}
