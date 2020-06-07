package pruebas;

import modelo.dao.ModeloActividad;

public class Main {

	public static void main(String[] args) {
		ModeloActividad ma = new ModeloActividad();
		
		System.out.println(ma.selectAllConInscripciones());
		
	
		
	}

	
}
