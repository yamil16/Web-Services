package com.example.garbage_collector.model;

import java.io.Serializable;

public class TotalMaterial implements Serializable{

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		TotalMaterial other = (TotalMaterial) obj;
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
		return true;
	}

}
