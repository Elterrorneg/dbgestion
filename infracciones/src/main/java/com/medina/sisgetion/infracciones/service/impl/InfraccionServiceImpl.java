package com.medina.sisgetion.infracciones.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medina.sisgetion.infracciones.entity.Infracciones;
import com.medina.sisgetion.infracciones.repository.InfraccionRepository;
import com.medina.sisgetion.infracciones.service.InfraccionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfraccionServiceImpl implements InfraccionService {
	@Autowired
	private InfraccionRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Infracciones> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Infracciones findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional
	public Infracciones create(Infracciones obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public Infracciones update(Infracciones obj) {
		try {
			Infracciones infraccionDb = findById(obj.getId());
			infraccionDb.setNombre(obj.getNombre());
			return repository.save(infraccionDb);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	public int delete(int id) {
		try {
			Infracciones infraccionDb = findById(id);
			if(infraccionDb == null) {
				return 0;
			}else {
				repository.delete(infraccionDb);
				return 1;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Infracciones findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {

			log.error(e.getMessage());
			throw e;
		}
	}

}
