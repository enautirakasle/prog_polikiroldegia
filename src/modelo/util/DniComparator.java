package modelo.util;

import java.util.Comparator;

import modelo.bean.Usuario;

public class DniComparator implements Comparator<Usuario> {

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getDni().compareToIgnoreCase(o2.getDni());
		// return o1.getEdad() - o2.getEdad();

	}

}
