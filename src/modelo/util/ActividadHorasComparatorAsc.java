package modelo.util;

import java.util.Comparator;

import modelo.bean.Actividad;

public class ActividadHorasComparatorAsc implements Comparator<Actividad> {

	@Override
	public int compare(Actividad o1, Actividad o2) {
		
		return o1.getHoras() - o2.getHoras();
		
//		if(o1.getHoras()>o2.getHoras()) {
//			return 1;
//		}else if(o1.getHoras()<o2.getHoras()) {
//			return -1;
//		}else {
//			return 0;
//		}
		
		
	}

}
