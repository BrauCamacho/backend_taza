package com.ventas.demo.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taza")
public class taza implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_taza;
	private String calidad;
	private String capacidad;
	private String modelo;
	private String material;
	private String color;
	private int stock;

	public int getId_taza() {
		return id_taza;
	}

	public void setId_taza(int id_taza) {
		this.id_taza = id_taza;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public taza(int id_taza, String calidad, String capacidad, String modelo, String material, String color,
			int stock) {
		super();
		this.id_taza = id_taza;
		this.calidad = calidad;
		this.capacidad = capacidad;
		this.modelo = modelo;
		this.material = material;
		this.color = color;
		this.stock = stock;
	}

	public taza() {
		super();
	}

	@Override
	public String toString() {
		return "taza [id_taza=" + id_taza + ", calidad=" + calidad + ", capacidad=" + capacidad + ", modelo=" + modelo
				+ ", material=" + material + ", stock=" + stock + "]";
	}

}
