package com.medina.sisgetion.infracciones.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medina.sisgetion.infracciones.entity.Infracciones;
import com.medina.sisgetion.infracciones.service.InfraccionService;


@RestController
@RequestMapping("/api/infracciones")
public class InfraccionApi {
	@Autowired
	private InfraccionService service;
	
	@GetMapping()
	public ResponseEntity<List<Infracciones>> getAll(){
		List<Infracciones> infracciones= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(infracciones);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Infracciones> getById(@PathVariable("id") int id) {
		Infracciones infracciones = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(infracciones);
	}
	
	@PostMapping
	public ResponseEntity<Infracciones> create(@RequestBody Infracciones infracciones) {
		Infracciones infraccionesDb=service.create(infracciones);
		return ResponseEntity.status(HttpStatus.CREATED).body(infraccionesDb);
	}
	
	@PutMapping
	public ResponseEntity<Infracciones> update(@RequestBody Infracciones infracciones) {
		Infracciones infraccionesDb=service.update(infracciones);
		return ResponseEntity.status(HttpStatus.OK).body(infraccionesDb);
	}
	
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public ResponseEntity<Infracciones> getOrEditById(@PathVariable("id") int id, @RequestBody(required = false) Infracciones infracciones) {
	    if (infracciones == null) {
	        // Si no se proporciona el cuerpo de la solicitud (null), entonces es una solicitud GET para obtener detalles
	    	Infracciones infraccionesDb = service.findById(id);
	        return ResponseEntity.status(HttpStatus.OK).body(infraccionesDb);
	    } else {
	        // Si se proporciona el cuerpo de la solicitud, entonces es una solicitud PUT para actualizar
	    	Infracciones infraccionesDb = service.update(infracciones);
	        return ResponseEntity.status(HttpStatus.OK).body(infraccionesDb);
	    }
	}

	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
