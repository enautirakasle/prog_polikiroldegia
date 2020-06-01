package modelo.util;

import java.util.Comparator;

import modelo.bean.Actividad;

public class ActividadFechaComparatorAsc implements Comparator<Actividad> {

	@Override
	public int compare(Actividad o1, Actividad o2) {

		return o1.getFecha_inicio().compareTo(o2.getFecha_inicio());
		
	}

}
