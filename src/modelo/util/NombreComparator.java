package modelo.util;

import java.util.Comparator;

import modelo.bean.Usuario;

public class NombreComparator implements Comparator<Usuario> {

	@Override
	public int compare(Usuario u1, Usuario u2) {
		return u1.getNombreApellido().compareToIgnoreCase(u2.getNombreApellido());
		//xabier .compareTo(xabier)
	}

}
