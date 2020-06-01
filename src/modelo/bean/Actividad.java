package modelo.bean;

import java.util.ArrayList;
import java.util.Date;

public class Actividad {
	private int id;
	private String nombre;
	private Date fecha_inicio;
	private String dias;
	private int horas;
	private int maxParticipantes;
	private double precio;
	
	private ArrayList<Inscripcion> iscripciones;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getMaxParticipantes() {
		return maxParticipantes;
	}
	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public ArrayList<Inscripcion> getIscripciones() {
		return iscripciones;
	}
	public void setIscripciones(ArrayList<Inscripcion> iscripciones) {
		this.iscripciones = iscripciones;
	}
	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nombre=" + nombre + ", fecha_inicio=" + fecha_inicio + ", dias=" + dias
				+ ", horas=" + horas + ", maxParticipantes=" + maxParticipantes + ", precio=" + precio
				+ ", iscripciones=" + iscripciones + "]";
	}
	
	
	

	
}
