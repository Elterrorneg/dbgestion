package com.medina.sisgetion.infracciones.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="infracciones")
@EntityListeners(AuditingEntityListener.class)
public class Infracciones {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique = true,nullable = false, length = 100)
	private String nombre;
	@Column(name="dni",unique = true,nullable = false, length = 8)
	private String dni;
	
	@Column(name="fecha",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date fecha;
	
	@Column(name="placa",unique = true,nullable = false, length = 7)
	private String placa;
	
	@Column(name="infraccion",unique = true,nullable = false, length = 200)
	private String infraccion;
	
	@Column(name="descripcion",unique = true,nullable = false, length = 255)
	private String descripcion;
		
	@Column(name="create_at",nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createAt;
	
	@Column(name="update_at",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updateAt;
}
