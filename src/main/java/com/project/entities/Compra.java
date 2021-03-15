package com.project.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Compra {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaCompra;
	
	@ManyToOne
	private UserHector propietario;

	public Compra() {
	}

	public Compra(UserHector propietario) {
		super();
		this.propietario = propietario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Calendar getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Calendar fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public UserHector getPropietario() {
		return propietario;
	}

	public void setPropietario(UserHector propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", fechaCompra=" + fechaCompra + ", propietario=" + propietario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
		result = prime * result + id;
		result = prime * result + ((propietario == null) ? 0 : propietario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (fechaCompra == null) {
			if (other.fechaCompra != null)
				return false;
		} else if (!fechaCompra.equals(other.fechaCompra))
			return false;
		if (id != other.id)
			return false;
		if (propietario == null) {
			if (other.propietario != null)
				return false;
		} else if (!propietario.equals(other.propietario))
			return false;
		return true;
	}
	
	
	
	
}
