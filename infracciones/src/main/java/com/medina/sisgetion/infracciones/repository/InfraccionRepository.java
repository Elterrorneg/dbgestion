package com.medina.sisgetion.infracciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medina.sisgetion.infracciones.entity.Infracciones;


public interface InfraccionRepository extends JpaRepository<Infracciones, Integer>{
	public Infracciones findByDni(String dni);
}
