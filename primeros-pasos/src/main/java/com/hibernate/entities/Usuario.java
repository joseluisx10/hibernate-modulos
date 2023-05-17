package com.hibernate.entities;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hibernate.interfaces.UtilidadesFecha;
@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	private String correo;
	private Blob clave;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_de_actualizacion")
	private Date fechaActualizacion;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_de_creacion")
	private Date fechaCreacion;

	public Usuario() {}

	public Usuario(String correo, Blob clave, Date fechaActualizacion, Date fechaCreacion) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.fechaActualizacion = fechaActualizacion;
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Usuario [correo=" +  correo + ", clave=" + clave + ", fechaActualizacion=" + fechaActualizacion
				+ ", fechaCreacion=" + UtilidadesFecha.getFechaAString(fechaCreacion) + "]";
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Blob getClave() {
		return clave;
	}

	public void setClave(Blob clave) {
		this.clave = clave;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
