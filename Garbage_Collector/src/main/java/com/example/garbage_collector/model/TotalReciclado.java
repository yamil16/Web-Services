package com.example.garbage_collector.model;

import java.io.Serializable;

public class TotalReciclado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name; 
	
	private int bottles;
	
	private int tetrabriks;
	
	private int glass;
	
	private int paperboard;
	
	private int cans;
	
	private static final float factor = (float) 0.45;
	
	private float toneladas;

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

	public float getToneladas() {
		return toneladas * factor;
	}

	public void setToneladas(float toneladas) {
		this.toneladas = toneladas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bottles;
		result = prime * result + cans;
		result = prime * result + glass;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + paperboard;
		result = prime * result + tetrabriks;
		result = prime * result + Float.floatToIntBits(toneladas);
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
		TotalReciclado other = (TotalReciclado) obj;
		if (bottles != other.bottles)
			return false;
		if (cans != other.cans)
			return false;
		if (glass != other.glass)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (paperboard != other.paperboard)
			return false;
		if (tetrabriks != other.tetrabriks)
			return false;
		if (Float.floatToIntBits(toneladas) != Float.floatToIntBits(other.toneladas))
			return false;
		return true;
	}

}
