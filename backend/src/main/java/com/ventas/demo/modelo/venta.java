package com.ventas.demo.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class venta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_venta;
	private int id_taza;
	private int cantidad;
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public int getId_taza() {
		return id_taza;
	}
	public void setId_taza(int id_taza) {
		this.id_taza = id_taza;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public venta(int id_venta, int id_taza, int cantidad) {
		super();
		this.id_venta = id_venta;
		this.id_taza = id_taza;
		this.cantidad = cantidad;
	}
	public venta() {
		super();
	}
	
	
}
