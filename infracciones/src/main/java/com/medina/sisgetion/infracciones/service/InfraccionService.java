package com.medina.sisgetion.infracciones.service;

import java.util.List;

import com.medina.sisgetion.infracciones.entity.Infracciones;

public interface InfraccionService {
	public List<Infracciones> findAll();
	public Infracciones findById(int id);
	public Infracciones findByDni(String dni);
	public Infracciones create(Infracciones obj);
	public Infracciones update(Infracciones obj);
	public int delete(int id);
}
