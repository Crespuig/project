package com.project.entities;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.project.enums.Estado;
import com.project.enums.Motor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Coche")
public class Coche {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "marca")
	private String marca;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "matricula", unique = true)
	private String matricula;

	@Column(name = "precio")
	private float precio;

	@Column(name = "motor")
	private Motor motor;

	@Column(name = "estado")
	private Estado estado;

	@Column(name = "imagen")
	private String imagen;

	@CreatedDate
	@Column(name = "alta")
	@Temporal(TemporalType.DATE)
	private Date alta;

	@ManyToOne
	private UserHector propietario;

	@ManyToOne
	private Compra compra;

	public Coche() {

	}

	public Coche(String marca, String modelo, String matricula, float precio, Motor motor, Estado estado, String imagen,
			Date alta) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.precio = precio;
		this.motor = motor;
		this.estado = estado;
		this.imagen = imagen;
		this.alta = alta;
	}

	public Coche(String marca, String modelo, String matricula, float precio, String imagen, Date alta) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.precio = precio;
		this.imagen = imagen;
		this.alta = alta;
	}

	public Coche(String marca, String modelo, String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
	}

	public Coche(String marca, String modelo, String matricula, UserHector propietario) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.propietario = propietario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserHector getPropietario() {
		return propietario;
	}

	public void setPropietario(UserHector propietario) {
		this.propietario = propietario;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", precio="
				+ precio + ", motor=" + motor + ", estado=" + estado + ", imagen=" + imagen + ", alta=" + alta
				+ ", propietario=" + propietario + ", compra=" + compra + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alta == null) ? 0 : alta.hashCode());
		result = prime * result + ((compra == null) ? 0 : compra.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + id;
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
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
		Coche other = (Coche) obj;
		if (alta == null) {
			if (other.alta != null)
				return false;
		} else if (!alta.equals(other.alta))
			return false;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		if (estado != other.estado)
			return false;
		if (id != other.id)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (motor != other.motor)
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (propietario == null) {
			if (other.propietario != null)
				return false;
		} else if (!propietario.equals(other.propietario))
			return false;
		return true;
	}

}
