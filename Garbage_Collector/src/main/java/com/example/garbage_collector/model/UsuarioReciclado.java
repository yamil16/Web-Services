package com.example.garbage_collector.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //
@Table (name="reciclados")//
public class UsuarioReciclado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="bottles", nullable = true)
	private int bottles = 0;
	
	@Column(name="tetrabriks", nullable = true)
	private int tetrabriks = 0;
	
	@Column(name="glass", nullable = true)
	private int glass = 0;
	
	@Column(name="paperboard", nullable = true)
	private int paperboard = 0;
	
	@Column(name="cans", nullable = true)
	private int cans = 0;
	
	@Column(name="id_r", nullable = false)
    private Long id_r;
	
	@Column(name = "date", nullable = true)
    private java.util.Date date;

	@OneToOne
	@JoinColumn(name = "id_r", referencedColumnName = "id", insertable = false, updatable = false)
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBottles() {
		return bottles;
	}

	public void setBottles(int bottles) {
		this.bottles = bottles;
	}

	public int getTetrabriks() {
		return tetrabriks;
	}

	public void setTetrabriks(int tetrabriks) {
		this.tetrabriks = tetrabriks;
	}

	public int getGlass() {
		return glass;
	}

	public void setGlass(int glass) {
		this.glass = glass;
	}

	public int getPaperboard() {
		return paperboard;
	}

	public void setPaperboard(int paperboard) {
		this.paperboard = paperboard;
	}

	public int getCans() {
		return cans;
	}

	public void setCans(int cans) {
		this.cans = cans;
	}

	public Long getId_r() {
		return id_r;
	}

	public void setId_r(Long id_r) {
		this.id_r = id_r;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bottles;
		result = prime * result + cans;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + glass;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_r == null) ? 0 : id_r.hashCode());
		result = prime * result + paperboard;
		result = prime * result + tetrabriks;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		UsuarioReciclado other = (UsuarioReciclado) obj;
		if (bottles != other.bottles)
			return false;
		if (cans != other.cans)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (glass != other.glass)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_r == null) {
			if (other.id_r != null)
				return false;
		} else if (!id_r.equals(other.id_r))
			return false;
		if (paperboard != other.paperboard)
			return false;
		if (tetrabriks != other.tetrabriks)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
