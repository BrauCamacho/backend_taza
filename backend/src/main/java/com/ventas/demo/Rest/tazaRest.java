package com.ventas.demo.Rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ventas.demo.Service.tazaService;
import com.ventas.demo.modelo.taza;

@RestController
@RequestMapping("/taza/")
public class tazaRest {
	@Autowired
	private tazaService tazaService;
	
	@GetMapping
	private ResponseEntity<List<taza>> getAllTazas (){
		return ResponseEntity.ok(tazaService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<taza> saveTaza (@RequestBody taza taz){
		try {
			taza TazaGuardado = tazaService.save(taz);		
		return ResponseEntity.created(new URI("/taza/"+TazaGuardado.getId_taza())).body(TazaGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@DeleteMapping (value = "delete/{id_taza}")
	private ResponseEntity<Boolean> deleteTaza (@PathVariable ("id_taza") int id){
		tazaService.deleteById(id);
		return ResponseEntity.ok(!(tazaService.getById(id)!=null));
		
	}
}
