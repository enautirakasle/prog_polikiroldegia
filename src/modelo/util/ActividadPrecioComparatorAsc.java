package modelo.util;

import java.util.Comparator;

import modelo.bean.Actividad;

public class ActividadPrecioComparatorAsc implements Comparator<Actividad> {

	@Override
	public int compare(Actividad o1, Actividad o2) {
		
		if(o1.getPrecio() > o2.getPrecio()) {
			return 1;
		}else if(o1.getPrecio() < o2.getPrecio()) {
			return -1;
		}else {
			return 0;
		}
			
	}

}
