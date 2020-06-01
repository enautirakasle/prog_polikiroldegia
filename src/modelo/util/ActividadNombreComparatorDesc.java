package modelo.util;

import java.util.Comparator;

import modelo.bean.Actividad;

public class ActividadNombreComparatorDesc implements Comparator<Actividad> {

	@Override
	public int compare(Actividad o1, Actividad o2) {
		
		return o2.getNombre().compareToIgnoreCase(o1.getNombre());
		
//		if(o1.getNombre().compareToIgnoreCase(o2.getNombre())< 0) {
//			return 1;
//		}else if(o1.getNombre().compareToIgnoreCase(o2.getNombre()) > 0) {
//			return -1;
//		}else {
//			return 0;
//		}
		
		
			
	}

}
