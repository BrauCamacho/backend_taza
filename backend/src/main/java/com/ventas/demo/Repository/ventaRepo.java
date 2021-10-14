package com.ventas.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.demo.modelo.venta;

public interface ventaRepo extends JpaRepository<venta, Integer>{

}
