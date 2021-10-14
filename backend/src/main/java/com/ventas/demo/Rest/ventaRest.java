package com.ventas.demo.Rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ventas.demo.Service.ventaService;
import com.ventas.demo.modelo.venta;


@RestController
@RequestMapping("/venta/")
public class ventaRest {
	@Autowired
	private ventaService Service;
	
	@GetMapping
	private ResponseEntity<List<venta>> getAllTazas (){
		return ResponseEntity.ok(Service.findAll());
	}
	@PostMapping
	private ResponseEntity<venta> saveVenta (@RequestBody venta taz){
		try {
			venta VentaGuardado = Service.save(taz);		
		return ResponseEntity.created(new URI("/venta/"+VentaGuardado.getId_venta())).body(VentaGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
}
