package com.springboot.entity;



	import lombok.Getter;
	import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

	@Setter
	@Getter
	@Entity
	@Table(name = "roles")
	public class Role {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(length = 60)
	    private String name;
	}

